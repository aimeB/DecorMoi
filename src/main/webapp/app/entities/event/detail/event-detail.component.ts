import {Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {StripeService} from 'app/core/util/stripe.service';

import {IEvent, OrderStatus} from '../event.model';
import jsPDF from 'jspdf';
import {Account} from 'app/core/auth/account.model';
import {AccountService} from 'app/core/auth/account.service';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import * as dayjs from 'dayjs';
import {ImpactType} from 'app/entities/produit/produit.model';

@Component({
  selector: 'jhi-event-detail',
  templateUrl: './event-detail.component.html',
})
export class EventDetailComponent implements OnInit {
  event: IEvent | null = null;
  paymentHandler: any = null;
  //hide?: boolean;
  account?: Account | null = null;

  /**
   * 0 -> état est annulé => il ne telecharge rien
   * 1 -> en attente ou accepté => il telecharge un devis et peut payer maintenant
   * 2 -> payé => ne paye plus et peut telecharger la facture (et devis et payer disparaisse)
   */
  state?: number;

  @ViewChild('pdfElement') pdfElement: any;
  private readonly destroy$ = new Subject<void>();

  constructor(
    private accountService: AccountService,
    protected activatedRoute: ActivatedRoute,
    private stripeService: StripeService,
    private renderer: Renderer2,
    private el: ElementRef
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ event }) => {
      this.event = event;

      if (this.event) {
        if (this.event.orderStatus === OrderStatus.ACCEPTED) {
          this.state = 1;
        } else if (this.event.orderStatus === OrderStatus.PAYED) {
          this.state = 2;
        } else {
          //If it's pending or canceled, the client can't pay
          this.state = 0;
        }
        this.event.prix = (event?.prix);
      }
      //this.hide = !this.event?.checkout;
    });
    this.accountService
      .getAuthenticationState()
      .pipe(takeUntil(this.destroy$))
      .subscribe(account => (this.account = account));
  }

  previousState(): void {
    window.history.back();
  }

  makePayment() {
    this.stripeService.setEvent(this.event!);
    this.stripeService.processPayment();
  }

  generatePDF(typeDoc:string) {
    console.log(typeDoc)
    const data = [];
    const produits: string[] = [];
    this.event?.produits?.forEach(produit => {
      if (produit.impactPrice === ImpactType.PERSON) {
        produits.push(`${String(this.event?.nbPerson)} ${produit.nom!}`);
      } else if (produit.impactPrice === ImpactType.TABLE) {
        produits.push(`${String(this.event?.nbTable)} ${produit.nom!}`);
      } else {
        produits.push(`${produit.nom!}`);
      }
    });
    data.push({
      Nom: this.event?.nom,
      Date: this.event?.dateEvenement?.format('DD/MM/YYYY'),
      Type: this.event?.typeEvenement?.nom,
      Salle: this.event?.salle?.nom,
      Article: produits.join('\n'),
    });
    const header = ['Nom', 'Date', 'Type', 'Salle', 'Article'];
    const headerDisplay = ["Nom de l'évenement", "Date de l'évenement", "Type de l'évenement", 'Nom de la salle', 'Les articles'];
    const headerConfig = header.map((key, index) => ({
      name: key,
      prompt: headerDisplay[index],
      width: 40,
      align: 'center',
      padding: 90,
    }));
    const pdf = new jsPDF();
    pdf.setFontSize(12);
    pdf.setFont('calibri');
    if (this.account) {
      if (this.account.firstName && this.account.lastName && this.account.email) {
        pdf.text(`${this.account.firstName} ${this.account.lastName}`, 30, 20);
        pdf.text(`${this.account.email}`, 30, 26);
      }
    }

    const nomApp = "Decor'MOI";
    const address = 'Mettre une adresse';
    const city = '1200 Bruxelles';
    pdf.text(`${nomApp}\n${address}\n${city}`, 150, 40);
    const today = dayjs().format('DD/MM/YYYY');
    const typeDocument = (typeDoc==="devis")?"Aperçu du devis": "Voici votre facture";
    if(typeDoc==="facture"){
      pdf.text(`${nomApp} vous remercie de nous avoir fait confiance.`, 30, 60);
    }
    pdf.text(`${typeDocument}`, 30, 65);
    pdf.text(`Date : ${today}`, 30, 70);
    pdf.setFont('calibri');
    pdf.setFontSize(14);
    pdf.table(30, 75, data as any, headerConfig as any, {});
    const headerPrix = ['PrixHT', 'TVA', 'Prix'];
    const headerDisplayPrix = ['Prix HT', 'TVA', 'Coût total TTC'];
    const headerConfigPrix = headerPrix.map((key, index) => ({
      name: key,
      prompt: headerDisplayPrix[index],
      width: 40,
      align: 'center',
      padding: 90,
    }));
    if (this.event?.prix) {
      pdf.table(
        90,
        145,
        [
          {
            PrixHT: `${this.stripeService.removeTva(this.event.prix).toFixed(2)} €`,
            TVA: `21%`,
            Prix: `${this.event.prix.toFixed(2)} €`,
          },
        ],
        headerConfigPrix as any,
        {}
      );
    }
    try {
      if (this.account?.login) {

        pdf.save(`${typeDoc}-${this.account.login}.pdf`);
      }
    } catch (error) {
      console.log(error);
    }
  }
}

import {Injectable} from '@angular/core';
import {IEvent} from 'app/entities/event/event.model';
import {EventService} from 'app/entities/event/service/event.service';
import {Account} from '../auth/account.model';
import {AccountService} from '../auth/account.service';

@Injectable({
  providedIn: 'root',
})
export class StripeService {
 paymentHandler:any;
 private event!: IEvent;

 private publicKey = 'pk_test_51HAztbJ6SRr8q2B7Ct6XZAlC11I0PrJekh2NCdL5JL1f5XvMPsrRYJKdK5URtxNLzfQxPnIG3KwuTI0hBjnD15aU00p4Xja8Zy';
 private account!: Account;




 constructor(private accountService: AccountService, private eventService: EventService){
    this.accountService.identity().subscribe(account => {
        if (account) {
          this.account = account;
        }
      });
     this.invokeStripe();
 }

 public setEvent(event : IEvent){
  this.event = event;
}

source(data : any, cb : any) {
   cb();
}


 processPayment() {

    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: this.publicKey,
      locale: 'fr',
      currency:'EUR',
      source: (data: any) => this.source(data, ()=>{
        this.eventService.checkoutEvent(this.event).subscribe(res => {
          console.log(res)
        })
      })
    });

    paymentHandler.open({
      name: "Evenement : " +this.event.nom!,
      amount: (this.event.prix! * 100),
      email: this.account.email
    });
  }

  applyTva(amount:number){
    return amount * 1.21;
  }

  removeTva(amount:number){
    return amount / 1.21;
  }


  private invokeStripe() {
    if(!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement("script");
      script.id = "stripe-script";
      script.type = "text/javascript";
      script.src = "https://checkout.stripe.com/checkout.js";
      script.onload = () => {
        this.paymentHandler = (<any>window).StripeCheckout.configure({
          key: this.publicKey,
          locale: 'auto',
          source: (data: any) => this.source(data, () => {
           
          })
        });
      }
      window.document.body.appendChild(script);
    }
  }


}

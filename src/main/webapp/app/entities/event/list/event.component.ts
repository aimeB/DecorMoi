import {Component, OnInit} from '@angular/core';
import {HttpHeaders, HttpResponse} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {combineLatest, Observable} from 'rxjs';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

import {IEvent, OrderStatus} from '../event.model';

import {ASC, DESC, ITEMS_PER_PAGE, SORT} from 'app/config/pagination.constants';
import {EventService} from '../service/event.service';
import {FormBuilder} from '@angular/forms';
import {finalize} from 'rxjs/operators';
import {StripeService} from 'app/core/util/stripe.service';

@Component({
  selector: 'jhi-event',
  templateUrl: './event.component.html',
})
export class EventComponent implements OnInit {
  isSaving = false;

  events?: IEvent[];
  isLoading = false;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page?: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  colorsStatus: any = {
    "PENDING": "orange",
    "CANCELED": "red",
    "ACCEPTED": "green",
    "PAYED": "blue"
  }

  optionsOrderStatus = [
    {value:"PENDING"},
    {value:"CANCELED"},
    {value:"ACCEPTED"},
    {value:"PAYED"}
  ]

  editForm = this.fb.group({
    orderStatus: []
  });

  constructor(
    protected eventService: EventService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected modalService: NgbModal,
    protected fb: FormBuilder,
    protected stripeService : StripeService
  ) {
  }






  loadPage(page?: number, dontNavigate?: boolean): void {
    this.isLoading = true;
    const pageToLoad: number = page ?? this.page ?? 1;

    this.eventService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
      })
      .subscribe(
        (res: HttpResponse<IEvent[]>) => {
          this.isLoading = false;
          this.onSuccess(res.body, res.headers, pageToLoad, !dontNavigate);
        },
        () => {
          this.isLoading = false;
          this.onError();
        }
      );
  }

  ngOnInit(): void {
    this.handleNavigation();
  }

  trackId(index: number, item: IEvent): number {
    return item.id!;
  }

  delete(event : IEvent): void {
    if(window.confirm(`Voulez-vous supprimer l'événement ${event.nom!}?`)){
      this.eventService.delete(event.id!).subscribe(() => {
        this.loadPage();
      });
    }
  }

  onChangeOrderStatus(ev: Event, event: IEvent ) {
    const orderStatus = (<HTMLInputElement>ev.target).value;
    event.orderStatus = orderStatus as OrderStatus;
    this.isSaving = true;
    console.log(event)
    this.subscribeToSaveResponse(this.eventService.partialUpdate(event));
  }


  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEvent>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
  }



  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }


  protected sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? ASC : DESC)];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected handleNavigation(): void {
    combineLatest([this.activatedRoute.data, this.activatedRoute.queryParamMap]).subscribe(([data, params]) => {
      const page = params.get('page');
      const pageNumber = page !== null ? +page : 1;
      const sort = (params.get(SORT) ?? data['defaultSort']).split(',');
      const predicate = sort[0];
      const ascending = sort[1] === ASC;
      if (pageNumber !== this.page || predicate !== this.predicate || ascending !== this.ascending) {
        this.predicate = predicate;
        this.ascending = ascending;
        this.loadPage(pageNumber, true);
      }
    });
  }

  protected onSuccess(data: IEvent[] | null, headers: HttpHeaders, page: number, navigate: boolean): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    if (navigate) {
      this.router.navigate(['/event'], {
        queryParams: {
          page: this.page,
          size: this.itemsPerPage,
          sort: this.predicate + ',' + (this.ascending ? ASC : DESC),
        },
      });
    }
    this.events = data ?? [];
    this.ngbPaginationPage = this.page;
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page ?? 1;
  }
}

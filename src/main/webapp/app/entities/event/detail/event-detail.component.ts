import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StripeService } from 'app/core/util/stripe.service';

import { IEvent } from '../event.model';

@Component({
  selector: 'jhi-event-detail',
  templateUrl: './event-detail.component.html',
})
export class EventDetailComponent implements OnInit {
  event: IEvent | null = null;
  paymentHandler:any = null;
  hide?:boolean;

  constructor(protected activatedRoute: ActivatedRoute, private stripeService: StripeService) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ event }) => {
      this.event = event;
      this.hide = !this.event?.checkout;
    });
  }

  previousState(): void {
    window.history.back();
  }

  makePayment() {
    this.stripeService.setEvent(this.event!)
    this.stripeService.processPayment();
  }

}

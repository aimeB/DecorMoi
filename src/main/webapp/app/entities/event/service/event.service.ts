import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import * as dayjs from 'dayjs';

import {isPresent} from 'app/core/util/operators';
import {ApplicationConfigService} from 'app/core/config/application-config.service';
import {createRequestOption} from 'app/core/request/request-util';
import {getEventIdentifier, IEvent} from '../event.model';

export type EntityResponseType = HttpResponse<IEvent>;
export type EntityArrayResponseType = HttpResponse<IEvent[]>;

@Injectable({ providedIn: 'root' })
export class EventService {

  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/events');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(event: IEvent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(event);
    return this.http
      .post<IEvent>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  checkoutEvent(event: IEvent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(event);
    return this.http
      .put<IEvent>(`${this.resourceUrl}/checkout/${getEventIdentifier(event) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)))
  }


  update(event: IEvent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(event);
    return this.http
      .put<IEvent>(`${this.resourceUrl}/${getEventIdentifier(event) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  partialUpdate(event: IEvent): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(event);
    return this.http
      .patch<IEvent>(`${this.resourceUrl}/${getEventIdentifier(event) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }



  assignEvent(event: IEvent): Observable<HttpResponse<{}>> {
    return this.http
      .put<IEvent>(`${this.resourceUrl}-assign/${getEventIdentifier(event) as number}`, event.agentEvenements, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }



  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IEvent>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  findWithPercentage(): Observable<EntityResponseType> {
    return this.http
      .get<IEvent>(`${this.resourceUrl}/percentage`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IEvent[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addEventToCollectionIfMissing(eventCollection: IEvent[], ...eventsToCheck: (IEvent | null | undefined)[]): IEvent[] {
    const events: IEvent[] = eventsToCheck.filter(isPresent);
    if (events.length > 0) {
      const eventCollectionIdentifiers = eventCollection.map(eventItem => getEventIdentifier(eventItem)!);
      const eventsToAdd = events.filter(eventItem => {
        const eventIdentifier = getEventIdentifier(eventItem);
        if (eventIdentifier == null || eventCollectionIdentifiers.includes(eventIdentifier)) {
          return false;
        }
        eventCollectionIdentifiers.push(eventIdentifier);
        return true;
      });
      return [...eventsToAdd, ...eventCollection];
    }
    return eventCollection;
  }

  protected convertDateFromClient(event: IEvent): IEvent {
    return Object.assign({}, event, {
      dateEvenement: event.dateEvenement?.isValid() ? event.dateEvenement.toJSON() : undefined,
    });
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dateEvenement = res.body.dateEvenement ? dayjs(res.body.dateEvenement) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((event: IEvent) => {
        event.dateEvenement = event.dateEvenement ? dayjs(event.dateEvenement) : undefined;
      });
    }
    return res;
  }
}

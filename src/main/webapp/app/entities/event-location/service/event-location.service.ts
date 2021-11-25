import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { getEventLocationIdentifier, IEventLocation } from '../event-location.model';


export type EntityResponseType = HttpResponse<IEventLocation>;
export type EntityArrayResponseType = HttpResponse<IEventLocation[]>;

@Injectable({ providedIn: 'root' })
export class EventLocationService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/event-locations');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(eventLocation: IEventLocation): Observable<EntityResponseType> {
    return this.http.post<IEventLocation>(this.resourceUrl, eventLocation, { observe: 'response' });
  }


  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IEventLocation>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IEventLocation[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  

  addEventLocationToCollectionIfMissing(
    eventLocationCollection: IEventLocation[],
    ...eventLocationsToCheck: (IEventLocation | null | undefined)[]
  ): IEventLocation[] {
    const eventLocations: IEventLocation[] = eventLocationsToCheck.filter(isPresent);
    if (eventLocations.length > 0) {
      const eventLocationCollectionIdentifiers = eventLocationCollection.map(
        eventLocationItem => getEventLocationIdentifier(eventLocationItem)!
      );
      const eventLocationsToAdd = eventLocations.filter(eventLocationItem => {
        const eventLocationIdentifier = getEventLocationIdentifier(eventLocationItem);
        if (eventLocationIdentifier == null || eventLocationCollectionIdentifiers.includes(eventLocationIdentifier)) {
          return false;
        }
        eventLocationCollectionIdentifiers.push(eventLocationIdentifier);
        return true;
      });
      return [...eventLocationsToAdd, ...eventLocationCollection];
    }
    return eventLocationCollection;
  }
}

export interface IEventLocation {
  id?: number;
  nom?: string;
}

export class EventLocation implements IEventLocation {
  constructor(public id?: number, public nom?: string) {}
}

export function getEventLocationIdentifier(eventLocation: IEventLocation): number | undefined {
  return eventLocation.id;
}

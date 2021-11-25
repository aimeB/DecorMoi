import * as dayjs from 'dayjs';
import { IUser } from 'app/entities/user/user.model';
import { ITypeEvenement } from 'app/entities/type-evenement/type-evenement.model';
import { IProduit } from 'app/entities/produit/produit.model';
import { ISalle } from 'app/entities/salle/salle.model';
import { IEventLocation } from '../event-location/event-location.model';

export interface IEvent {
  id?: number;
  nom?: string;
  nbTable?: number;
  nbPerson?: number;
  dateEvenement?: dayjs.Dayjs;
  prix?: number | null;
  appartenantA?: IUser | null;
  eventLocation?: IEventLocation | null;
  agentEvenements?: IUser[] | null;
  typeEvenement?: ITypeEvenement;
  produits?: IProduit[] | null;
  salle?: ISalle;
  checkout?: boolean;
}

export class Event implements IEvent {
  constructor(
    public id?: number,
    public nom?: string,
    public nbTable?: number,
    public nbPerson?: number,
    public dateEvenement?: dayjs.Dayjs,
    public prix?: number | null,
    public eventLocation?: IEventLocation | null,
    public appartenantA?: IUser | null,
    public agentEvenements?: IUser[] | null,
    public typeEvenement?: ITypeEvenement,
    public produits?: IProduit[] | null,
    public salle?: ISalle,
    public checkout?:boolean
  ) {}
}

export function getEventIdentifier(event: IEvent): number | undefined {
  return event.id;
}

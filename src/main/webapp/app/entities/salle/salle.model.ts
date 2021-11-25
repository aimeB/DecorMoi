export interface ISalle {
  id?: number;
  nom?: string;
  capacity?:number;
}

export class Salle implements ISalle {
  constructor(public id?: number, public nom?: string, public capacity?: number) {}
}

export function getSalleIdentifier(salle: ISalle): number | undefined {
  return salle.id;
}

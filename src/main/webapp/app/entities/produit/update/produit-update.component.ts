import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { ImpactType, IProduit, Produit } from '../produit.model';
import { ProduitService } from '../service/produit.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import { EventManager, EventWithContent } from 'app/core/util/event-manager.service';
import { DataUtils, FileLoadError } from 'app/core/util/data-util.service';
import { ICategorieProduit } from 'app/entities/categorie-produit/categorie-produit.model';
import { CategorieProduitService } from 'app/entities/categorie-produit/service/categorie-produit.service';

@Component({
  selector: 'jhi-produit-update',
  templateUrl: './produit-update.component.html',
})
export class ProduitUpdateComponent implements OnInit {
  isSaving = false;

  categorieProduitsSharedCollection: ICategorieProduit[] = [];
  impactPriceProduitsSharedCollection: any = [];

  editForm = this.fb.group({
    id: [],
    nom: [null, [Validators.required]],
    description: [null, [Validators.required]],
    prix: [null, [Validators.required, Validators.min(0)]],
    quantity: [null, [Validators.required, Validators.min(0)]],
    impactPrice : [null, Validators.required],
    image: [null, [Validators.required]],
    imageContentType: [],
    categorie: [null, Validators.required],
  });

  constructor(
    protected dataUtils: DataUtils,
    protected eventManager: EventManager,
    protected produitService: ProduitService,
    protected categorieProduitService: CategorieProduitService,
    protected elementRef: ElementRef,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ produit }) => {
      this.updateForm(produit);
      console.log((produit))
      this.loadRelationshipsOptions();
      this.impactPriceProduitsSharedCollection = [
        {id:ImpactType.PERSON, nom: "Par personne"},
        {id:ImpactType.TABLE, nom: "Par table"},
        {id:ImpactType.ALONE, nom: "Une seule fois"}
      ]
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(base64String: string, contentType: string | null | undefined): void {
    this.dataUtils.openFile(base64String, contentType);
  }

  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe({
      error: (err: FileLoadError) =>
        this.eventManager.broadcast(new EventWithContent<AlertError>('decormoiApp.error', { ...err, key: 'error.file.' + err.key })),
    });
  }

  clearInputImage(field: string, fieldContentType: string, idInput: string): void {
    this.editForm.patchValue({
      [field]: null,
      [fieldContentType]: null,
    });
    if (idInput && this.elementRef.nativeElement.querySelector('#' + idInput)) {
      this.elementRef.nativeElement.querySelector('#' + idInput).value = null;
    }
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const produit = this.createFromForm();
    if (produit.id !== undefined) {
      this.subscribeToSaveResponse(this.produitService.update(produit));
    } else {
      this.subscribeToSaveResponse(this.produitService.create(produit));
    }
  }

  trackImpactPriceProduitById(index: number, item: ICategorieProduit): number {
    return item.id!;
  }

  trackCategorieProduitById(index: number, item: ICategorieProduit): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProduit>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(produit: IProduit): void {
    this.editForm.patchValue({
      id: produit.id,
      nom: produit.nom,
      description: produit.description,
      prix: produit.prix,
      quantity: produit.quantity,
      image: produit.image,
      imageContentType: produit.imageContentType,
      categorie: produit.categorie,
      impactPrice: produit.impactPrice
    });

    this.categorieProduitsSharedCollection = this.categorieProduitService.addCategorieProduitToCollectionIfMissing(
      this.categorieProduitsSharedCollection,
      produit.categorie
    );
  }

  protected loadRelationshipsOptions(): void {
    this.categorieProduitService
      .query()
      .pipe(map((res: HttpResponse<ICategorieProduit[]>) => res.body ?? []))
      .pipe(
        map((categorieProduits: ICategorieProduit[]) =>
          this.categorieProduitService.addCategorieProduitToCollectionIfMissing(categorieProduits, this.editForm.get('categorie')!.value)
        )
      )
      .subscribe((categorieProduits: ICategorieProduit[]) => (this.categorieProduitsSharedCollection = categorieProduits));
  }

  protected createFromForm(): IProduit {
    console.log("------>", this.editForm.value)
    return {
      ...new Produit(),
      id: this.editForm.get(['id'])!.value,
      nom: this.editForm.get(['nom'])!.value,
      description: this.editForm.get(['description'])!.value,
      prix: this.editForm.get(['prix'])!.value,
      quantity: this.editForm.get(['quantity'])!.value,
      imageContentType: this.editForm.get(['imageContentType'])!.value,
      image: this.editForm.get(['image'])!.value,
      categorie: this.editForm.get(['categorie'])!.value,
      impactPrice: this.editForm.get(['impactPrice'])!.value,
    };
  }
}

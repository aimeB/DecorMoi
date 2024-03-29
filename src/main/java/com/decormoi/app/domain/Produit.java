package com.decormoi.app.domain;

import com.decormoi.app.domain.enums.ImpactType;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Produit.
 */
@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "prix", nullable = false)
    private Double prix;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @Column(name = "image_content_type", nullable = false)
    private String imageContentType;

    @ManyToOne(optional = false)
    @NotNull
    private CategorieProduit categorie;

    @NotNull
    @Column(name = "impact_price", nullable = false)
    @Enumerated(EnumType.STRING)
    private ImpactType impactPrice;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;



    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNom() {
        return this.nom;
    }

    public Produit nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public ImpactType getImpactPrice() {
        return impactPrice;
    }

    public void setImpactPrice(ImpactType impactPrice) {
        this.impactPrice = impactPrice;
    }

    public String getDescription() {
        return this.description;
    }

    public Produit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public Double getPrix() {
        return this.prix;
    }

    public Produit prix(Double prix) {
        this.prix = prix;
        return this;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }




    public byte[] getImage() {
        return this.image;
    }

    public Produit image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }





    public String getImageContentType() {
        return this.imageContentType;
    }

    public Produit imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }






    public CategorieProduit getCategorie() {
        return this.categorie;
    }

    public Produit categorie(CategorieProduit categorieProduit) {
        this.setCategorie(categorieProduit);
        return this;
    }

    public void setCategorie(CategorieProduit categorieProduit) {
        this.categorie = categorieProduit;
    }





    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Produit)) {
            return false;
        }
        return id != null && id.equals(((Produit) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Produit{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", description='" + getDescription() + "'" +
            ", prix=" + getPrix() +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}

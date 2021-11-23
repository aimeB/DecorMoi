package com.decormoi.app.domain;

import com.decormoi.app.domain.enums.ImpactType;
import com.decormoi.app.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Event.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "date_evenement", nullable = false)
    private Instant dateEvenement;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "nb_person")
    private Integer nbPerson;

    @Column(name = "nb_table")
    private Integer nbTable;

<<<<<<< HEAD

=======
>>>>>>> 5fd55b5 (modification backend)
    @ManyToOne
    private User appartenantA;

    @ManyToOne
    private EventLocation eventLocation;
<<<<<<< HEAD


    @NotNull
    @Column(name = "checkout")
    private Boolean checkout = false;

    @ManyToOne
    private EventLocation eventLocation;


    @NotNull
    @Column(name = "checkout")
    private Boolean checkout = false;
=======
>>>>>>> 5fd55b5 (modification backend)

    @NotNull
    @Column(name = "checkout")
    private Boolean checkout = false;

    @ManyToMany
    @JoinTable(
        name = "rel_event__agent_evenement",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "agent_evenement_id")
    )
    private Set<User> agentEvenements = new HashSet<>();

    @NotNull
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(optional = false)
    @NotNull
    private TypeEvenement typeEvenement;

    @ManyToMany
    @JoinTable(
        name = "rel_event__produit",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    @JsonIgnoreProperties(value = { "categorie" }, allowSetters = true)
    private Set<Produit> produits = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private Salle salle;

<<<<<<< HEAD





=======
>>>>>>> 5fd55b5 (modification backend)
    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbPerson() {
        return nbPerson;
    }

    public Integer getNbTable() {
        return nbTable;
    }

    public void setNbPerson(Integer nbPerson) {
        this.nbPerson = nbPerson;
    }

    public void setNbTable(Integer nbTable) {
        this.nbTable = nbTable;
    }
<<<<<<< HEAD

=======
>>>>>>> 5fd55b5 (modification backend)

    public Event id(Long id) {
        this.id = id;
        return this;
    }





    public String getNom() {
        return this.nom;
    }
    public Event nom(String nom) {
        this.nom = nom;
        return this;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

<<<<<<< HEAD

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }
    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }


=======
    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }
>>>>>>> 5fd55b5 (modification backend)

    public Instant getDateEvenement() {
        return this.dateEvenement;
    }
    public Event dateEvenement(Instant dateEvenement) {
        this.dateEvenement = dateEvenement;
        return this;
    }
    public void setDateEvenement(Instant dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
<<<<<<< HEAD


    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
=======
>>>>>>> 5fd55b5 (modification backend)

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getCheckout() {
        return checkout;
    }

<<<<<<< HEAD
    public Boolean getCheckout() {
        return checkout;
    }



=======
>>>>>>> 5fd55b5 (modification backend)
    public void setCheckout(Boolean checkout) {
        this.checkout = checkout;
    }

    public Double getPrix() {
        return this.prix;
    }
    public Event prix(Double prix) {
        this.prix = prix;
        return this;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public User getAppartenantA() {
        return this.appartenantA;
    }
    public Event appartenantA(User user) {
        this.setAppartenantA(user);
        return this;
    }
    public void setAppartenantA(User user) {
        this.appartenantA = user;
    }

    //  AGENT
    public Set<User> getAgentEvenements() {
        return this.agentEvenements;
    }

    public Event agentEvenements(Set<User> users) {
        this.setAgentEvenements(users);
        return this;
    }
    public Event addAgentEvenement(User user) {
        this.agentEvenements.add(user);
        return this;
    }
    public Event removeAgentEvenement(User user) {
        this.agentEvenements.remove(user);
        return this;
    }
    public void setAgentEvenements(Set<User> users) {
        this.agentEvenements = users;
    }

    public TypeEvenement getTypeEvenement() {
        return this.typeEvenement;
    }
    public Event typeEvenement(TypeEvenement typeEvenement) {
        this.setTypeEvenement(typeEvenement);
        return this;
    }
    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

<<<<<<< HEAD


    // PRODUIT

=======
>>>>>>> 5fd55b5 (modification backend)
    public Set<Produit> getProduits() {
        return this.produits;
    }
    public Event produits(Set<Produit> produits) {
        this.setProduits(produits);
        return this;
    }
    public Event addProduit(Produit produit) {
        this.produits.add(produit);
        return this;
    }
    public Event removeProduit(Produit produit) {
        this.produits.remove(produit);
        return this;
    }
    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Salle getSalle() {
        return this.salle;
    }
    public Event salle(Salle salle) {
        this.setSalle(salle);
        return this;
    }
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        return id != null && id.equals(((Event) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Event{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", dateEvenement='" + getDateEvenement() + "'" +
            ", prix=" + getPrix() +
            ", nbPerson=" + getNbPerson() +
            ", nbTable=" + getNbTable() +
            "}";
    }
}

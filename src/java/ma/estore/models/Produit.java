package ma.estore.models;
// Generated 22 avr. 2020 11:12:31 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Produit generated by hbm2java
 */
@Entity
@Table(name="PRODUIT"
    ,schema="ESTORE"
)
@SequenceGenerator(name = "seq_prd",sequenceName = "seq_prd")
public class Produit  implements java.io.Serializable {


     private int idp;
     private Categorie categorie;
     private String libelle;
     private String marque;
     private int prix;
     private String description;
     private int fraisexpedition;
     private Boolean disponibilite;
     private int qtestck;
     private Date datePub;
     private Set<Promotion> promotions = new HashSet<Promotion>(0);
     private Set<Lignecommande> lignecommandes = new HashSet<Lignecommande>(0);
     private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);
     private Set<Wishlist> wishlists = new HashSet<Wishlist>(0);
     private List<Image> images = new ArrayList<Image>(0);

    public Produit() {
    }

	
    public Produit(int idp) {
        this.idp = idp;
    }
    public Produit(int idp, Categorie categorie, String libelle, String marque, int prix, String description, int fraisexpedition, Boolean disponibilite, int qtestck, Date datePub, Set<Promotion> promotions, Set<Lignecommande> lignecommandes, Set<Commentaire> commentaires, Set<Wishlist> wishlists, List<Image> images) {
       this.idp = idp;
       this.categorie = categorie;
       this.libelle = libelle;
       this.marque = marque;
       this.prix = prix;
       this.description = description;
       this.fraisexpedition = fraisexpedition;
       this.disponibilite = disponibilite;
       this.qtestck = qtestck;
       this.datePub = datePub;
       this.promotions = promotions;
       this.lignecommandes = lignecommandes;
       this.commentaires = commentaires;
       this.wishlists = wishlists;
       this.images = images;
    }
   
     @Id 

    @GeneratedValue(generator = "seq_prd",strategy = GenerationType.SEQUENCE)
    @Column(name="IDP", unique=true, nullable=false, precision=10, scale=0)
    public int getIdp() {
        return this.idp;
    }
    
    public void setIdp(int idp) {
        this.idp = idp;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDCAT")
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
    @Column(name="LIBELLE")
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    @Column(name="MARQUE")
    public String getMarque() {
        return this.marque;
    }
    
    public void setMarque(String marque) {
        this.marque = marque;
    }

    
    @Column(name="PRIX", precision=12)
    public int getPrix() {
        return this.prix;
    }
    
    public void setPrix(int prix) {
        this.prix = prix;
    }

    
    @Column(name="DESCRIPTION", length=1255)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="FRAISEXPEDITION", precision=12)
    public int getFraisexpedition() {
        return this.fraisexpedition;
    }
    
    public void setFraisexpedition(int fraisexpedition) {
        this.fraisexpedition = fraisexpedition;
    }

    
    @Column(name="DISPONIBILITE", precision=1, scale=0)
    public Boolean getDisponibilite() {
        return this.disponibilite;
    }
    
    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    
    @Column(name="QTESTCK", precision=4, scale=0)
    public int getQtestck() {
        return this.qtestck;
    }
    
    public void setQtestck(int qtestck) {
        this.qtestck = qtestck;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_PUB", length=7)
    public Date getDatePub() {
        return this.datePub;
    }
    
    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<Promotion> getPromotions() {
        return this.promotions;
    }
    
    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<Lignecommande> getLignecommandes() {
        return this.lignecommandes;
    }
    
    public void setLignecommandes(Set<Lignecommande> lignecommandes) {
        this.lignecommandes = lignecommandes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<Commentaire> getCommentaires() {
        return this.commentaires;
    }
    
    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="produits")
    public Set<Wishlist> getWishlists() {
        return this.wishlists;
    }
    
    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public List<Image> getImages() {
        return this.images;
    }
    
    public void setImages(List<Image> images) {
        this.images = images;
    }




}


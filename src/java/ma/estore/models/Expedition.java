package ma.estore.models;
// Generated 22 avr. 2020 11:12:31 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Expedition generated by hbm2java
 */
@Entity
@Table(name="EXPEDITION"
    ,schema="ESTORE"
)
@SequenceGenerator(name = "seq_exp",sequenceName = "seq_exp")
public class Expedition  implements java.io.Serializable {


     private int idex;
     private String moyenExpedition;
     private String numeroSuivi;
     private String etat;
     private Commande commande ;

    public Expedition() {
    }

	
    public Expedition(int idex) {
        this.idex = idex;
    }
    public Expedition(int idex, String moyenExpedition, String numeroSuivi, String etat, Commande commande) {
       this.idex = idex;
       this.moyenExpedition = moyenExpedition;
       this.numeroSuivi = numeroSuivi;
       this.etat = etat;
       this.commande = commande;
    }
   
     @Id 

    @GeneratedValue(generator = "seq_exp",strategy = GenerationType.SEQUENCE)
    @Column(name="IDEX", unique=true, nullable=false, precision=8, scale=0)
    public int getIdex() {
        return this.idex;
    }
    
    public void setIdex(int idex) {
        this.idex = idex;
    }

    
    @Column(name="MOYEN_EXPEDITION", length=100)
    public String getMoyenExpedition() {
        return this.moyenExpedition;
    }
    
    public void setMoyenExpedition(String moyenExpedition) {
        this.moyenExpedition = moyenExpedition;
    }

    
    @Column(name="NUMERO_SUIVI", length=100)
    public String getNumeroSuivi() {
        return this.numeroSuivi;
    }
    
    public void setNumeroSuivi(String numeroSuivi) {
        this.numeroSuivi = numeroSuivi;
    }

    
    @Column(name="ETAT", length=100)
    public String getEtat() {
        return this.etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="expedition")
    public Commande getCommande() {
        return this.commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }




}


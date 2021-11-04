
package ma.estore.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour payerCommande complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="payerCommande">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nocart" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="datevalid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crypto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mnt" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payerCommande", propOrder = {
    "nocart",
    "datevalid",
    "crypto",
    "mnt"
})
public class PayerCommande {

    protected long nocart;
    protected String datevalid;
    protected int crypto;
    protected float mnt;

    /**
     * Obtient la valeur de la propriété nocart.
     * 
     */
    public long getNocart() {
        return nocart;
    }

    /**
     * Définit la valeur de la propriété nocart.
     * 
     */
    public void setNocart(long value) {
        this.nocart = value;
    }

    /**
     * Obtient la valeur de la propriété datevalid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatevalid() {
        return datevalid;
    }

    /**
     * Définit la valeur de la propriété datevalid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatevalid(String value) {
        this.datevalid = value;
    }

    /**
     * Obtient la valeur de la propriété crypto.
     * 
     */
    public int getCrypto() {
        return crypto;
    }

    /**
     * Définit la valeur de la propriété crypto.
     * 
     */
    public void setCrypto(int value) {
        this.crypto = value;
    }

    /**
     * Obtient la valeur de la propriété mnt.
     * 
     */
    public float getMnt() {
        return mnt;
    }

    /**
     * Définit la valeur de la propriété mnt.
     * 
     */
    public void setMnt(float value) {
        this.mnt = value;
    }

}

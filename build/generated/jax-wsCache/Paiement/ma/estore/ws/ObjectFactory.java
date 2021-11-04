
package ma.estore.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ma.estore.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PayerCommandeResponse_QNAME = new QName("http://services.pk/", "payerCommandeResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://services.pk/", "helloResponse");
    private final static QName _PayerCommande_QNAME = new QName("http://services.pk/", "payerCommande");
    private final static QName _Hello_QNAME = new QName("http://services.pk/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ma.estore.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link PayerCommande }
     * 
     */
    public PayerCommande createPayerCommande() {
        return new PayerCommande();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link PayerCommandeResponse }
     * 
     */
    public PayerCommandeResponse createPayerCommandeResponse() {
        return new PayerCommandeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pk/", name = "payerCommandeResponse")
    public JAXBElement<PayerCommandeResponse> createPayerCommandeResponse(PayerCommandeResponse value) {
        return new JAXBElement<PayerCommandeResponse>(_PayerCommandeResponse_QNAME, PayerCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pk/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pk/", name = "payerCommande")
    public JAXBElement<PayerCommande> createPayerCommande(PayerCommande value) {
        return new JAXBElement<PayerCommande>(_PayerCommande_QNAME, PayerCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pk/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}

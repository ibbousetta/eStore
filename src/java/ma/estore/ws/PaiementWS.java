/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.estore.ws;

/**
 *
 * @author SE, Learn with practice
 */
public class PaiementWS {

    public static String payerCommande(long nocart, java.lang.String datevalid, int crypto, float mnt) {
        ma.estore.ws.Paiement_Service service = new ma.estore.ws.Paiement_Service();
        ma.estore.ws.Paiement port = service.getPaiementPort();
        return port.payerCommande(nocart, datevalid, crypto, mnt);
    }

   

    
   
    
}

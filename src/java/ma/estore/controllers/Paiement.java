/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.estore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.estore.dao.MyHibernateUtil;
import ma.estore.models.Adresse;
import ma.estore.models.Client;
import ma.estore.models.Commande;
import ma.estore.models.LignePanier;
import ma.estore.models.Lignecommande;
import ma.estore.models.Panier;
import ma.estore.ws.PaiementWS;
import org.hibernate.Session;

/**
 *
 * @author SE, Learn with practice
 */
@WebServlet(name = "Paiement", urlPatterns = {"/Paiement"})
public class Paiement extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Paiement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Paiement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long nocarte=Long.parseLong(request.getParameter("nocarte"));
        String datecarte=request.getParameter("datecarte");
        int crypto = Integer.parseInt(request.getParameter("crypto"));
        //if(nocarte.equals("123456789")&&datecarte.equals("12/21")&&crypto.equals("123")){
        Panier p=(Panier) request.getSession().getAttribute("panier");
        float mnt=0;
        for(LignePanier lp2:p.getItems()){
            mnt+=lp2.getQte()*lp2.getProduit().getPrix();
        }
        if(PaiementWS.payerCommande(nocarte, datecarte, crypto, mnt).startsWith("Ok")){
        
           String adresse1=request.getParameter("adresse1");
           String adresse2=request.getParameter("adresse2");
           String pays=request.getParameter("pays");
           String ville=request.getParameter("ville");
           String codepostale=request.getParameter("codepostale");
           Client clt=(Client) request.getSession().getAttribute("clt");
           Session s=MyHibernateUtil.getSession();
           clt=(Client) s.get(Client.class, clt.getIdc());
           Adresse ad=new Adresse(0,clt , adresse1, ville, Integer.parseInt(codepostale), pays, null);
           Commande cmd=new Commande(0, clt, null, ad, new Date(), "VISA", "en cours", new ArrayList<Lignecommande>(), null);
           
           for(LignePanier lp:p.getItems()){
               Lignecommande lc=new Lignecommande(0, lp.getProduit(), cmd, lp.getQte(), lp.getProduit().getPrix());
               cmd.getLignecommandes().add(lc);
               s.save(lc);
           }
           
           s.beginTransaction();
           s.save(ad);
           s.save(cmd);
           s.getTransaction().commit();
           request.getSession().removeAttribute("panier");
           request.setAttribute("msg", "votre commande est paye avec succes et sera expedier prochainement!");
           request.getRequestDispatcher("/views/mescommandes.jsp").forward(request, response);
           
        }else{
            request.setAttribute("msg", "information de paiement incorrecte!");
            request.getRequestDispatcher("/views/paiement.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

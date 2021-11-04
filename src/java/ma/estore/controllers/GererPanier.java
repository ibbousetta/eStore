/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.estore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.estore.models.Panier;

/**
 *
 * @author SE, Learn with practice
 */
@WebServlet(name = "GererPanier", urlPatterns = {"/GererPanier"})
public class GererPanier extends HttpServlet {

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
            out.println("<title>Servlet GererPanier</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GererPanier at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       int idp=Integer.parseInt(request.getParameter("idp"));
       
        Panier panier=null;
       if(request.getSession().getAttribute("panier")!=null){
           panier=(Panier)request.getSession().getAttribute("panier");
       }else{
           panier=new Panier();
       }
       
       if(action.equals("ajouter")){
           int qte=Integer.parseInt(request.getParameter("qte"));
           panier.addItem(idp, qte);
       }
       if(action.equals("augqte")){
           panier.augmenterQte(idp);
       }
       if(action.equals("dimqte")){
           panier.dimunierQte(idp);
       }
       if(action.equals("supp")){
           panier.supprimerProduit(idp);
       }
       
       request.getSession().setAttribute("panier", panier);
       request.getRequestDispatcher("/views/panier.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

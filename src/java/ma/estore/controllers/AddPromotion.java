/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.estore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.estore.dao.MyHibernateUtil;
import ma.estore.models.Produit;
import ma.estore.models.Promotion;
import org.hibernate.Session;

/**
 *
 * @author SE, Learn with practice
 */
@WebServlet(name = "AddPromotion", urlPatterns = {"/AddPromotion"})
public class AddPromotion extends HttpServlet {

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
            out.println("<title>Servlet AddPromotion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPromotion at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        try {
            int idp=Integer.parseInt(request.getParameter("idp"));
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date dd=sdf.parse(request.getParameter("dated"));
             Date df=sdf.parse(request.getParameter("datef"));
             int taux=Integer.parseInt(request.getParameter("taux"));
             Session s=MyHibernateUtil.getSession();
             Produit pr=(Produit) s.get(Produit.class,idp);
             Promotion p=new Promotion(0,pr,dd,df,taux);
             s.beginTransaction();
             s.save(p);
             s.getTransaction().commit();
             request.setAttribute("msg","Promotion ajoutee avec succes.");
             request.getRequestDispatcher("/views/listArticle.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddPromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
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

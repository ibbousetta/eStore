/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.estore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import ma.estore.dao.MyHibernateUtil;
import ma.estore.models.Categorie;
import ma.estore.models.Image;
import ma.estore.models.Produit;
import org.hibernate.Session;

/**
 *
 * @author SE, Learn with practice
 */
@MultipartConfig
@WebServlet(name = "AddProduit", urlPatterns = {"/AddProduit"})
public class AddProduit extends HttpServlet {

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
            out.println("<title>Servlet AddProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduit at " + request.getContextPath() + "</h1>");
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
        String libelle=request.getParameter("libelle");
        String description=request.getParameter("description");
        String marque=request.getParameter("marque");
        int prix=Integer.parseInt(request.getParameter("prix"));
        Long idcat=Long.parseLong(request.getParameter("cat"));
        int frais=Integer.parseInt(request.getParameter("frais"));
         int qte=Integer.parseInt(request.getParameter("qte"));
        boolean disponible=false;
        if(request.getParameter("disponible")!=null){
            disponible=true;
        }
        Part p1=request.getPart("img1");
        String filename=p1.getHeader("content-disposition");
            for(String s:filename.split(";")){
                if(s.trim().startsWith("filename")){
                    filename=s.substring(s.indexOf("=")+1).trim().replace("\"", "");
                    filename=filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
                }
            }
            p1.write(getServletContext().getRealPath("/images/produit/"+filename));
            Session s=MyHibernateUtil.getSession();
            s.beginTransaction();
            Categorie cat=(Categorie) s.get(Categorie.class, idcat);
            List<Image>images=new ArrayList<Image>();
            
            Produit p=new Produit(0, cat, libelle, marque, prix, description, frais, disponible,qte, new Date(), null, null, null, null, images);
            Image img1=new Image(0,p,filename,true);
            images.add(img1);
            s.save(img1);
            Part p2=request.getPart("img2");
            if(p2!=null){
            filename=p2.getHeader("content-disposition");
               for(String s2:filename.split(";")){
                   if(s2.trim().startsWith("filename")){
                       filename=s2.substring(s2.indexOf("=")+1).trim().replace("\"", "");
                       filename=filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
                   }
               }
            Image img2=new Image(0,p,filename,false);
            images.add(img2);
            s.save(img2);
            p2.write(getServletContext().getRealPath("/images/produit/"+filename));
            
            }
            Part p3=request.getPart("img3");
            if(p3!=null){
            filename=p3.getHeader("content-disposition");
               for(String s2:filename.split(";")){
                   if(s2.trim().startsWith("filename")){
                       filename=s2.substring(s2.indexOf("=")+1).trim().replace("\"", "");
                       filename=filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
                   }
               }
            Image img3=new Image(0,p,filename,false);
            images.add(img3);
            s.save(img3);
            p3.write(getServletContext().getRealPath("/images/produit/"+filename));
            }
            Part p4=request.getPart("img4");
            if(p4!=null){
            filename=p4.getHeader("content-disposition");
               for(String s2:filename.split(";")){
                   if(s2.trim().startsWith("filename")){
                       filename=s2.substring(s2.indexOf("=")+1).trim().replace("\"", "");
                       filename=filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
                   }
               }
            Image img4=new Image(0,p,filename,false);
            images.add(img4);
            s.save(img4);
            p4.write(getServletContext().getRealPath("/images/produit/"+filename));
            }
            s.save(p);
            s.getTransaction().commit();
            request.setAttribute("msg", "produit ajoute avec succes");
            request.getRequestDispatcher("/views/formAddProduit.jsp").forward(request, response);
            
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

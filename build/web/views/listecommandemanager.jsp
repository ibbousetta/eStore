<%-- 
    Document   : mescommandes
    Created on : 18 mai 2020, 11:14:30
    Author     : SE, Learn with practice
--%>

<%@page import="java.util.List"%>
<%@page import="ma.estore.models.Commande"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="ma.estore.dao.MyHibernateUtil"%>
<%@page import="ma.estore.models.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
          <%
              Client clt=(Client)session.getAttribute("clt");
            if(clt==null || !clt.getCompte().getRole().equals("manager")){
                request.setAttribute("msg","Il faut se connecter avec le role manager!");
                request.getRequestDispatcher("/views/formLogin.jsp").forward(request, response);
            }
            Client c=(Client)session.getAttribute("clt");
            
           %>
                                                 
                                                    
           <jsp:include page="header.jsp"></jsp:include>
           
           
           <%
           Session s=MyHibernateUtil.getSession();
           Query q=s.createQuery("Select c from Commande c where c.etat='en cours' or c.etat='expedie'");
          
           List<Commande> cmds=q.list();
           %>
           
           
            <section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Liste des  commandes en cours</li>
				</ol>
			</div>
                     <%
           if(request.getAttribute("msg")!=null){
            %>
            <h3 style="color: red"><%=request.getAttribute("msg")%></h3>
           <%
            }
            %>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">No decommande</td>
							
							<td class="price">Date</td>
							<td class="quantity">etat</td>
							<td class="total">Total</td>
                                                        
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <%for(Commande cmd:cmds){
                                                
                                            
                                           %>
						<tr>
							<td class="cart_product">
                                                            <%=cmd.getIdcmd()%>
							</td>
							
							<td class="cart_price">
								<%=cmd.getDatecmd()%>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
                                                                   <p><%=cmd.getEtat()%></p>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$<%=cmd.total()%></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="/eStore/views/detailCmd.jsp?idcmd=<%=cmd.getIdcmd()%>"><i class="fa fa-eye"></i></a>
                                                                <button class="cart_quantity_delete" data-toggle="modal" data-target="#expedierModal" data-idcmd="<%=cmd.getIdcmd()%>">Expedier</button>
							</td>
						</tr>

						<%}%>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
           
        
        <div class="modal fade" id="expedierModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <form action="/eStore/Expedier" method="post">
            <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Expedition de la commande :</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">ID Commande :</label>
            <input type="text" class="form-control" name='idcmd' id="idcmd">
          </div>
            <div class="form-group">
            <label for="recipient-name" class="col-form-label">Moyen d'expedition :</label>
            <input type="text" class="form-control" name="moyen">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Numero de suivi :</label>
            <textarea class="form-control" name="numsuivi"></textarea>
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
        <button type="submit" class="btn btn-primary">Enregistrer</button>
      </div>
    </div>
                </form>
  </div>
</div>
        <jsp:include page="footer.jsp"></jsp:include>
        
        <script>
            $('#expedierModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal
  var idcmd = button.data('idcmd'); // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this);
 
 $("#idcmd").val(idcmd);
})
            </script>
        
           
    </body>
</html>

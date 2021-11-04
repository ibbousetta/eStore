<%-- 
    Document   : listArticle
    Created on : 9 juin 2020, 09:23:27
    Author     : SE, Learn with practice
--%>

<%@page import="java.util.List"%>
<%@page import="ma.estore.models.Produit"%>
<%@page import="org.hibernate.Session"%>
<%@page import="ma.estore.dao.MyHibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <jsp:include page="header.jsp"></jsp:include>
        <section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
                      <%
            if(request.getAttribute("msg")!=null){
                %>
                <h3><%=request.getAttribute("msg")%></h3>
                <%
            }
            %>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Produit</td>
							<td class="description"></td>
							<td class="price">Prix</td>
							
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <%
                                                Session s=MyHibernateUtil.getSession();
                                                List<Produit> l=s.createQuery("From Produit").list();
                                                for(Produit p:l){
                                                
                                            
                                           %>
						<tr>
							<td class="cart_product">
                                                            <a href=""><img src="/eStore/images/produit/<%=p.getImages().get(0).getUrl()%>" width="50px" height="50px" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%=p.getLibelle()%></a></h4>
								
							</td>
							<td class="cart_price">
								<p>$<%=p.getPrix()%></p>
							</td>
							
							
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="/eStore/GererPanier?action=supp&idp=<%=p.getIdp()%>"><i class="fa fa-times"></i></a>
                                                                <button type="button" class="cart_quantity_delete" data-toggle="modal" data-target="#exampleModal" data-idp="<%=p.getIdp()%>"><i class="fa fa-money"></i></button>
                                                                
							</td>
						</tr>

						<%}%>
					</tbody>
				</table>
			</div>
		</div>
                                        
                                        
              <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
      
    <div class="modal-content">
        <form action="/eStore/AddPromotion" method="post">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nouvelle promotion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">IDP:</label>
            <input type="text" class="form-control" name="idp" id="idp" readonly="">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Date debut :</label>
            <input type="date" class="form-control" name="dated" id="dated">
          </div>
            <div class="form-group">
            <label for="message-text" class="col-form-label">Date Fin :</label>
            <input type="date" class="form-control" name="datef" id="datef">
          </div>
            <div class="form-group">
            <label for="message-text" class="col-form-label">Taux de la promotion :</label>
            <input type="number" class="form-control" name="taux" id="taux">
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Sauvegarder</button>
      </div>
        </form>
    </div>
  </div>
</div>                          
                                        
                                        
                                        
                                        
	</section> <!--/#cart_items-->
       
       <jsp:include page="footer.jsp"></jsp:include>
       
       <script>
           $('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var idp = button.data('idp') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('.modal-title').text('Nouvelle promotion pour le produit : ' + idp)
 $("#idp").val(idp);
})
           </script>
    </body>
</html>

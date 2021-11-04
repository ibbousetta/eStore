<%-- 
    Document   : paiement
    Created on : 18 mai 2020, 10:38:58
    Author     : SE, Learn with practice
--%>

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
				  <li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="step-one">
				<h2 class="heading">Step 2 : Paiement</h2>
			</div>
			

			<div class="register-req">
				<p>Payer votre commande en toute securite</p>
			</div><!--/register-req-->

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
                                                <%
                                                    if(request.getAttribute("msg")!=null){
                                                        %>
                                                        <h3 style="color: red"><%=request.getAttribute("msg")%></h3>
                                                        <%
                                                    }
                                                    %>
							<p>Donnees de votre carte visa</p>
                                                        <form action="/eStore/Paiement" method="post">
                                                            <input type="text" placeholder="Numero de la carte" name="nocarte">
								<input type="text" placeholder="date de validite" name="datecarte">
								<input type="text" placeholder="crypto" name="crypto">
								
                                                                <input type="hidden" name="adresse1" value="<%=request.getParameter("adresse1")%>">
                                                                <input type="hidden" name="adresse2" value="<%=request.getParameter("adresse2")%>">
                                                                <input type="hidden" name="ville" value="<%=request.getParameter("ville")%>">
                                                                <input type="hidden" name="pays" value="<%=request.getParameter("pays")%>">
                                                                <input type="hidden" name="codepostale" value="<%=request.getParameter("codepostale")%>">
							
                                                        <button  type="submit"  class="btn btn-primary" href="">Payer</button>
                                                        </form>
						</div>
					</div>
					
									
				</div>
			</div>
			

			
		</div>
	</section> <!--/#cart_items-->
        
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

<%-- 
    Document   : panier
    Created on : 11 mai 2020, 11:09:52
    Author     : SE, Learn with practice
--%>

<%@page import="ma.estore.models.Produit"%>
<%@page import="ma.estore.models.LignePanier"%>
<%@page import="ma.estore.models.Panier"%>
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
                         if(session.getAttribute("panier")==null){
                             %>
                             <h2>Votre panier est en core vide</h2>
                             <%
                         }else{
                                            Panier panier=(Panier)session.getAttribute("panier");
                                            
                                            %>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Produit</td>
							<td class="description"></td>
							<td class="price">Prix</td>
							<td class="quantity">Quantite</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <%for(LignePanier lp:panier.getItems()){
                                                
                                            Produit p=lp.getProduit();
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
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="/eStore/GererPanier?action=augqte&idp=<%=p.getIdp()%>"> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="<%=lp.getQte()%>" autocomplete="off" size="2">
									<a class="cart_quantity_down" href="/eStore/GererPanier?action=dimqte&idp=<%=p.getIdp()%>"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$<%=lp.getQte()*p.getPrix()%></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="/eStore/GererPanier?action=supp&idp=<%=p.getIdp()%>"><i class="fa fa-times"></i></a>
							</td>
						</tr>

						<%}%>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_option">
							<li>
								<input type="checkbox">
								<label>Use Coupon Code</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Use Gift Voucher</label>
							</li>
							<li>
								<input type="checkbox">
								<label>Estimate Shipping & Taxes</label>
							</li>
						</ul>
						<ul class="user_info">
							<li class="single_field">
								<label>Country:</label>
								<select>
									<option>United States</option>
									<option>Bangladesh</option>
									<option>UK</option>
									<option>India</option>
									<option>Pakistan</option>
									<option>Ucrane</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>
								
							</li>
							<li class="single_field">
								<label>Region / State:</label>
								<select>
									<option>Select</option>
									<option>Dhaka</option>
									<option>London</option>
									<option>Dillih</option>
									<option>Lahore</option>
									<option>Alaska</option>
									<option>Canada</option>
									<option>Dubai</option>
								</select>
							
							</li>
							<li class="single_field zip-field">
								<label>Zip Code:</label>
								<input type="text">
							</li>
						</ul>
						<a class="btn btn-default update" href="">Get Quotes</a>
						<a class="btn btn-default check_out" href="">Continue</a>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Le sous total du panier <span>$<%=panier.total()%></span></li>
							<li>Free d'expedition <span><%=panier.fraisexpedition()%></span></li>
							<li>Total <span>$<%=panier.fraisexpedition()+panier.total()%></span></li>
						</ul>
							<a class="btn btn-default update" href="">Update</a>
							<a href="/eStore/views/checkout.jsp"class="btn btn-default check_out" href="">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
<%}%>
        
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

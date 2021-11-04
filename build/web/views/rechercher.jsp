<%-- 
    Document   : rechercher
    Created on : 6 mai 2020, 11:15:05
    Author     : SE, Learn with practice
--%>

<%@page import="ma.estore.models.Produit"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="ma.estore.models.Categorie"%>
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
       <%Session s=MyHibernateUtil.getSession();
                     List<Categorie> lc=s.createQuery("from Categorie").list();
                                                        %>
       <section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Categorie</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							
							
							<%for(Categorie c : lc){	%>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="/eStore/views/rechercher.jsp?idc=<%=c.getIdcat()%>&mot="><%=c.getLibelle()%></a></h4>
								</div>
							</div>
							<%}%>
							
							
							
							
							
						</div><!--/category-products-->
					
						
						
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well text-center">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Resultat du recherche</h2>
                                                
                                                <%
                                                        String mot=request.getParameter("mot");
                                                        if(mot==null){
                                                            mot="";
                                                        }
                                                        String req="Select p from Produit p where lower(p.libelle) like '%"+mot.toLowerCase()+"%'";
                                                        if(request.getParameter("idc")!=null){
                                                            int idc=Integer.parseInt(request.getParameter("idc"));
                                                            req+=" and p.categorie.idcat="+idc;
                                                        }
                                                        Query q=s.createQuery(req);
                                                        
                                                        List<Produit>l=q.list();
                                                        if(l.size()==0){
                                                            %>
                                                            <h2>Aucun resultat trouve!!</h2>
                                                            <%
                                                        }else{
                                                        for(Produit p:l){
                                                        %>
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/eStore/images/produit/<%=p.getImages().get(0).getUrl()%>" alt="" />
										<h2>$<%=p.getPrix()%></h2>
										<p><%=p.getLibelle()%></p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$<%=p.getPrix()%></h2>
											<p><%=p.getLibelle()%></p>
                                                                                        <a href="/eStore/views/detailProduit.jsp?idp=<%=p.getIdp()%>" class="btn btn-default add-to-cart"><i class="fa fa-plus-square"></i>Detail du produit</a>
											<a href="/eStore/GererPanier?action=ajouter&idp=<%=p.getIdp()%>&qte=1" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
										</div>
									</div>
									
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						
                                                        <%}
                                                        
                                                        }%>
                                                        
					</div><!--features_items-->
					
					
					
				</div>
			</div>
		</div>
	</section>
       
       
       <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

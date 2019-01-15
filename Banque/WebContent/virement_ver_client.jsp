<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<head>
		<meta charset = "UTF-8">
		<title>Virement_Vers</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" type="text/css" href="./css/virement_client.css">	
	</head>
    <body>
<div class="head" id="head">
		<div class="navigateur">
		<ul>
  			<li><a href="#home" class="active">Particuliers</a></li>  
    		<li><a href="#">Banque privée</a></li>
  			<li><a href="#">Professionnels</a></li>
  			<li><a href="#">Entreprises</a></li>
  	 		<li><a href="#">Associations</a></li>
		</ul>
		</div>
		<div class="navigateur1">
		<ul>
			<li style='float:left'><div class="icon"><img src="images/icon.png"/></div></li>
			<li style='float:left'><h2><a href="http://localhost:8090/Banque/accueil.jsp">AEDI Banque</a></h2></li>
			<li style='float:right'><a href="logout"><div class ="roundRectangle1"> Se déconnecter</div></a></li>
			<li style='float:right'><a href="inscription.jsp"><div class ="roundRectangle">Ouvrir un compte</div></a></li>
		</ul>
		</div>
    		<div class="container" >
  				<input type="text" placeholder="Recherche...">
  			<div class="search"></div>
			</div>
			
 	 </div>
  
<div class="centre" id="centre">
			<div class="panel-carte">
  				<div class='carte-couverture'>
    				<a href='#'>
      				<div class="carte1 bg-01">
        			<span class='carte-contenu'>Gérer ses comptes</span>
      				</div>
    				</a>
  				</div>
  				<div class="carte-couverture">
    				<a href='#'>
      				<div class="carte2 bg-02">
        			<span class='carte-contenu'>Emprunter</span>
      				</div>
    				</a>
  				</div>
  				<div class="carte-couverture">
    				<a href='#'>
      				<div class="carte3 bg-03">
        			<span class='carte-contenu'>Assurer et sécuriter</span>
      				</div>
    				</a>
  				</div>
  				<div class="carte-couverture">
   			 		<a href='#'>
      				<div class="carte4 bg-04">
       			 	<span class='carte-contenu'>Épargner</span>
      				</div>
    				</a>
  					</div>
  				<div class="carte-couverture">
    				<a href='#'>
      				<div class="carte5 bg-05">
        			<span class='carte-contenu'>Nous contacter</span>
        			</div>
    				</a>
  					</div>
  				<div class="carte-couverture">
    				<a href='#'>
      				<div class="carte6 bg-06">
        			<span class='carte-contenu'>Ma banque et moi</span>
      				</div>
    				</a>
  				</div>
		</div>
			<div class="picture"><img src="images/city3.png"/></div>
		<!-- <div class="panel-contenu"> -->
				<div class="panel-contenu">
        			<h2>BIENVENUE 
	        			<%
	        				String prenom =(String)session.getAttribute("prenom");
							String nom =(String) session.getAttribute("nom");
							out.println(prenom);
							out.println(nom);
						%>
					</h2>
        			<p>Des solutions adaptées pour tous besoins : gestion et</p>
        			<p>ouverture de compte en ligne, simulation de crédit, assurance,</p>
        			<p>épargne… une banque présente à vos côtés au quotidien.</p>
        		</div>
  		<!--</div>  -->
			<div class="sous-panel1"><!-- à faire -->
				
				
			</div>
			
</div>
<div class="centre2" id="centre2">
		<div class="centre2-contenu">
        			<h2>MA BANQUE EN PRATIQUE</h2>
        			<p>Fonctionnalités et services pour améliorer votre utilisation de la banque au quotidien.</p>
        		</div>
		<div class="centre2-panel1">
			<!-- <div class="centre2-picture"><img src="images/city1.png"/></div>-->
			<li class="affichage"><div class="centre2-picture"><img src="images/city2.png" height="280" width="580px"/></div>	<span class="span1">Du 7 au 31 décembre, Paylib double votre don si vous l'effectuez sur le site de la Fondation de France.</span></li>
			<div class="centre2-text"><h2>Jusqu'au 2 Janvier 2019</h2></div>
			<div class ="centre2-panel1-roundRectangle"><a href="#">Voir conditions</a></div>
			 
		</div>
		<div class="centre2-panel2">
			<li class="affichage"><div class="centre2-picture"><img src="images/city1.png" height="280" width="580px"/></div>	<span class="span1">Prenez rendez-vous avec votre conseiller depuis votre espace personnel en choisissant l’horaire qui vous convient selon ses disponibilités !</span></li>
			<div class="centre2-text"><h2>Jusqu'au 2 Janvier 2019</h2></div>
			<div class ="centre2-panel2-roundRectangle"><a href="#">Voir conditions</a></div>
			
		</div>
		<div class="centre2-panel3">
			<iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d2611.229425197132!2d6.161110165683648!3d49.12027777931392!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1smetz+iut+info!5e0!3m2!1szh-CN!2sfr!4v1546042028252" width="1180px" height="400px" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
</div>
<div class="foot" id="foot">		
  			<div class="foot1">
  				<div class="foot-text"><h3>&nbsp&nbspCONTACT</h3></div>
  				<div class= "foot-site"><a href="#">Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</a></div>
  			</div>
   		 	<div class="foot2">
   		 		<div class="foot-text"><h3>&nbsp&nbspCONTACT</h3></div>
  				<div class= "foot-site"><a href="#"><p>Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</p></a></div>
  			</div>
  			<div class="foot3">
  				<div class="foot-text"><h3>&nbsp&nbspCONTACT</h3></div>
  				<div class= "foot-site"><a href="#"><p>Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</p></a></div>
  			</div>
</div>
</body>
</html>
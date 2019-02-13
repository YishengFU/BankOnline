<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="main.SQLconnexion" %>
<%@ page import="pojo.Personne" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
      
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<head>
		<meta charset = "UTF-8">
		<title>Employe</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" type="text/css" href="./css/accueil_employe.css">	
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
			<li style='float:right'><a href="cree_compte.jsp"><div class ="roundRectangle">Créer un compte</div></a></li>
		</ul>
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
    				<a href='virement_client.jsp'>
      				<div class="carte2 bg-02">
        			<span class='carte-contenu'>Virement</span>
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
					<div class="panel-contenu">
        			<center><h1>Bienvenue, 
        				<i><%
	        				String prenom =(String)session.getAttribute("prenom");
							String nom =(String) session.getAttribute("nom");
							ArrayList<Personne> personnes = (ArrayList<Personne>) session.getAttribute("personnes");
							out.println(prenom);
							out.println(nom);
						%>
						</i>
        			</h1>
      			</center>
        		</div>
			<div class="sous-panel1"><!-- à faire -->
			<div class = "tableaffichage">
				<table align = "center">
				<caption>
				<h2></h2>
				</caption>
				<thead>
					<tr>	
						<th width="200" >Id</th>
						<th width="200" >Nom</th>
						<th width="100" >Prénom</th>
						<th width="150" >Date_naissance</th>
						<th width="300" >Adresse</th>
						<th width="350" >Ville</th>
						<th width="350" >Sexe</th>
						<th width="350" >Statut</th>
						<th width="450" >Téléphne</th>
						<th width="450" >Email</th>
						<th width="350" >Pseudo</th>
						<th width="450" >Employe</th>
						<th width="" align="center" valign="middle">Modification</th>
						
					</tr>
				</thead>
				
				<c:forEach   items="${personnes}" var = "l" varStatus = "s">
				<tbody>
					<tr>
						<td width="200" align="center" valign="middle"><c:out value="${l.getId_pers()}"/></td>
						<td width="300" align="center" valign="middle"><c:out value="${l.getNom()}"/></td>
						<td width="300" align="center" valign="middle"><c:out value="${l.getPrenom()}"/></td>
						<td width="500" align="center" valign="middle"><c:out value="${l.getDate_naissance()}"/></td>
						<td width="500" align="center" valign="middle"><c:out value="${l.getAdresse()}"/></td>
						<td width="350" align="center" valign="middle"><c:out value="${l.getSa_ville().getLib_ville()}"/></td>
						<td width="350" align="center" valign="middle"><c:out value="${l.getSon_sexe().getLibelle()}"/></td>
						<td width="350" align="center" valign="middle"><c:out value="${l.getSon_statut().getLib_statut()}"/></td>
						<td width="450" align="center" valign="middle"><c:out value="${l.getTelephone()}"/></td>
						<td width="450" align="center" valign="middle"><c:out value="${l.getEmail()}"/></td>
						<td width="350" align="center" valign="middle"><c:out value="${l.getPseudo()}"/></td>
						<td width="450" align="center" valign="middle"><c:out value="${l.getSon_employe().getNom()}"/><c:out value="${l.getSon_employe().getPrenom()}"/></td>
						<td width="350" align="center" valign="middle"><a href = "Modification?id=${String.valueOf(l.getId_pers())}" class = "modifier">Modifier</a></td>
					</tr>
				</tbody>
				</c:forEach>
			
			</table>
			</div>
			</div>
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
  				<div class="foot-text"><h3>&nbsp&nbspkilian.kalypso@gmail.com</h3></div>
  				<div class= "foot-site"><a href="#">Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</a></div>
  			</div>
   		 	<div class="foot2">
   		 		<div class="foot-text"><h3>&nbsp&nbsp+33 6 35 51 22 44</h3></div>
  				<div class= "foot-site"><a href="#"><p>Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</p></a></div>
  			</div>
  			<div class="foot3">
  				<div class="foot-text"><h3>&nbsp&nbspCONTACT</h3></div>
  				<div class= "foot-site"><a href="#"><p>Nos conseillers vous répondent par téléphone, chat, mail ou bien encore grâce à nos SAV Facebook et Twitter</p></a></div>
  			</div>
</div>
</body>
</html>
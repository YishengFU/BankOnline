<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Virement</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="css/virement_client.css">
		<script type ="text/javascript">
	function entree(){
		var pseudo = document.getElementById("pseudo").value;
		var motdepasse = document.getElementById("mdp").value;
		if(pseudo.length==0||pseudo.trim()==""){
		alert("le champ de pseudo est vide");
		return false;
		}
		if(motdepasse.length==0||motdepasse.trim()=="")
		{
		alert("le champ de mot de passe est vide");
		return false;
		}
		return true;
		}
</script>		
	</head>
    <body>
<div class="head" id="head">
		<div class="navigateur">
		<ul>
  			<li><a href="#home" class="active">Particuliers</a></li>  
    		<li><a href="#">Banque privée</a></li>
  			<li ><a href="#">Professionnels</a></li>
  			<li ><a  href="#">Entreprises</a></li>
  	 		<li ><a  href="#">Associations</a></li>
		</ul>
		</div>
		<div class="navigateur1">
		<ul>
			<li style='float:left'><div class="icon"><img src="images/icon.png"/></div></li>
			<li style='float:left'><h2><a href="http://localhost:8090/Banque/accueil.jsp">AEDI Banque</a></h2></li>
    		
		</ul>
		</div>
 	 </div>
  
<div class="centre" id="centre">
	<section class="glisser" id = "glisser">
       <div class="panel-login1" id="panel-login1">
        <form action ="virement" method="post" onsubmit="return entree()">
		<div class="login1">
			<div class="log1 logtitre1">
				<h2 class="p1">Compte émetteur</h2>
			</div>
		
						<%
	        				String prenom =(String)session.getAttribute("prenom");
							String nom =(String) session.getAttribute("nom");
							double solde = (double) session.getAttribute("solde");
							int idcompte = (int) session.getAttribute("idcompte");
						%>
						
			<div class="log1-p1">
				
				 ID: <% out.println(idcompte);%>
				
			</div>
			<div class="log1-p1">
				<% out.println(nom);%>
				<%out.println(prenom);%>
				
			</div>
			<div class="log1-p1">
			
				Solde : <% out.println(solde);%> €
		
			</div>
			
			
			
		</div>	
	</form>
	</div>	
        <div class="panel-login" id="panel-login">
        <form action ="virement" method="post" onsubmit="return entree()">
		<div class="login">
			<div class="log logtitre">
				<h2 class="p1">Compte destinataire</h2>
			</div>
			<div class="log-p1">
				<i class="icon ion-ios-person-outline"></i>
				<input type="text"
					name= "nom" id="nom" class="textfield" placeholder="Nom prénom" >
			</div>
			<div class="log-p1">
				<i class="icon ion-ios-person-outline"></i>
				<input type="text"
					name="id_compte_but" id="id_compte_but" class="textfield" placeholder="Id compte " >
			</div>
			<div class="log-p1">
				<i class="icon ion-ios-locked-outline"></i>
				<input type="text"
					name="montant" id="montant" class="textfield" placeholder="Montant € " >
			</div>
			<div class="log-p2">
				<input type="submit" class="button" name ="valider" value="valider" onclick="return entree()">
			</div>
			<div class="log-p3"><a class="site" href="accueil_client.jsp">annuler</a></div> 
		</div>	
	</form>
	</div>	
		<div class="panel img">
        	<div class="Glisser"></div>
        <div class="panel-haut">
			<div class="panel-p" id="p-1"></div>
			<div class="panel-p" id="p-2"></div>
			<div class="panel-p" id="p-3"></div>
		</div>
    </div>
</section>	
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
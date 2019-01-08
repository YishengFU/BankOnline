<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title> Inscription</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="css/inscription.css">
	</head>
    <body>
<div class="head" id="head">
		<div class="navigateur">
		<ul>
  			<li><a href="#home" class="active">Particuliers</a></li>  
    		<li><a href="#">Banque privée</a></li>
  			<li ><a href="#gestion">Professionnels</a></li>
  			<li ><a  href='modifier.php'>Entreprises</a></li>
  	 		<li ><a  onclick='return confirmation()'>Associations</a></li>
		</ul>
		</div>
		<div class="navigateur1">
		<ul>
			<li style='float:left'><div class="icon"><img src="images/icon.png"/></div></li>
			<li style='float:left'><h2><a href="file:///Users/zhaopeng/Desktop/ProjetJSP/Test1.html">AEDI Banque</a></h2></li>
			<li style='float:right'><a href="#"><div class ="roundRectangle">Ouvrir un compte</div></a></li>
    		
		</ul>
		</div>
 	 </div>
  
<div class="centre" id="centre">

	<section class="glisser">
        <div class="panel-inscription" id="panel-inscription">
        <form action ="entree.php" method="post">
        
		<div class="inscription">
			<div class="ins institre">
				<h2 class="p1">Inscription</h2>
			</div>
		<div class="left">
			<div class="ins-p1">
				<i class="icon ion-ios-person-outline"></i>
				<input type="text"
					name= "nom" id="nom" class="textfield" placeholder="nom" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-person-outline"></i>
				<input type="text"
					name="prenom" id="prenom" class="textfield" placeholder="prénom" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-clock-outline"></i>
				<input type="date"
					name="datenais" id="datenais" class="textfield" placeholder="JJ/MM/AAAA" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-home-outline"></i>
				<input type="text"
					name="adresse" id="adresse" class="textfield" placeholder="adresse" >
			</div>
			<div class="ins-p1">
				
				<select name= "ville" id ="ville" onchange = "addVille()" style="width:335px; height: 30px; margin-bottom:20px;">
			</div>
			<div class="ins-radio">
				
				<input type = "radio"  name = "sexe"  value = "1"checked="checked"> Homme
				<input type = "radio" name = "sexe" value = "2"> Femme
			</div>
		</div>
			
		<div class="right">	
		
			<div class="ins-p1">
				<i class="icon ion-ios-telephone-outline"></i>
				<input type="text"
					name="tel" id="tel" class="textfield" placeholder="numéro de téléphone" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-email-outline"></i>
				<input type="text"
					name="mail" id="mail" class="textfield" placeholder="@gmail.com" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-locked-outline"></i>
				<input type="text"
					name="pseudo" id="pseudo" class="textfield" placeholder="pseudo" >
			</div>
			<div class="ins-p1">
				<i class="icon ion-ios-locked-outline"></i>
				<input type="text"
					name="mdp" id="mdp" class="textfield" placeholder="mot de passe" >
			</div>
			<div class="ins-p1">
				
				<select name= "charge-clientele" id ="charge-cleintele" onchange = "addEmploye()" style="width:335px; height: 30px; margin-bottom:20px;">
			</div>
			<div class="ins-radio">
				
				<input type = "radio"  name = "statut"  value = "1"checked="checked" > statut1
				<input type = "radio" name = "statut" value = "2" > statut2
			</div>
		</div>
		
			<div class="ins-p2">
				<input type="submit" class="button" name ="valider" value="valider">
			</div>
		
			<div class="ins-p3"><a class="site" href="inscriptionform.jsp">annuler</a></div> 
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
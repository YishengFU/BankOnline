<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title> Login</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="css/login.css">		
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
	<div class="animation" id="animation">  
	<div><span>Cher</span>Client</div>
	<div>Bienvenue<span>Ma Banque</span></div>
	<div>La banque <span> d'un monde</span></div>
	<div><span>Qui</span> change</div>
	</div>
	<section class="glisser" id = "glisser">
        <div class="panel-login" id="panel-login">
        <form action ="Login" method="post">
		<div class="login">
			<div class="log logtitre">
				<h2 class="p1">Connexion</h2>
			</div>
			<div class="log-p1">
				<i class="icon ion-ios-person-outline"></i>
				<input type="text"
					name= "pseudo" id="pseudo" class="textfield" placeholder="numéro client" >
			</div>
			<div class="log-p1">
				<i class="icon ion-ios-locked-outline"></i>
				<input type="password"
					name="mdp" id="mdp" class="textfield" placeholder="mot de passe" >
			</div>
			<div class="log-p2">
				<input type="submit" class="button" name ="valider" value="valider" onclick="return entree()">
			</div>
			<div class="log-p3"><a class="site" href="inscriptionform.jsp">inscription</a></div> 
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
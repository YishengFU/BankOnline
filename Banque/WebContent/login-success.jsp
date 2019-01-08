<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>login-success</title>
		<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="css/login-success.css">		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
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
			<li style='float:left'><h2><a href="file:///Users/zhaopeng/Desktop/ProjetJSP/Test1.html">Nom de Banque</a></h2></li>
			<li style='float:right'><a href="#"><div class ="roundRectangle">Ouvrir un compte</div></a></li>
    		
		</ul>
		</div>
 	 </div>
  
<div class="centre" id="centre">
	<div class="panel" role='alert'><center>login success</center></div>
	id: ${currantPersonne.pseudo} <br>
	mot de passe:${currantPersonne.mdp}
</div>
</body>
</html>
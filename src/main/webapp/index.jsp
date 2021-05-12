<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Práctica 2 - REST</title>

		<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
		<script src="js/crudVideogames.js" type="text/javascript"></script>
		<script src="js/crudCategories.js" type="text/javascript"></script>
		
	</head>

	<body>
	
		<h1>Servicio REST Videojuegos</h1>
	
		<form>
			Formulario para insertar un nuevo videojuego.<br>
			Id: <input type="text" id="videogameId"><br>
			Nombre: <input type="text" id="videogameName"><br>
			Descripci&oacute;n: <input type="text" id="videogameDescription"><br>
			<button id="sendVideogameButton">Crear</button>
		</form>
	
		<br>
		
		<form>
			Formulario para insertar una nueva categoría.<br>
			Id: <input type="text" id="categoryId"><br>
			Nombre: <input type="text" id="categoryName"><br>
			Descripci&oacute;n: <input type="text" id="categoryDescription"><br>
			<button id="sendCategoryButton">Crear</button>
		</form>
		
		<br>
	
		Listado de Videojuegos creados
		<br>
		
		<ul id="videogamesList"></ul>
		
		<br>
	
		Listado de Categorías creadas
		<br>
		
		<ul id="categoriesList"></ul>

	</body>
		
</html>
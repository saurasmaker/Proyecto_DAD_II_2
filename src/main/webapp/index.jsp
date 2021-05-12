<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "edu.ucam.pojos.*" %>    

<!DOCTYPE html>
<html lang = "es">

	<head>
		<link rel="shortcut icon" href="http://example.com/favicon.png">
		
		<meta charset="UTF-8">
		<meta name="description" content="Videogames shop.">
		<meta name="keywords" content="indodeo, infodeo2, dad2, dad, practica">
		<meta name="author" content="Iván Saura Cuadrado">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				
		<!-- BOOTSTRAP 5 -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
		<!-- Fontawesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
		
		<!-- My Styles -->
		<link rel = "stylesheet" href = "<%=request.getContextPath() %>/styles/mystyle.css"/>
		
		<!-- My Scripts -->
		<script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
		<script src="js/crudVideogames.js" type="text/javascript"></script>
		<script src="js/crudCategories.js" type="text/javascript"></script>
		<script src="js/adminCRUD.js" type="text/javascript"></script>
		
		<title>Práctica 2 - REST</title>
	</head>
	
	
	<body onload = "displayAdminPage()">
		
		<div class = "general container">
			<jsp:include page="mod/header.jsp" />

			<div class = "content row">
				<div class = "col-12">
					<h3 class = "display-2 text-center">Administrar</h3>
					<hr width = "50%"/>
					<br/>
				</div>
				
				<jsp:include page="mod/videogames_admin.jsp"/>
				<!--<jsp:include page="mod/categories_admin.jsp"/>-->
				
			</div>
			
			<jsp:include page="mod/footer.jsp" />
		</div>
		
	</body>
	
	
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<%@ page import = "edu.ucam.pojos.Videogame" %>
<%@ page import = "edu.ucam.pojos.Category" %>
<%@ page import = "edu.ucam.pojos.VideogameCategory" %>


	<div id = "videogames-title" class = "col-12">
        <h3 class = "display-3">Videojuegos</h3>
        <hr width = "25%" align = "left"/>
        <br/>
    </div>
	  
	<div class = "col-lg-4 col-md-6 col-sm-12">
      	<form id = "create-videogame-form" class = "form-group">

			<p><input id = "videogame-input-id" type = "hidden" value='-1' class="form-control" placeholder = "ID del Videojuego" name = "<%=Videogame.ATR_VIDEOGAME_ID %>"></p>
				
			<label for="videogame-input-name">Nombre: </label>
			<p><input id = "videogame-input-name" type = "text" class="form-control" placeholder = "Introduce el Nombre del Videojuego..." name = "<%=Videogame.ATR_VIDEOGAME_NAME %>" required></p>

		    <label for="videogame-input-description">Descripción: </label>
			<p><textarea id = "videogame-input-description" class="form-control" placeholder = "Introduce la Descripción del Videojuego..." name = "<%=Videogame.ATR_VIDEOGAME_DESCRIPTION %>" required></textarea></p>

			<label for="videogame-input-releasedate">Fecha de Lanzamiento: </label>
			<p><input id = "videogame-input-releasedate" type = "date" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_RELEASEDATE %>" required></p>
			
			<label for="videogame-input-stock">Stock: </label>
			<p><input id = "videogame-input-stock" type = "number" min = "0" step = "1" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_STOCK %>" required></p>
			
			<label for="videogame-input-purchaseprice">Precio de Compra: </label>
			<p><input id = "videogame-input-purchaseprice" type = "number" min = "0" step = "0.01" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_PURCHASEPRICE %>" required></p>
					
			<label for="videogame-input-rentalprice">Precio de Alquiler: </label>
			<p><input id = "videogame-input-rentalprice" type = "number" min = "0" step = "0.01" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_RENTALPRICE %>" required></p>												

            <p><input id = "input-send-videogame" type = "submit" class="btn btn-primary" value = "Crear"></p>
        </form>



        <form id = "update-videogame-form" class = "form-group">

			<label for="videogame-input-update-id">ID: </label>
			<p><input id = "videogame-input-update-id" type = "text" class="form-control" placeholder = "ID del Videojuego" name = "<%=Videogame.ATR_VIDEOGAME_ID %>" readonly></p>
				
			<label for="videogame-input-update-name">Nombre: </label>
			<p><input id = "videogame-input-update-name" type = "text" class="form-control" placeholder = "Introduce el Nombre del Videojuego..." name = "<%=Videogame.ATR_VIDEOGAME_NAME %>" required></p>

		    <label for="videogame-input-update-description">Descripción: </label>
			<p><textarea id = "videogame-input-update-description" class="form-control" placeholder = "Introduce la Descripción del Videojuego..." name = "<%=Videogame.ATR_VIDEOGAME_DESCRIPTION %>" required></textarea></p>

			<label for="videogame-input-update-releasedate">Fecha de Lanzamiento: </label>
			<p><input id = "videogame-input-update-releasedate" type = "date" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_RELEASEDATE %>" required></p>
			
			<label for="videogame-input-update-stock">Stock: </label>
			<p><input id = "videogame-input-update-stock" type = "number" min = "0" step = "1" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_STOCK %>" required></p>
			
			<label for="videogame-input-update-purchaseprice">Precio de Compra: </label>
			<p><input id = "videogame-input-update-purchaseprice" type = "number" min = "0" step = "0.01" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_PURCHASEPRICE %>" required></p>
					
			<label for="videogame-input-update-rentalprice">Precio de Alquiler: </label>
			<p><input id = "videogame-input-update-rentalprice" type = "number" min = "0" step = "0.01" class="form-control" name = "<%=Videogame.ATR_VIDEOGAME_RENTALPRICE %>" required></p>												

            <p>
                <input id = "input-edit-videogame" type = "submit" class="btn btn-primary" value = "Editar">
                <a id = "input-cancel-send" class="btn btn-secondary" type = "button" role="button" href="#" onclick="cancelUpdateVideogame(); return false;" style = "margin-left: 10px;">Cancelar</a>
            </p>
        </form>
          
    </div>

    
	
	<div class = "row col-lg-8 col-md-6 col-sm-12">
		<div class = "col-12">
	        <div class = "table-responsive" style = " max-height: 600px !important; overflow: auto;">
	            <table class="table table-striped">
	               	<thead class = "thead-dark">
	                  	<tr>
	                     	<th scope="col">ID</th>
	                     	<th scope="col">Nombre</th>
	                     	<th scope="col">Descripción</th>
							<th scope="col">Fecha de Lanzamiento</th>
							<th scope="col">Stock</th>
							<th scope="col">Precio de Compra</th>
	                        <th scope="col">Precio de Alquiler</th>
	                        <th scope="col">Editar</th>
	                        <th scope="col">Eliminar</th>
	                  	</tr>
	               	</thead>
				   	<tbody id = "tableBodyVideogames">
        
					</tbody>
	            </table>
	        </div>
	    </div>
	    
	    <br/>

	</div>
	
	
	
	
	<!-- AÑADIR CATEGORÍA AL VIDEOJUEGO SELECCIONADO -->
	<div id = "videogamecategory-title" class = "col-12">
        <h4 class = "" align = "right">Añadir categoría</h4>
        <hr/>
    </div>
    
	<div class = "col-6">
	
		<form id = "add-videogamecategory-form" class = "form-group" action = "<%= request.getContextPath() %>/Controller" method = "POST">		
        	<label for="videogame-input-category">Elige una categoría: </label>
			<p><select id = "videogame-input-category" class="form-control" name = "<%=VideogameCategory.ATR_VIDEOGAMESCATEGORIES_CATEGORYID %>">
			  	<option value="none" selected>Categoría...</option>
			</select></p>												
            <p><input id = "input-send-videogamecategory" type = "submit" class="btn btn-primary" value = "Añadir categoria a "></p>
        </form>
    </div>
    
    
    <div id = "table-videogamescategories" class = "col-6">
    	<label>Categorías </label>
    	<div class = "table-responsive"  style = " max-height: 600px !important; overflow: auto;">
		 	<table class="table table-striped">
		 		<tbody>
		 			<tr>
		 				<td>category name</td>	
		 			</tr>
		 			<tr>
	 					<td>
							<form action = "<%= request.getContextPath() %>/Controller" method = "POST">
                           		<input type="hidden" name = "<%=VideogameCategory.ATR_VIDEOGAMESCATEGORIES_ID %>" value = "">
                           		<button type="submit" class="btn btn-danger">Eliminar</button>
                        	</form>
                        </td>
		 			</tr>
		 		</tbody>
		 	</table>
	 	</div>
	</div>
	
	
	
	
	<br/>  
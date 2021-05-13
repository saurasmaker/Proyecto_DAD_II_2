<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<%@ page import = "edu.ucam.pojos.Category" %>

	<div id = "categories-title" class = "col-12">
        <h3 class = "display-3">Categorías</h3>
        <hr width = "25%" align = "left"/>
        <br/>
    </div>
	  
	<div class = "col-lg-4 col-md-6 col-sm-12">
	
      	<form id = "create-category-form" class = "form-group">
						
			<p><input id = "category-input-id" type = "hidden" value="-1" class="form-control" placeholder = "Identificador de la categoría" name = "<%=Category.ATR_CATEGORY_ID %>" required></p>

		    <label for="category-input-name">Nombre: </label>
			<p><input id = "category-input-name" type = "text" class="form-control" placeholder = "Introduce el nombre de la categoría..." name = "<%=Category.ATR_CATEGORY_NAME %>" required></p>
		
			<label for="category-input-description">Descripción: </label>
			<p><textarea id = "category-input-description" class="form-control" placeholder = "Introduce la descripción de la categoría..." name = "<%=Category.ATR_CATEGORY_DESCRIPTION %>" required></textarea></p>
						
            <p><input id = "input-send-category" type = "submit" class="btn btn-primary" value = "Crear"></p>
        </form>



        <form id = "update-category-form" class = "form-group" style = "display: 'none';">      
			
			<label for="category-input-update-id">ID: </label>
			<p><input id = "category-input-update-id" type = "text" class="form-control" placeholder = "Identificador de la categoría" name = "<%=Category.ATR_CATEGORY_ID %>" readonly></p>

		    <label for="category-input-update-name">Nombre: </label>
			<p><input id = "category-input-update-name" type = "text" class="form-control" placeholder = "Introduce el nombre de la categoría..." name = "<%=Category.ATR_CATEGORY_NAME %>" required></p>
		
			<label for="category-input-update-description">Descripción: </label>
			<p><textarea id = "category-input-update-description" class="form-control" placeholder = "Introduce la descripción de la categoría..." name = "<%=Category.ATR_CATEGORY_DESCRIPTION %>" required></textarea></p>
            
            <p>
                <input id = "input-edit-category" type = "submit" class="btn btn-primary" value = "Editar">
                <a id = "input-cancel-send" class="btn btn-secondary smooth-scroller" href="#" role="button" onclick = "cancelUpdateCategory(); return false; " style = "margin-left: 10px;">Cancelar</a>
            </p>
        </form>
    </div>

    
	  
	<div class = "col-lg-8 col-md-6 col-sm-12">
        <div class = "table-responsive" style = " max-height: 600px !important; overflow: auto;">
            <table class="table table-striped">
               	<thead class = "thead-dark">
                  	<tr>
                     	<th scope="col">ID</th>
                     	<th scope="col">Nombre</th>
                     	<th scope="col">Descripción</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                  	</tr>
               	</thead>
			   	<tbody id="tableBodyCategories">		  				   	
				   		
					
			   	
				</tbody>
            </table>
        </div>
    </div>
	
	<br/>  


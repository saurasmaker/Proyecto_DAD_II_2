<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import = "java.util.ArrayList" %>
 
<%@ page import = "edu.ucam.pojos.*" %>
	
	<header>
		<nav class="container navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		    <a href = "index.jsp"> <img src = "img\INFO(2).png" height = "45px" style = "margin-right: 10px;" /></a>
		    <a class="navbar-brand" href="index.jsp">INFODEO</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		    </button>
		
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		        <ul class="navbar-nav mr-auto">
		            <li class="nav-item">
		                <a class="nav-link" href = "<%= request.getContextPath()%>/index.jsp">Cat�logo <span class="sr-only">()</span></a>
		            </li>		        
		        </ul>   
		    </div>
		</nav>
	</header>
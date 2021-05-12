package edu.ucam.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import edu.ucam.pojos.*;

@Path("/categories")
public class CategoriesService {
	
	@DefaultValue("") @QueryParam("token") String token;
	
	
	private static Hashtable <String, Category> categories = new Hashtable<String, Category>();	
	
	
	/*
	 * Service Methods
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoriesList() {
				
		JSONObject jsonRespuesta = new JSONObject();
		
		System.out.println("Running 'getCategoriesList' command...");
		for(Category category: categories.values()){
			jsonRespuesta.append("categories", category.toJSONObject());	
			System.out.println(category.toJavaScriptFunction());
		}
		
		return Response.status(201).entity(jsonRespuesta.toString()).build();
	}
	
	
	
	@POST	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFinca(InputStream incomingData) {
		
		Category category;
		JSONObject jsonReceived;
		JSONObject jsonResponse = new JSONObject();
		StringBuilder sb = new StringBuilder();
		
		
		System.out.println("Running 'createCategory' command...");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
			Response.status(422).entity(jsonResponse.toString()).build();
		}			
		jsonReceived = new JSONObject(sb.toString());
		category = new Category(jsonReceived);
		
		/*
		 * Check if already exists, adding video game in the table if not. 
		 */
		if(categories.get(category.getId())==null){
			
			categories.put(category.getId(), category);
			jsonResponse.put("category", category.toJSONObject());
			
			System.out.println("Category added succesfully.");
			
			return Response.status(201).entity(jsonResponse.toString()).build();
		}else{
			System.out.println("The category already exists");
			jsonResponse.put("result", "Te category already exists");
			return Response.status(422).entity(jsonResponse.toString()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategory(@PathParam("id") String categoryId) {
		
		JSONObject jsonRespuesta = new JSONObject();
		
		System.out.println("Runnning 'deleteCategory' command...");
		categories.remove(categoryId);
		jsonRespuesta.append("result", "Deleted");	

		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.entity(jsonRespuesta.toString())
				.build();
	}

}


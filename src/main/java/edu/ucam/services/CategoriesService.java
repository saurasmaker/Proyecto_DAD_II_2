package edu.ucam.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	
	private static ArrayList <Category> categories = new ArrayList<Category>();	
	
	
	/*
	 * Service Methods
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoriesList() {
				
		JSONObject jsonRespuesta = new JSONObject();
		
		for(Category category: categories){
			jsonRespuesta.append("categories", category.toJSONObject());	
		}
		
		return Response.status(201).entity(jsonRespuesta.toString()).build();
	}
	
	
	
	@POST	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCategory(InputStream incomingData) {
		
		/*
		 * Prepare variables
		 */
		Category category;
		JSONObject jsonReceived;
		JSONObject jsonResponse = new JSONObject();
		StringBuilder sb = new StringBuilder();
			
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
		 * Add
		 */
		if(categories.size() == 0) {
			category.setId("1");
			categories.add(category);
		}
		else if(category.getId().equals("-1")) {
			category.setId(((Integer) (Integer.parseInt(categories.get(categories.size()-1).getId()) + 1)).toString());
			categories.add(category);
		}
		
		
		/*
		 * Update
		 */
		else {
			try {
				categories.set(getCategoryPosition(category.getId()), category);
			} catch(Exception t) {
				jsonResponse.append("result", "Error Updating");
			}
		}
		
		jsonResponse.put("category", category.toJSONObject());
				
		return Response.status(201).entity(jsonResponse.toString()).build();
	}
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategory(@PathParam("id") String categoryId) {
		
		JSONObject jsonRespuesta = new JSONObject();
		
		try { categories.remove(getCategoryPosition(categoryId)); } catch(Exception t) { jsonRespuesta.append("result", "Error Removing"); }
		jsonRespuesta.append("result", "Deleted");	

		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.entity(jsonRespuesta.toString())
				.build();
	}
	
	
	
	/*
	 * Tool methods
	 */
	private int getCategoryPosition(String id) {
		
		for(int i = 0; i < categories.size(); ++i)
			if(categories.get(i).getId().equals(id)) {
				return i;
			}	
		
		return -1;
	}


}


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

@Path("/videogamescategories")
public class VideogamesCategoriesService {
	
	@DefaultValue("") @QueryParam("token") String token;
	
	
	private static ArrayList <VideogameCategory> videogamesCategories = new ArrayList<VideogameCategory>();	
	
	
	/*
	 * Service Methods
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVideogamesCategoriesList() {
				
		JSONObject jsonRespuesta = new JSONObject();
		
		for(VideogameCategory videogameCategory: videogamesCategories){
			jsonRespuesta.append("videogamesCategories", videogameCategory.toJSONObject());	
		}
		
		return Response.status(201).entity(jsonRespuesta.toString()).build();
	}
	
	
	
	@POST	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVideogameCategory(InputStream incomingData) {
		
		/*
		 * Prepare variables
		 */
		VideogameCategory videogameCategory;
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
		videogameCategory = new VideogameCategory(jsonReceived);
		

		/*
		 * Add
		 */
		if(videogamesCategories.size() == 0) {
			videogameCategory.setId("1");
			videogamesCategories.add(videogameCategory);
		}
		else if(videogameCategory.getId().equals("-1")) {
			videogameCategory.setId(((Integer) (Integer.parseInt(videogamesCategories.get(videogamesCategories.size()-1).getId()) + 1)).toString());
			videogamesCategories.add(videogameCategory);
		}
		
		
		/*
		 * Update
		 */
		else {
			try {
				videogamesCategories.set(getCategoryPosition(videogameCategory.getId()), videogameCategory);
			} catch(Exception t) {
				jsonResponse.append("result", "Error Updating");
			}
		}

		jsonResponse.put("videogameCategory", videogameCategory.toJSONObject());
						
		return Response.status(201).entity(jsonResponse.toString()).build();
	}
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVideogameCategory(@PathParam("id") String categoryId) {
		
		JSONObject jsonRespuesta = new JSONObject();
		
		try { videogamesCategories.remove(getCategoryPosition(categoryId)); } catch(Exception t) { jsonRespuesta.append("result", "Error Removing"); }
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
		
		for(int i = 0; i < videogamesCategories.size(); ++i)
			if(videogamesCategories.get(i).getId().equals(id)) {
				return i;
			}	
		
		return -1;
	}


}


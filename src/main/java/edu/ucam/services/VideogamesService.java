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

@Path("/videogames")
public class VideogamesService {
	
	@DefaultValue("") @QueryParam("token") String token;
	
	
	private static Hashtable <String, Videogame> videogames = new Hashtable<String, Videogame>();	
	
	
	/*
	 * Service Methods
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVideogamesList() {
				
		JSONObject jsonRespuesta = new JSONObject();
		
		System.out.println("Running 'getVideogamesList' command...");
		for(Videogame videogame: videogames.values()){
			jsonRespuesta.append("videogames", videogame.toJSONObject());	
			System.out.println(videogame.toJavaScriptFunction());
		}
		
		return Response.status(201).entity(jsonRespuesta.toString()).build();
	}
	
	
	
	@POST	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVideogame(InputStream incomingData) {
		
		Videogame videogame;
		JSONObject jsonReceived;
		JSONObject jsonResponse = new JSONObject();
		StringBuilder sb = new StringBuilder();
		
		
		System.out.println("Running 'createVideogame' command...");
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
		videogame = new Videogame(jsonReceived);
		
		/*
		 * Check if already exists, adding video game in the table if not. 
		 */
		if(videogames.get(videogame.getId())==null){
			
			videogames.put(videogame.getId(), videogame);
			jsonResponse.put("videogame", videogame.toJSONObject());
			
			System.out.println("Videogame added succesfully.");
			
			return Response.status(201).entity(jsonResponse.toString()).build();
		}else{
			System.out.println("The videogame already exists");
			jsonResponse.put("result", "Te videogame already exists");
			return Response.status(422).entity(jsonResponse.toString()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVideogames(@PathParam("id") String videogameId) {
		
		JSONObject jsonRespuesta = new JSONObject();
		
		System.out.println("Runnning 'deleteVideogame' command...");
		videogames.remove(videogameId);
		jsonRespuesta.append("result", "Deleted");	

		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.entity(jsonRespuesta.toString())
				.build();
	}

}

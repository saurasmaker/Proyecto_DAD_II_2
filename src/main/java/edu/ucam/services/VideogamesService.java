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

@Path("/videogames")
public class VideogamesService {
	
	@DefaultValue("") @QueryParam("token") String token;
	
	
	public static ArrayList <Videogame> videogames = new ArrayList<Videogame>();	
	
	
	/*
	 * Service Methods
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVideogamesList() {
				
		JSONObject jsonRespuesta = new JSONObject();
		
		for(Videogame videogame: videogames){
			jsonRespuesta.append("videogames", videogame.toJSONObject());	
		}
		
		return Response.status(201).entity(jsonRespuesta.toString()).build();
	}
	
	
	
	@POST	
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVideogame(InputStream incomingData) {
		
		/*
		 * Prepare variables
		 */
		Videogame videogame;
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
		videogame = new Videogame(jsonReceived);
		
		/*
		 * Add
		 */
		if(videogames.size() == 0) {
			videogame.setId("1");
			videogames.add(videogame);
		}
		else if(videogame.getId().equals("-1")) {
			videogame.setId(((Integer) (Integer.parseInt(videogames.get(videogames.size()-1).getId()) + 1)).toString());
			videogames.add(videogame);
		}
		
		
		/*
		 * Update
		 */
		else {
			try {
				videogames.set(getVideogamePosition(videogame.getId()), videogame);
			} catch(Exception t) {
				jsonResponse.append("result", "Error Updating");
			}
		}
		
		
		jsonResponse.put("videogame", videogame.toJSONObject());
				
		return Response.status(201).entity(jsonResponse.toString()).build();
	}
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVideogames(@PathParam("id") String videogameId) {
		
		JSONObject jsonRespuesta = new JSONObject();
		
		try { videogames.remove(getVideogamePosition(videogameId)); } catch(Exception t) { jsonRespuesta.append("result", "Error Removing"); }
		jsonRespuesta.append("result", "Deleted");	

		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.entity(jsonRespuesta.toString())
				.build();
	}
	
	
	
	/*
	 * Tool methods
	 */
	private int getVideogamePosition(String id) {
		
		for(int i = 0; i < videogames.size(); ++i)
			if(videogames.get(i).getId().equals(id)) {
				return i;
			}	
		
		return -1;
	}

}

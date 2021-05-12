package edu.ucam.pojos;

import org.json.JSONObject;

public class VideogameCategory implements IMyPojo{
	
	/*
	 * Static Attributes
	 */
	public static String ATR_VIDEOGAMESCATEGORIES = "ATR_VIDEOGAMES_CATEGORIES", ATR_VIDEOGAMESCATEGORIES_ID = "ATR_VIDEOGAMESCATEGORIES_ID",
			ATR_VIDEOGAMESCATEGORIES_VIDEOGAMEID = "ATR_VIDEOGAMESCATEGORIES_VIDEOGAMEID", ATR_VIDEOGAMESCATEGORIES_CATEGORYID = "ATR_VIDEOGAMESCATEGORIES_CATEGORYID";
	
	
	
	/*
	 * Attributes
	 */
	private String id, videogameId, categoryId;
	
	
	
	
	/*
	 * Constructors
	 */
	public VideogameCategory() {
		
	}
	
	public VideogameCategory(String videogameId, String categoryId) {
		this.videogameId = videogameId;
		this.categoryId = categoryId;
	}
	
	
	


	/*
	 * Methods
	 */
	@Override
	public String toJavaScriptFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public JSONObject toJSONObject() {
		
		JSONObject jObject = new JSONObject();
		
		jObject.put("id", id);
		jObject.put("videogameId", videogameId);
		jObject.put("categoryId", categoryId);
		
		return jObject;
	}
	
	/*
	 * Getters & Setters
	 */
	public String getVideogameId() {
		return videogameId;
	}


	public void setVideogameId(String videogameId) {
		this.videogameId = videogameId;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	

}
	
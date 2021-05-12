package edu.ucam.pojos;

import org.json.JSONObject;

public class Category implements IMyPojo{
	
	
	/*
	 * Static Attributes
	 */
	public static final String ATR_CATEGORY = "ATR_CATEGORY", ATR_CATEGORY_ID = "ATR_CATEGORY_ID", ATR_CATEGORY_NAME = "ATR_CATEGORY_NAME",
			ATR_CATEGORY_DESCRIPTION = "ATR_CATEGORY_DESCRIPTION", ATR_CATEGORIES_LIST = "ATR_CATEGORIES_LIST";
	
	
	
	/*
	 * Attributes
	 */
	private  String id, name, description;

	/*
	 * Constructors
	 */
	public Category() {
		
	}
	
	public Category(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public Category(JSONObject jObject) {
		this.id = jObject.getString("id");
		this.name = jObject.getString("name");
		this.description = jObject.getString("description");
	}
	
	
	/*
	 * Methods
	 */
	@Override
	public String toJavaScriptFunction() {
		return "'" + this.id + "', '" + this.name + "', '" + this.description + "'";
	}
	
	@Override
	public JSONObject toJSONObject() {
		
		JSONObject jObject = new JSONObject();
		
		jObject.put("id", id);
		jObject.put("name", name);
		jObject.put("description", description);
		
		return jObject;
	}
	
	/*
	 * Getters & Setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}

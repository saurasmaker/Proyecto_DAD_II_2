package edu.ucam.pojos;

import java.sql.Date;

import org.json.JSONObject;

public class Videogame implements IMyPojo{
	
	/*
	 * Static Attributes
	 */
	public static final String ATR_VIDEOGAME = "ATR_VIDEOGAME", ATR_VIDEOGAME_ID = "ATR_VIDEOGAME_ID", ATR_VIDEOGAME_NAME = "ATR_VIDEOGAME_NAME",
			ATR_VIDEOGAME_DESCRIPTION = "ATR_VIDEOGAME_DESCRIPTION", ATR_VIDEOGAME_RELEASEDATE = "ATR_VIDEOGAME_RELEASEDATE",
			ATR_VIDEOGAME_PURCHASEPRICE = "ATR_VIDEOGAME_PURCHASEPRICE", ATR_VIDEOGAME_RENTALPRICE = "ATR_VIDEOGAME_RENTALPRICE",
			ATR_VIDEOGAME_STOCK = "ATR_VIDEOGAME_STOCK", ATR_VIDEOGAME_IMAGE = "ATR_VIDEOGAME_IMAGE", ATR_VIDEOGAME_CATEGORY = "ATR_VIDEOGAME_CATEGORY",
			ATR_VIDEOGAMES_LIST = "ATR_VIDEOGAMES_LIST";
		
	
	
	/*
	 * Attributes
	 */
	private String id, name, description;
	private int stock;
	private Date releaseDate;
	private float purchasePrice, rentalPrice;
	
	
	
	/*
	 * Constructors
	 */
	public Videogame() {
		
	}
	
	public Videogame(String id, String name, String description, Date releaseDate, int stock, float purchasePrice, float rentalPrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.releaseDate = releaseDate;
		this.stock = stock;
		this.purchasePrice = purchasePrice;
		this.rentalPrice = rentalPrice;
	}
	
	public Videogame(JSONObject videogameJSONObject) {
		try { this.id = videogameJSONObject.getString("id"); } catch(Exception t) { this.id = null; }
		try { this.name = videogameJSONObject.getString("name"); } catch(Exception t) { this.name = null; }
		try { this.description = videogameJSONObject.getString("description"); } catch(Exception t) { this.description = null; }
		try { this.releaseDate = Date.valueOf(videogameJSONObject.getString("releaseDate")); } catch(Exception t) { this.releaseDate = null; }
		try { this.stock = videogameJSONObject.getInt("stock"); } catch(Exception t) { this.stock = -1; }
		try { this.purchasePrice = (float) videogameJSONObject.getDouble("purchasePrice"); } catch(Exception t) { this.purchasePrice = -1; }
		try { this.rentalPrice = (float) videogameJSONObject.getDouble("rentalPrice"); } catch(Exception t) { this.rentalPrice = -1; }
	}

	
	
	/*
	 * Methods
	 */
	@Override
	public String toJavaScriptFunction() {
		return "'" + this.id + "', '" + this.name + "', '" + this.description + "', '" + this.releaseDate + "', '"  + 
				this.stock + "', '" + this.purchasePrice + "', '"  + this.rentalPrice + "'";
	}
	
	@Override
	public JSONObject toJSONObject() {
		
		JSONObject jObject = new JSONObject();
		
		jObject.put("id", id);
		jObject.put("name", name);
		jObject.put("description", description);
		jObject.put("releaseDate", releaseDate);
		jObject.put("stock", stock);
		jObject.put("purchasePrice", purchasePrice);
		jObject.put("rentalPrice", rentalPrice);
		
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public float getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

}

package com.ClickBites.Model;

public class Menu {
	private int menuId;
	private String name;
	private int price;
	private String description;
	private String imagePath;
	private boolean isAvailable;
	private float rating;
	private int restaurantId;
	
//	Zero param constructor
	public Menu() {
		
	}
	
//	Param constructor
	public Menu(int menuId, String name, int price, String description, String imagePath, boolean isAvailable,
			float rating, int restaurantId) {

		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.restaurantId = restaurantId;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
}

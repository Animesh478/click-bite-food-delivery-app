package com.ClickBites.DaoImpl;

import com.ClickBites.Model.Menu;
import com.ClickBites.Model.Restaurant;

public class Demo {
	public static void main(String[] args) {
//		UserDaoImpl udi = new UserDaoImpl();
		
//		User user = new User();
//		user.setName("ananya");
//		user.setAddress("BBSR");
//		user.setEmail("anu@gmail.com");
//		user.setPassword("lagna");
//		user.setUserName("ani98");
//		user.setPhoneNumber("9040164536");
//		user.setRole("customer");
		
//		User u = udi.getUser(2);
//		System.out.println(u.getCreatedDate());
		
//		RestaurantDaoImpl rdi = new RestaurantDaoImpl();

		
//		Restaurant restaurant = new Restaurant();
//		
//		restaurant.setRestaurantName("Wow Momo");
//		restaurant.setImagePath("not available");
//		restaurant.setRating(4.0f);
//		restaurant.setDeliveryTime(25);
//		restaurant.setCuisineType("Momos, Chinese");
//		restaurant.setAddress("Btm 2nd Stage");
//		restaurant.setActive(true);
//		restaurant.setRestaurantOwnerId(2);
//		
//		rdi.addRestaurant(restaurant);
		
		
		MenuDaoImpl mdi = new MenuDaoImpl();
		
		Menu menu = new Menu();
	
		menu.setName("Veg Momo");
		menu.setPrice(120);
		menu.setDescription("Super soft, yummy, and scrumptious momos packed with a medley of fresh veggies. ");
		menu.setImagePath("path not available");
		menu.setAvailable(true);
		menu.setRating(4.2f);
		menu.setRestaurantId(1);
		
		mdi.addMenu(menu);
		
		
	
		
	}
}

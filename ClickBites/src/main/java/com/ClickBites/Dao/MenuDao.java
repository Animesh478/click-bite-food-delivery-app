package com.ClickBites.Dao;

import java.util.List;

import com.ClickBites.Model.Menu;

public interface MenuDao {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	List<Menu> getAllMenu();
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
}

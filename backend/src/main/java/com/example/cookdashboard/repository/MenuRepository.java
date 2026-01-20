package com.example.cookdashboard.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cookdashboard.model.MenuItem;

@Component
public class MenuRepository {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public MenuRepository() {
        // Initialize default menu items
        menuItems.add(new MenuItem("Grilled Chicken", "Mains",
                List.of("Chicken","Salt","Pepper"), 
                "https://i0.wp.com/kristineskitchenblog.com/wp-content/uploads/2024/06/grilled-chicken-recipes-29.jpg?resize=1365%2C2048&ssl=1"));

        menuItems.add(new MenuItem("Veggie Pasta", "Second Option",
                List.of("Pasta","Broccoli","Tomato Sauce"), 
                "https://www.cookingclassy.com/wp-content/uploads/2018/09/pasta-primavera-1-768x1152.jpg"));

        menuItems.add(new MenuItem("Fruit Salad", "Dessert",
                List.of("Apple","Banana","Grapes"), 
                "https://cdn.loveandlemons.com/wp-content/uploads/2025/06/fruit-salad-recipe-842x1024.jpg"));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public List<MenuItem> getMenuByType(String type) {
        List<MenuItem> result = new ArrayList<>();
        for(MenuItem item: menuItems){
            if(item.getType().equalsIgnoreCase(type)) result.add(item);
        }
        return result;
    }
}

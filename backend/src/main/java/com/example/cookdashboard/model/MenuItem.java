package com.example.cookdashboard.model;
import java.util.List;

public class MenuItem {
    private String name;
    private String type;
    private List<String> ingredients;
    private String imageLink;

    public MenuItem(String name, String type, List<String> ingredients, String imageLink){
        this.name=name;
        this.type=type;
        this.ingredients=ingredients;
        this.imageLink = imageLink;

    }

    public String getName(){return name;}
    public String getType(){return type;}
    public List<String> getIngredients(){return ingredients;}
    public String getImage() { return imageLink; }
}


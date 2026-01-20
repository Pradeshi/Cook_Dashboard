package com.example.cookdashboard.model;
import java.util.ArrayList;
import java.util.List;

public class DailyMenu {
    private MenuItem main;
    private MenuItem secondOption;
    private MenuItem dessert;

    public DailyMenu(MenuItem main, MenuItem secondOption, MenuItem dessert){
        this.main=main;
        this.secondOption=secondOption;
        this.dessert=dessert;
    }

    public MenuItem getMain(){return main;}
    public MenuItem getSecondOption(){return secondOption;}
    public MenuItem getDessert(){return dessert;}

    public List<String> getAllIngredients(){
        List<String> all=new ArrayList<>();
        all.addAll(main.getIngredients());
        all.addAll(secondOption.getIngredients());
        all.addAll(dessert.getIngredients());
        return all;
    }
}

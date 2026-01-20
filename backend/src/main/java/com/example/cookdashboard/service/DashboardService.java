package com.example.cookdashboard.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cookdashboard.model.MenuItem;
import com.example.cookdashboard.model.Resident;
import com.example.cookdashboard.model.SpecialRequest;
import com.example.cookdashboard.repository.MenuRepository;

@Service
public class DashboardService {

    private final List<Resident> residents = new ArrayList<>();
    private final List<SpecialRequest> specialRequests = new ArrayList<>();

    @Autowired
    private MenuRepository menuRepository;

    public DashboardService() {
        // Example residents
        residents.add(new Resident("John Doe", List.of("nuts"), List.of("broccoli"), "diabetic", LocalDate.of(1940,5,20)));
        residents.add(new Resident("Mary Smith", List.of(), List.of("spinach"), "low-salt", LocalDate.of(1935,8,10)));

        // Example specials
        specialRequests.add(new SpecialRequest("Jane Doe","Vegan Lasagna", LocalDate.now()));
        specialRequests.add(new SpecialRequest("Bob Smith","Birthday Cake", LocalDate.now()));
    }

    public Map<String,Object> getDashboard() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        String mealTime = now.isBefore(LocalTime.NOON) ? "Lunch" : "Dinner";

        // --- Select menu dynamically ---
        List<MenuItem> mainMenu = menuRepository.getMenuByType("Mains");
        List<MenuItem> secondMenu = menuRepository.getMenuByType("Second Option");
        List<MenuItem> dessertMenu = menuRepository.getMenuByType("Dessert");

        // For demo, just pick first item from each type
        MenuItem main = mainMenu.get(0);
        MenuItem second = secondMenu.get(0);
        MenuItem dessert = dessertMenu.get(0);

        List<String> allIngredients = new ArrayList<>();
        allIngredients.addAll(main.getIngredients());
        allIngredients.addAll(second.getIngredients());
        allIngredients.addAll(dessert.getIngredients());

        // ---- Conflicts ----
        List<String> conflicts = new ArrayList<>();
        for(Resident r: residents){
            for(String ingredient: allIngredients){
                if(r.getAllergies().contains(ingredient) || r.getDislikes().contains(ingredient)){
                    conflicts.add(r.getName());
                    break;
                }
            }
        }

        // ---- Today's specials ----
        List<SpecialRequest> todaySpecials = new ArrayList<>();
        for(SpecialRequest sr: specialRequests){
            if(sr.getDate().equals(today)) todaySpecials.add(sr);
        }

        Map<String,Object> result = new HashMap<>();
        result.put("mealTime", mealTime);
        result.put("menu", Map.of(
            "main", main,
            "secondOption", second,
            "dessert", dessert
        ));
        result.put("conflicts", conflicts);
        result.put("specialRequests", todaySpecials);

        return result;
    }
}

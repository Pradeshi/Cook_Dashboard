package com.example.cookdashboard.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cookdashboard.model.MenuItem;
import com.example.cookdashboard.model.Resident;
import com.example.cookdashboard.model.SpecialRequest;
import com.example.cookdashboard.repository.MenuRepository;
import com.example.cookdashboard.service.ResidentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/dashboard")
    public Map<String,Object> getDashboard() {

        List<MenuItem> mainMenu = menuRepository.getMenuByType("Mains");
        List<MenuItem> secondMenu = menuRepository.getMenuByType("Second Option");
        List<MenuItem> dessertMenu = menuRepository.getMenuByType("Dessert");
        MenuItem main = mainMenu.get(0);
        MenuItem second = secondMenu.get(0);
        MenuItem dessert = dessertMenu.get(0);

        String mealTime = LocalTime.now().getHour() < 12 ? "Lunch" : "Dinner";

        List<Resident> residents = residentService.getAllResidents();
        List<String> conflicts = new ArrayList<>();
        List<String> allIngredients = new ArrayList<>();
        allIngredients.addAll(main.getIngredients());
        allIngredients.addAll(second.getIngredients());
        allIngredients.addAll(dessert.getIngredients());

        for(Resident r : residents) {
            boolean conflict = false;
            if(r.getAllergies() != null) {
                for(String ingredient : allIngredients) {
                    if(r.getAllergies().contains(ingredient)) {
                        conflict = true;
                        break;
                    }
                }
            }
            if(!conflict && r.getDislikes() != null) {
                for(String ingredient : allIngredients) {
                    if(r.getDislikes().contains(ingredient)) {
                        conflict = true;
                        break;
                    }
                }
            }
            if(conflict) conflicts.add(r.getName());
        }

        List<SpecialRequest> specials = residentService.getAllSpecials();
        List<Map<String,String>> todaySpecials = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(SpecialRequest s : specials) {
            if(s.getDate().equals(today)) {
                Map<String,String> map = new HashMap<>();
                map.put("residentName", s.getResidentName());
                map.put("mealRequested", s.getMealRequested());
                todaySpecials.add(map);
            }
        }

        Map<String,Object> menu = new HashMap<>();
        menu.put("main", main);
        menu.put("secondOption", second);
        menu.put("dessert", dessert);

        Map<String,Object> result = new HashMap<>();
        result.put("mealTime", mealTime);
        result.put("menu", menu);
        result.put("conflicts", conflicts);
        result.put("specialRequests", todaySpecials);

        return result;
    }

    @PostMapping("/residents")
    public Map<String,String> addResident(@RequestBody Resident resident) {
        residentService.addResident(resident);
        return Map.of("status","success","message","Resident added successfully");
    }

    @GetMapping("/residents")
    public List<Resident> getResidents() {
        return residentService.getAllResidents();
    }

    @PostMapping("/specials")
    public Map<String,String> addSpecial(@RequestBody SpecialRequest special) {
        residentService.addSpecial(special);
        return Map.of("status","success","message","Special request added successfully");
    }

    @GetMapping("/specials")
    public List<SpecialRequest> getSpecials() {
        return residentService.getAllSpecials();
    }
}

package com.example.cookdashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cookdashboard.model.Resident;
import com.example.cookdashboard.model.SpecialRequest;

@Service
public class ResidentService {

    private final List<Resident> residents = new ArrayList<>();
    private final List<SpecialRequest> specials = new ArrayList<>();

    // --- Residents ---
    public void addResident(Resident resident) {
        residents.add(resident);
    }

    public List<Resident> getAllResidents() {
        return residents;
    }

    // --- Special Requests ---
    public void addSpecial(SpecialRequest special) {
        specials.add(special);
    }

    public List<SpecialRequest> getAllSpecials() {
        return specials;
    }
}

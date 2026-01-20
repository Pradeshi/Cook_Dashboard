package com.example.cookdashboard.model;

import java.time.LocalDate;

public class SpecialRequest {
    private String residentName;
    private String mealRequested;
    private LocalDate date;

    public SpecialRequest() {}

    public SpecialRequest(String residentName, String mealRequested, LocalDate date) {
        this.residentName = residentName;
        this.mealRequested = mealRequested;
        this.date = date;
    }

    public String getResidentName() { return residentName; }
    public void setResidentName(String residentName) { this.residentName = residentName; }
    public String getMealRequested() { return mealRequested; }
    public void setMealRequested(String mealRequested) { this.mealRequested = mealRequested; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}

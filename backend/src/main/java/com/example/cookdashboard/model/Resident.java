package com.example.cookdashboard.model;
import java.time.LocalDate;
import java.util.List;

public class Resident {
    private String name;
    private List<String> allergies;
    private List<String> dislikes;
    private String diet;
    private LocalDate birthday;

    public Resident(String name, List<String> allergies, List<String> dislikes, String diet, LocalDate birthday){
        this.name=name;
        this.allergies=allergies;
        this.dislikes=dislikes;
        this.diet=diet;
        this.birthday=birthday;
    }

    public String getName(){return name;}
    public List<String> getAllergies(){return allergies;}
    public List<String> getDislikes(){return dislikes;}
    public String getDiet(){return diet;}
    public LocalDate getBirthday(){return birthday;}
}

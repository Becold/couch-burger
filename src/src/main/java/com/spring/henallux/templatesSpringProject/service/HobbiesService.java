package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HobbiesService {
    private ArrayList<Hobby> hobbies;

    public HobbiesService() {
        Hobby football = new Hobby();
        football.setId("1");
        football.setName("Football");
        Hobby rugby = new Hobby();
        rugby.setId("2");
        rugby.setName("Rugby");
        Hobby enigme = new Hobby();
        enigme.setId("2");
        enigme.setName("Enigme");
        Hobby piscine = new Hobby();
        piscine.setId("2");
        piscine.setName("Piscine");

        this.hobbies = new ArrayList<Hobby>();

        this.hobbies.add(football);
        this.hobbies.add(rugby);
        this.hobbies.add(enigme);
        this.hobbies.add(piscine);
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}

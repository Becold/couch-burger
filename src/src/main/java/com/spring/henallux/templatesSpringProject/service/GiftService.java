package com.spring.henallux.templatesSpringProject.service;

import org.springframework.stereotype.Service;

@Service
public class GiftService {
    public GiftService() { }

    public String chooseGift(String hobby, int age) {
        StringBuilder chaine = new StringBuilder();
        if (age < 5)
            chaine.append("un puzzle concernant le ");
        else if (age < 10)
            chaine.append("un DVD concernant le ");
        else
            chaine.append("un livre concernant le ");
        chaine.append(hobby);
        return chaine.toString();
    }
}

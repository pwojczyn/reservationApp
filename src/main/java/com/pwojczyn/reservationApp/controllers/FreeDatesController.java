package com.pwojczyn.reservationApp.controllers;

import com.pwojczyn.reservationApp.models.forms.ReservationForm;
import com.pwojczyn.reservationApp.models.repositories.ReservationRepository;
import com.pwojczyn.reservationApp.models.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class FreeDatesController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/free-dates")
    public String freeDatesGet(Model model){
        model.addAttribute("reservations",reservationRepository.findByDateBetween(LocalDate.now(),LocalDate.now().plusWeeks(4)));

        return "freeDates";
    }
}

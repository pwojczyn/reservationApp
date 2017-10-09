package com.pwojczyn.reservationApp.controllers;

import com.pwojczyn.reservationApp.models.forms.ReservationForm;
import com.pwojczyn.reservationApp.models.repositories.ReservationRepository;
import com.pwojczyn.reservationApp.models.services.ReservationModel;
import com.pwojczyn.reservationApp.models.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    StringService stringService;

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("reservationForm", new ReservationForm());
        model.addAttribute("reservations",reservationRepository.findByDateBetween(LocalDate.now(),LocalDate.now().plusWeeks(1)));

        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult result, Model model){
        if (result.hasErrors()){
            return "index";
        }else if(reservationRepository.existsByDateEquals(form.getFormatedDate())){
            model.addAttribute("errors","Termin już zajęty");
        }
        reservationRepository.save(new ReservationModel(form));
        model.addAttribute("reservations",reservationRepository.findByDateBetween(LocalDate.now(),LocalDate.now().plusWeeks(1)));
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
//        List<ReservationModel> reservationModel =
//               reservationRepository.findbyDateOrderByDesc();


        return "dd";
    }
}

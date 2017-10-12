package com.pwojczyn.reservationApp.models.services;

import com.pwojczyn.reservationApp.models.forms.ReservationForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@Column(name="name")
    private String name;
    private String lastname;
    private LocalDate date;
    private String adres;
    private String pin;

    public ReservationModel(ReservationForm form) {
        name = form.getName();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();
        pin = form.setPin();
    }



}

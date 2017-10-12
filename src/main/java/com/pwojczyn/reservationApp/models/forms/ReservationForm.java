package com.pwojczyn.reservationApp.models.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class ReservationForm {
    @Getter
    @Setter
    @NotBlank
    @Size(min =3, max=25)
    private String name;
    @Getter
    @Setter
    @NotBlank
    @Size(min =3, max=25)
    private String lastname;
    @Getter
    @Setter
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "Write date in the format yyyy-MM-dd")
    private String date;
    @Getter
    @Setter
    @NotBlank
    @Size(min =5, max=75)
    private String adres;
    @Getter
    private String pin;

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate() {
        //YYYY-MM-DD
        return LocalDate.parse(date, format);

    }

    public String setPin() {
        this.pin = generatPin();
        return this.pin;
    }

    public String generatPin(){
        int tempInt = 0;
        StringBuilder tempPin = new StringBuilder();
        for(int i =1; i<=6; i++ ){
            tempInt = new Random().nextInt(10);
            tempPin.append(tempInt);
        }
        return tempPin.toString();
    }
}

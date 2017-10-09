package com.pwojczyn.reservationApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = {ReservationAppApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class ReservationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationAppApplication.class, args);
	}
}

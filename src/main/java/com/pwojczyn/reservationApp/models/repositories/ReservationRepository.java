package com.pwojczyn.reservationApp.models.repositories;

import com.pwojczyn.reservationApp.models.services.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {
    List<ReservationModel> findByName(String name);
    ReservationModel findByNameAndLastname(String name,String lastname);
    //1. Znajdz rezerwacje, gdzie nazwisko zawiera w sobie litiere "a"
    List<ReservationModel> findByLastnameContaining(String search);
    List<ReservationModel> findByIdGreaterThan(int number);
    //List<ReservationModel> findbyDate
            ReservationModel findByDate(LocalDate date);
            boolean existsByDateEquals(LocalDate date);
    List<ReservationModel> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

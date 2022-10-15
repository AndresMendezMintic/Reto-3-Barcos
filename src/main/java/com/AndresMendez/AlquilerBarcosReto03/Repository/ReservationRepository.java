package com.AndresMendez.AlquilerBarcosReto03.Repository;

import com.AndresMendez.AlquilerBarcosReto03.Crud.ReservationCrudRepository;
import com.AndresMendez.AlquilerBarcosReto03.Modelo.Reservation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Mendez
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }

}

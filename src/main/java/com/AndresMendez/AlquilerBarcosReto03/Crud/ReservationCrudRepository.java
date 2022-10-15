package com.AndresMendez.AlquilerBarcosReto03.Crud;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}

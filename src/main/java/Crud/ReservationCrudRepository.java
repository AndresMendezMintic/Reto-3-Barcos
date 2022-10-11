package Crud;

import Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}

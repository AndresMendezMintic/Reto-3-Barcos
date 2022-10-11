package Crud;

import Modelo.Boat;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface BoatCrudRepository extends CrudRepository<Boat, Integer>{
    
}

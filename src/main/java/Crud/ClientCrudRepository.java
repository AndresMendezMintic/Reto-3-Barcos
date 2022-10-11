package Crud;

import Modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}

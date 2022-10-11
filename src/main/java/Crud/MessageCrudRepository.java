package Crud;

import Modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}

package Crud;

import Modelo.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface AdminCrudRepository extends CrudRepository<Admin, Integer>{
    
}

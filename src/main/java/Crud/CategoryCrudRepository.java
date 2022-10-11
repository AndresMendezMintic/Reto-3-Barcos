package Crud;

import Modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}

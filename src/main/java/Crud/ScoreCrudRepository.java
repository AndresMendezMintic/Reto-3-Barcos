package Crud;

import Modelo.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ScoreCrudRepository extends CrudRepository<Score, Integer>{
    
}

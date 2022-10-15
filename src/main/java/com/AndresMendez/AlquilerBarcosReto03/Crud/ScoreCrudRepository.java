package com.AndresMendez.AlquilerBarcosReto03.Crud;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
    
}

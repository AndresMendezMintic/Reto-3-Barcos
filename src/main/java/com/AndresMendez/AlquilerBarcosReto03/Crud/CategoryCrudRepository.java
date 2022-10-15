package com.AndresMendez.AlquilerBarcosReto03.Crud;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}

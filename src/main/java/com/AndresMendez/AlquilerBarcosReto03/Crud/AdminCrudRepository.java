package com.AndresMendez.AlquilerBarcosReto03.Crud;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
    
}

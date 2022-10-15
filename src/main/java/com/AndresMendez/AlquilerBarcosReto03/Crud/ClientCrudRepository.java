package com.AndresMendez.AlquilerBarcosReto03.Crud;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Mendez
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
    
}

package com.AndresMendez.AlquilerBarcosReto03.Repository;

import com.AndresMendez.AlquilerBarcosReto03.Crud.BoatCrudRepository;
import com.AndresMendez.AlquilerBarcosReto03.Modelo.Boat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Mendez
 */
@Repository
public class BoatRepository {

    @Autowired
    private BoatCrudRepository boatCrudRepository;

    public List<Boat> getAll() {
        return (List<Boat>) boatCrudRepository.findAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatCrudRepository.findById(id);
    }

    public Boat save(Boat boat) {
        return boatCrudRepository.save(boat);
    }

    public void delete(Boat boat) {
        boatCrudRepository.delete(boat);
    }

    public void deleteAll() {
        boatCrudRepository.deleteAll();
    }
}

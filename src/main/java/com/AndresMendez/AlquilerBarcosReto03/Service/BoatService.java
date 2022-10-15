package com.AndresMendez.AlquilerBarcosReto03.Service;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Boat;
import com.AndresMendez.AlquilerBarcosReto03.Repository.BoatRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Mendez
 */
@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boat) {
        if (boat.getId() == null) {
            return boatRepository.save(boat);
        } else {
            Optional<Boat> boatAux = boatRepository.getBoat(boat.getId());
            if (boatAux.isPresent()) {
                return boat;
            } else {
                return boatRepository.save(boat);
            }
        }

    }

    public Boat update(Boat boat) {
        if (boat.getId() != null) {
            Optional<Boat> upd = boatRepository.getBoat(boat.getId());
            if (upd.isPresent()) {
                if (boat.getName() != null) {
                    upd.get().setName(boat.getName());
                }
                if (boat.getBrand() != null) {
                    upd.get().setBrand(boat.getBrand());
                }
                if (boat.getYear() != null) {
                    upd.get().setYear(boat.getYear());
                }
                if (boat.getDescription() != null) {
                    upd.get().setDescription(boat.getDescription());
                }
                if (boat.getCategory() != null) {
                    upd.get().setCategory(boat.getCategory());
                }
                boatRepository.save(upd.get());
                return upd.get();
            } else {
                return boat;
            }
        } else {
            return boat;
        }
    }

    public void delete(int id) {
        Optional<Boat> boat = boatRepository.getBoat(id);
        if (boat.isPresent()) {
            boatRepository.delete(boat.get());
        }
    }

    //public void deleteAll() {
        //boatRepository.deleteAll();
    //}
}

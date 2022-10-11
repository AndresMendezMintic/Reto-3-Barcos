package Service;

import Modelo.Boat;
import Repository.BoatRepository;
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
            Optional<Boat> aux = boatRepository.getBoat(boat.getId());
            if (aux.isPresent()) {
                return boat;
            } else {
                return boatRepository.save(boat);
            }
        }
    }

    public Boat update(Boat boat) {
        if (boat.getId() != null) {
            Optional<Boat> e = boatRepository.getBoat(boat.getId());
            if (!e.isEmpty()) {
                if (boat.getId() != null) {
                    e.get().setId(boat.getId());
                }
                if (boat.getName() != null) {
                    e.get().setName(boat.getName());
                }
                if (boat.getBrand() != null) {
                    e.get().setBrand(boat.getBrand());
                }
                if (boat.getYear() != null) {
                    e.get().setYear(boat.getYear());
                }
                if (boat.getDescription() != null) {
                    e.get().setDescription(boat.getDescription());
                }
                boatRepository.save(e.get());
                return e.get();
            } else {
                return boat;
            }
        } else {
            return boat;
        }
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional<Boat> b = boatRepository.getBoat(id);
        if (b.isPresent()){
            boatRepository.delete(b.get());
        }
        return flag;
    }

}

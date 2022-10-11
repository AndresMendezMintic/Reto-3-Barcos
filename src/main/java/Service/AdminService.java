package Service;

import Modelo.Admin;
import Modelo.Boat;
import Repository.AdminRepository;
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
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> aux = adminRepository.getAdmin(admin.getIdAdmin());
            if (aux.isPresent()) {
                return admin;
            } else {
                return adminRepository.save(admin);
            }
        }
    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> e = adminRepository.getAdmin(admin.getIdAdmin());
            if (!e.isEmpty()) {
                if (admin.getIdAdmin() != null) {
                    e.get().setIdAdmin(admin.getIdAdmin());
                }
                if (admin.getEmail() != null) {
                    e.get().setEmail(admin.getEmail());
                }
                if (admin.getName() != null) {
                    e.get().setName(admin.getName());
                }
                if (admin.getPassword() != null) {
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.save(e.get());
                return e.get();
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional<Admin> b = adminRepository.getAdmin(id);
        if (b.isPresent()){
            adminRepository.delete(b.get());
        }
        return flag;
    }
    
}

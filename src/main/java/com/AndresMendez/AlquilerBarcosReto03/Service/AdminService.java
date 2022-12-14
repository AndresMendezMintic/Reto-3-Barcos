package com.AndresMendez.AlquilerBarcosReto03.Service;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Admin;
import com.AndresMendez.AlquilerBarcosReto03.Repository.AdminRepository;
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
            Optional<Admin> q = adminRepository.getAdmin(admin.getIdAdmin());
            if (q.isPresent()) {
                if (admin.getName() != null) {
                    q.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    q.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    q.get().setPassword(admin.getPassword());
                }
                adminRepository.save(q.get());
                return q.get();
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean delete(int idAdmin) {
        boolean flag = false;
        Optional<Admin> admin = adminRepository.getAdmin(idAdmin);
        if (admin.isPresent()) {
            adminRepository.delete(admin.get());
            flag = true;
        }
        return flag;
    }
}

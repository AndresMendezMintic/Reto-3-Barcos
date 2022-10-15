package com.AndresMendez.AlquilerBarcosReto03.Repository;

import com.AndresMendez.AlquilerBarcosReto03.Crud.AdminCrudRepository;
import com.AndresMendez.AlquilerBarcosReto03.Modelo.Admin;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Mendez
 */
@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin) {
        return adminCrudRepository.save(admin);
    }

    public void delete(Admin admin) {
        adminCrudRepository.delete(admin);
    }
}

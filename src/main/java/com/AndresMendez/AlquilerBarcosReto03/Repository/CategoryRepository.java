package com.AndresMendez.AlquilerBarcosReto03.Repository;

import com.AndresMendez.AlquilerBarcosReto03.Crud.CategoryCrudRepository;
import com.AndresMendez.AlquilerBarcosReto03.Modelo.Category;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Mendez
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }

    public void delete(Category category) {
        categoryCrudRepository.delete(category);
    }

    //public void deleteAll() {
        //categoryCrudRepository.deleteAll();
    //}
}

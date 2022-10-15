package com.AndresMendez.AlquilerBarcosReto03.Service;

import com.AndresMendez.AlquilerBarcosReto03.Modelo.Category;
import com.AndresMendez.AlquilerBarcosReto03.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Mendez
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int idCategory) {
        return categoryRepository.getCategory(idCategory);
    }

    public Category save(Category category){
        if(category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> categoryAux = categoryRepository.getCategory(category.getId());
            if(categoryAux.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> q = categoryRepository.getCategory(category.getId());
            if (q.isPresent()) {
                if (category.getName() != null) {
                    q.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    q.get().setDescription(category.getDescription());
                }
                if (category.getBoats() != null) {
                    q.get().setBoats(category.getBoats());
                }
                categoryRepository.save(q.get());
                return q.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional <Category> c = categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
        }
        return flag;
    }

    //public boolean deleteCategory(int id) {
        //Boolean d = getCategory(id).map(category -> {
            //categoryRepository.delete(category);
            //return true;
        //}).orElse(false);
        //return d;
    //}

    //public boolean deleteCategory(int id) {
        //Optional<Category> category = categoryRepository.getCategory(id);
       // if (category.isPresent()) {
           // categoryRepository.delete(category.get());
        //}
    }

    //public void deleteAll() {
        //categoryRepository.deleteAll();
    //}


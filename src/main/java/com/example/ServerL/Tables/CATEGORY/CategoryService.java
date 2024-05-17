package com.example.ServerL.Tables.CATEGORY;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

        private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> getCategory(){
       return repository.findAll();
    }
}

package com.vasmen.recipemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasmen.recipemanagement.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @SuppressWarnings("null")
    @Override
    List<Recipe> findAll();

    Optional<Recipe> findById(int id);

    Recipe findByName(String name);

    Boolean existsById(int id);
}

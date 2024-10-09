package com.vasmen.recipemanagement.service.interfaces;

import java.util.List;

import com.vasmen.recipemanagement.dto.RecipeCreateUpdateDTO;
import com.vasmen.recipemanagement.dto.RecipeDTO;

public interface RecipeService {
    
    List<RecipeDTO> getRecipes();

    RecipeDTO getRecipeById(int id);

    RecipeDTO saveRecipe(RecipeCreateUpdateDTO recipeDTO);

    RecipeDTO updateRecipe(int id, RecipeCreateUpdateDTO recipeCreateUpdateDTO);

    Boolean deleteRecipe(int id);

    RecipeDTO updateVotes(int id, boolean vote);
}

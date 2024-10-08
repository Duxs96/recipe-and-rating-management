package comvasmenrecipemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comvasmenrecipemanagement.dto.RecipeCreateUpdateDTO;
import comvasmenrecipemanagement.dto.RecipeDTO;
import comvasmenrecipemanagement.entity.Recipe;
import comvasmenrecipemanagement.repository.RecipeRepository;

@Service
public class RecipeService {

    private final RecipeRepository _recipeRepository;

    public RecipeService(RecipeRepository recipeRepository){
        _recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getRecipes() {
        List<Recipe> recipes = _recipeRepository.findAll();
        List<RecipeDTO> recipesDTO = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipesDTO.add(mappingToDTO(recipe));
        }
        return recipesDTO;
    }

    public RecipeDTO getRecipeById(int id){
        Optional<Recipe> recipe = _recipeRepository.findById(id);
        RecipeDTO recipeDTO = mappingToDTO(recipe.get());
        return recipeDTO;
    }

    public RecipeDTO saveRecipe(RecipeCreateUpdateDTO recipeDTO){
        Recipe recipe = mappingToEntity(recipeDTO);
        _recipeRepository.save(recipe);
        RecipeDTO recipeDTOCreated = mappingToDTO(recipe);
        return recipeDTOCreated;
    }

    public RecipeDTO updateRecipe(int id, RecipeCreateUpdateDTO recipeCreateUpdateDTO){
        Optional<Recipe> recipe = _recipeRepository.findById(id);
        if(recipe.isPresent()){
            _recipeRepository.save(mappingDTOToEntity(recipe.get(), recipeCreateUpdateDTO));
            return mappingToDTO(recipe.get());
        }
        return null;
    }

    public Boolean deleteRecipe(int id){
        Boolean exists = _recipeRepository.existsById(id);
        if(!exists){ return null; }
        _recipeRepository.deleteById(id);
        return true;
    }

    public RecipeDTO updateVotes(int id, boolean vote){
        Optional<Recipe> recipe = _recipeRepository.findById(id);
        if(recipe.isPresent()){
            Recipe recipeVotesUpdated = updateVotes(recipe.get(), vote);
            _recipeRepository.save(recipeVotesUpdated);
            return mappingToDTO(recipeVotesUpdated);
        }
        return null;
    }

    private Recipe updateVotes(Recipe recipe, boolean vote){
        if(vote){
            recipe.setVotes(recipe.getVotes() + 1);
        }else{
            recipe.setVotes(recipe.getVotes() - 2);
        }
        return recipe;
    }

    private Recipe mappingDTOToEntity(Recipe recipe, RecipeCreateUpdateDTO recipeDTO){
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setPreparationTime(recipeDTO.getPreparationTime());
        recipe.setDifficulty(recipeDTO.getDifficulty());
        recipe.setParticipant(recipeDTO.getParticipant());
        return recipe;
    }

    private RecipeDTO mappingToDTO(Recipe recipe){
        RecipeDTO recipeDTO = new RecipeDTO();
        if(recipe == null){return recipeDTO;}
        recipeDTO.setId(recipe.getId());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setInstructions(recipe.getInstructions());
        recipeDTO.setPreparationTime(recipe.getPreparationTime());
        recipeDTO.setDifficulty(recipe.getDifficulty());
        recipeDTO.setParticipant(recipe.getParticipant());
        recipeDTO.setVotes(recipe.getVotes());
        return recipeDTO;
    }

    private Recipe mappingToEntity(RecipeCreateUpdateDTO recipecreateUpdateDTO){
        Recipe recipe = new Recipe();
        recipe.setName(recipecreateUpdateDTO.getName());
        recipe.setDescription(recipecreateUpdateDTO.getDescription());
        recipe.setIngredients(recipecreateUpdateDTO.getIngredients());
        recipe.setInstructions(recipecreateUpdateDTO.getInstructions());
        recipe.setPreparationTime(recipecreateUpdateDTO.getPreparationTime());
        recipe.setDifficulty(recipecreateUpdateDTO.getDifficulty());
        recipe.setParticipant(recipecreateUpdateDTO.getParticipant());
        return recipe;
    }

}

package comvasmenrecipemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comvasmenrecipemanagement.service.RecipeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import comvasmenrecipemanagement.dto.RecipeDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import comvasmenrecipemanagement.dto.RecipeCreateUpdateDTO;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService _recipeService;

    public RecipeController(RecipeService recipeService){
        _recipeService = recipeService;
    }

    @GetMapping()
    public ResponseEntity<List<RecipeDTO>> getRecipes() {
        List<RecipeDTO> recipesList = _recipeService.getRecipes();
        return ResponseEntity.ok(recipesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getMethodName(@PathVariable int id) {
        RecipeDTO recipeDTO = _recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipeDTO);
    }

    @PostMapping()
    public ResponseEntity<RecipeDTO> postMethodName(@RequestBody RecipeCreateUpdateDTO recipeCreateUpdateDTO) {
        RecipeDTO recipeDTOCreated = _recipeService.saveRecipe(recipeCreateUpdateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeDTOCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> putMethodName(@PathVariable int id, @RequestBody RecipeCreateUpdateDTO recipeCreateUpdateDTO) {
        RecipeDTO recipeDTOUpdated = _recipeService.updateRecipe(id, recipeCreateUpdateDTO);
        if(recipeDTOUpdated != null){
            return ResponseEntity.ok(recipeDTOUpdated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable int id){
        Boolean success = _recipeService.deleteRecipe(id);
        if(success == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(success);
    }

    @PostMapping("/{id}/{vote}")
    public ResponseEntity<RecipeDTO> postMethodName(@PathVariable int id, @PathVariable boolean vote) {
        RecipeDTO recipeDTOVotesupdated = _recipeService.updateVotes(id, vote);
        if(recipeDTOVotesupdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeDTOVotesupdated);
    }
}

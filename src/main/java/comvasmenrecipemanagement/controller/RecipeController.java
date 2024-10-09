package comvasmenrecipemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comvasmenrecipemanagement.service.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import comvasmenrecipemanagement.dto.RecipeDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import comvasmenrecipemanagement.dto.RecipeCreateUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/recipe")
@Tag(name="Controlador de Recetas")
public class RecipeController {

    private final RecipeService _recipeService;

    public RecipeController(RecipeService recipeService){
        _recipeService = recipeService;
    }

    @Operation(summary="Obtener todas las recetas")
    @GetMapping()
    public ResponseEntity<List<RecipeDTO>> getRecipes() {
        List<RecipeDTO> recipesList = _recipeService.getRecipes();
        return ResponseEntity.ok(recipesList);
    }

    @Operation(summary="Obtener una receta por el id")
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getMethodName(@PathVariable int id) {
        RecipeDTO recipeDTO = _recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipeDTO);
    }

    @Operation(summary="Registrar nueva receta")
    @PostMapping()
    public ResponseEntity<RecipeDTO> postMethodName(@Valid @RequestBody RecipeCreateUpdateDTO recipeCreateUpdateDTO) {
        RecipeDTO recipeDTOCreated = _recipeService.saveRecipe(recipeCreateUpdateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeDTOCreated);
    }

    @Operation(summary="Actualizar una receta por el id")
    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> putMethodName(@PathVariable int id,@Valid @RequestBody RecipeCreateUpdateDTO recipeCreateUpdateDTO) {
        RecipeDTO recipeDTOUpdated = _recipeService.updateRecipe(id, recipeCreateUpdateDTO);
        if(recipeDTOUpdated != null){
            return ResponseEntity.ok(recipeDTOUpdated);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary="Eliminar una receta por el id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable int id){
        Boolean success = _recipeService.deleteRecipe(id);
        if(success == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(success);
    }

    @Operation(summary="Realizar votación de receta por id")
    @PostMapping("/{id}/{vote}")
    public ResponseEntity<RecipeDTO> postMethodName(@PathVariable int id, @PathVariable boolean vote) {
        RecipeDTO recipeDTOVotesupdated = _recipeService.updateVotes(id, vote);
        if(recipeDTOVotesupdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeDTOVotesupdated);
    }
}

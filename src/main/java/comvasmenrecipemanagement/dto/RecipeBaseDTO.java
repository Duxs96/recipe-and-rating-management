package comvasmenrecipemanagement.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecipeBaseDTO {

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 100, message = "El nombre de la receta debe tener entre 3 y 100 caracteres")
    private String name;
    @NotBlank(message = "La descripción es requerida")
    private String description;
    @NotEmpty(message = "La lista de ingredientes no puede estar vacía")
    @Size(min=1, message="La lista de ingredientes debe tener un producto como mínimo")
    private List<String> ingredients;
    private String instructions;
    @NotNull(message = "El tiempo de preparación es requerido")
    @Min(value = 2, message = "El tiempo de preparación debe ser mayor a 1 minuto")
    private Integer preparationTime;
    private String difficulty;
    private String participant;

    //CONSTRUCTOR...
    public RecipeBaseDTO(){}

    // GETTER AND SETTER...
    //NAME...
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //DESCRIPTION...
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //INGREDIENTS...
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    //INSTRUCTIONS...
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    //PREPARATIONTIME...
    public Integer getPreparationTime() {
        return preparationTime;
    }
    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    //DIFFICULTY...
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    //PARTICIPANT...
    public String getParticipant() {
        return participant;
    }
    public void setParticipant(String participant) {
        this.participant = participant;
    }
}

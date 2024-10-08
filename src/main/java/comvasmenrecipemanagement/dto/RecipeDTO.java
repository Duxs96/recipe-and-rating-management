package comvasmenrecipemanagement.dto;

public class RecipeDTO extends RecipeBaseDTO {

    private Integer id;
    private Integer votes;

    public RecipeDTO(){}

    // GETTER AND SETTER...

    //ID...
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //VOTES...
    public Integer getVotes() {
        return votes;
    }
    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}

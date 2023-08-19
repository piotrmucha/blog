package blog.piotrmucha.post.program;

public interface NutritionProgram {
    boolean shouldOfferProgramForClient(Client client);
    void offerProgram(Client client);
}

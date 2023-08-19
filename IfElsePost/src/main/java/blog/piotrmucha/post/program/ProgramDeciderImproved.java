package blog.piotrmucha.post.program;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProgramDeciderImproved {
    private final List<NutritionProgram> nutritionPrograms;

    public ProgramDeciderImproved(List<NutritionProgram> nutritionPrograms) {
        this.nutritionPrograms = nutritionPrograms;
    }

    public void raiseNotificationForClient(Client client) {
        for (NutritionProgram nutritionProgram : nutritionPrograms) {
            if (nutritionProgram.shouldOfferProgramForClient(client)) {
                nutritionProgram.offerProgram(client);
                break;
            }
        }
    }
}

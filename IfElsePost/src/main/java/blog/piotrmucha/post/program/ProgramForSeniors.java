package blog.piotrmucha.post.program;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ProgramForSeniors implements NutritionProgram {
    @Override
    public boolean shouldOfferProgramForClient(Client client) {
        return client.age() > 80;
    }
    @Override
    public void offerProgram(Client client) {
        System.out.println("Program for Seniors");
    }
}

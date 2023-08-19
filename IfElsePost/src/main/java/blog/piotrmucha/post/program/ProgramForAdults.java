package blog.piotrmucha.post.program;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ProgramForAdults implements NutritionProgram {
    @Override
    public boolean shouldOfferProgramForClient(Client client) {
        return client.age() >= 20 && client.age() <= 80
                && client.accountAge().minusMinutes(60).isNegative();
    }
    @Override
    public void offerProgram(Client client) {
        System.out.println("Program for Adults");
    }
}

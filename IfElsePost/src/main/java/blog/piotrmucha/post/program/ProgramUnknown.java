package blog.piotrmucha.post.program;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ProgramUnknown implements NutritionProgram {
    @Override
    public boolean shouldOfferProgramForClient(Client client) {
        return true;
    }
    @Override
    public void offerProgram(Client client) {
        System.out.println("We don't offer program for clients in your age: %s".formatted(client.age()));
    }
}

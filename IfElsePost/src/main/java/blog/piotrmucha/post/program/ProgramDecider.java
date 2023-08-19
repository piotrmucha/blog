package blog.piotrmucha.post.program;

public class ProgramDecider {

    public void raiseNotificationForClient(Client client) {
        int age = client.age();
        if (age >= 80) {
            System.out.println("Weight lose program for seniors");
        } else if (age >= 20 && client.accountAge().minusMinutes(60).isNegative()) {
            System.out.println("Weight logs program for adults");
        } else {
            System.out.println("We don't offer program for clients in your age.");
        }
    }
}

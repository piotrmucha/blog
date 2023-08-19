package blog.piotrmucha.post.program;

import java.time.Duration;

public record Client(String name, int age, Duration accountAge) {
}

package blog.piotrmucha.post;

import blog.piotrmucha.post.program.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestWithSpring {
	@Autowired
	ProgramDeciderImproved programDecider;

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@ParameterizedTest
	@MethodSource("arguments")
	void properNotificationIsRaised(int clientAge, Duration accountAge, String expectedProgram) {
		//given
		var client = new Client("Peter", clientAge, accountAge);

		//when
		programDecider.raiseNotificationForClient(client);

		//then
		assertEquals(expectedProgram, outputStreamCaptor.toString());
	}

	static Stream<Arguments> arguments() {
		return Stream.of(
				Arguments.of(20, Duration.ofHours(5), "We don't offer program for clients in your age: 20\n"),
				Arguments.of(25, Duration.ofMinutes(20), "Program for Adults\n"),
				Arguments.of(85, Duration.ofHours(5), "Program for Seniors\n")
		);
	}

}

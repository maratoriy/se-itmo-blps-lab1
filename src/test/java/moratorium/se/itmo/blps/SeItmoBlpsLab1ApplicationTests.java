package moratorium.se.itmo.blps;

import moratorium.se.itmo.blps.config.EmbeddedDatasourceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {EmbeddedDatasourceConfiguration.class})
class SeItmoBlpsLab1ApplicationTests {

	@Test
	void contextLoads() {
	}

}

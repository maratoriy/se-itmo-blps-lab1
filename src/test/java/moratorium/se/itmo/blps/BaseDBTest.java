package moratorium.se.itmo.blps;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import moratorium.se.itmo.blps.config.EmbeddedDatasourceConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ContextConfiguration(classes = {EmbeddedDatasourceConfiguration.class})
@SpringBootTest(classes = SeItmoBlpsLab1Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class BaseDBTest {
}

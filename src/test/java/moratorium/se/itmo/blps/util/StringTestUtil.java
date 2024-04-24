package moratorium.se.itmo.blps.util;

import java.nio.charset.StandardCharsets;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

@UtilityClass
public final class StringTestUtil {
    private final ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Nonnull
    public static String getString(String fileName) {
        try {
            return StreamUtils.copyToString(
                    resourceLoader.getResource("classpath:" + fileName).getInputStream(),
                    StandardCharsets.UTF_8);
        } catch (final Exception ex) {
            throw new RuntimeException("Could not read file " + fileName);
        }
    }
}

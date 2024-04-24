package moratorium.se.itmo.blps.service.movie;

import java.util.List;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import moratorium.se.itmo.blps.BaseDBTest;
import moratorium.se.itmo.blps.domain.movie.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovieServiceTest extends BaseDBTest {
    @Autowired
    private MovieService movieService;
    
    @Test
    @ExpectedDatabase(value = "classpath:/service/movieService.addMovie.after.xml", assertionMode =
            DatabaseAssertionMode.NON_STRICT)
    void addMovie() {
        MovieEntity movie = MovieEntity.builder()
                .title("Фильм1")
                .description("Описание1")
                .director("Директор1")
                .releaseYear(1920)
                .genre("Жанр1")
                .duration(120)
                .build();

        movieService.addMovie(movie);
    }

    @Test
    @DatabaseSetup(value = "classpath:/service/movieService.getMovies.before.xml")
    void getMovies() {
        var movies = movieService.getMovies();
        var expectedMovies = List.of(
                MovieEntity.builder()
                        .title("Фильм1")
                        .description("Описание1")
                        .director("Директор1")
                        .releaseYear(1920)
                        .genre("Жанр1")
                        .duration(120)
                        .build(),
                MovieEntity.builder()
                        .title("Фильм2")
                        .description("Описание2")
                        .director("Директор2")
                        .releaseYear(1920)
                        .genre("Жанр2")
                        .duration(120)
                        .build()
        );

        assertEquals(expectedMovies, movies);
    }
}

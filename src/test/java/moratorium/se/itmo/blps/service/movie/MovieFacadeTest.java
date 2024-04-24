package moratorium.se.itmo.blps.service.movie;

import java.util.List;
import java.util.stream.Collectors;

import moratorium.se.itmo.blps.controller.movie.dto.AddMovieRequestDto;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieResponseDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMoviesResponseDto;
import moratorium.se.itmo.blps.domain.movie.MovieEntity;
import moratorium.se.itmo.blps.service.movie.mapper.MovieMapper;
import moratorium.se.itmo.blps.service.movie.mapper.MovieMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MovieMapperImpl.class})
class MovieFacadeTest {
    @Mock
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    private MovieFacade movieFacade;

    @BeforeEach
    void setup() {
        movieFacade = new MovieFacade(movieService, movieMapper);
    }

    @Test
    void addMovie() {
        final long mockedId = 1L;

        var requestDto = new AddMovieRequestDto(
                "Фильм1",
                "Описание1",
                "Директор1",
                1920,
                "Жанр1",
                120
        );
        doReturn(mockedId).when(movieService).addMovie(eq(movieMapper.map(requestDto)));

        var expectedDto = AddMovieResponseDto.builder()
                .movieId(mockedId)
                .build();
        var actualDto = movieFacade.addMovie(requestDto);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    void getMovies() {
        var movies = List.of(
                MovieEntity.builder()
                        .id(1L)
                        .title("Фильм1")
                        .description("Описание1")
                        .director("Директор1")
                        .releaseYear(1920)
                        .genre("Жанр1")
                        .duration(120)
                        .build()
        );
        doReturn(movies).when(movieService).getMovies();

        var expectedDto = GetMoviesResponseDto.builder()
                .movies(movies.stream().map(movieMapper::map).collect(Collectors.toList()))
                .build();
        var actualDto = movieFacade.getMovies();

        assertEquals(actualDto, expectedDto);
    }
}
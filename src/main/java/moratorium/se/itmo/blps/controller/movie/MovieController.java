package moratorium.se.itmo.blps.controller.movie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieRequestDto;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieResponseDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMoviesResponseDto;
import moratorium.se.itmo.blps.service.movie.MovieFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Tag(name = "movie", description = "Взаимодействие с каталогом фильмов")
public class MovieController {
    private final MovieFacade movieFacade;

    @Operation(summary = "Добавить новый фильм в каталог")
    @PostMapping("/add")
    public AddMovieResponseDto addMovie(AddMovieRequestDto createRequestDto) {
        return movieFacade.addMovie(createRequestDto);
    }

    //TODO: добавить фильтрацию и пагинацию
    @Operation(summary = "Получить фильмы из каталога")
    @GetMapping
    public GetMoviesResponseDto getMovies() {
        return movieFacade.getMovies();
    }
}

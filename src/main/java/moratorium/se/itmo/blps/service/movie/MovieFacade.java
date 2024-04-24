package moratorium.se.itmo.blps.service.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieRequestDto;
import moratorium.se.itmo.blps.controller.movie.dto.AddMovieResponseDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMoviesResponseDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieFacade {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    // @Transactional
    public AddMovieResponseDto addMovie(AddMovieRequestDto createRequestDto) {
        final Long savedEntityId = movieService.addMovie(movieMapper.map(createRequestDto));

        return AddMovieResponseDto.builder()
                .movieId(savedEntityId)
                .build();
    }

    public GetMoviesResponseDto getMovies() {
        final var movies = movieService.getMovies()
                .stream()
                .map(movieMapper::map)
                .toList();
        return GetMoviesResponseDto.builder()
                .movies(movies)
                .build();
    }
}

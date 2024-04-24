package moratorium.se.itmo.blps.service.movie;

import java.util.List;

import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.domain.movie.MovieEntity;
import moratorium.se.itmo.blps.domain.movie.MovieRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepo movieRepo;

    // @Transactional
    public Long addMovie(MovieEntity entity) {
        return movieRepo.save(entity).getId();
    }

    public List<MovieEntity> getMovies() {
        return movieRepo.findAll();
    }
}

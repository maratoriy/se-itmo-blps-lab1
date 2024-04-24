package moratorium.se.itmo.blps.service.movie;

import moratorium.se.itmo.blps.controller.movie.dto.AddMovieRequestDto;
import moratorium.se.itmo.blps.controller.movie.dto.GetMovieResponseDto;
import moratorium.se.itmo.blps.domain.movie.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieEntity map(AddMovieRequestDto dto);

    @Mapping(target = "movieId", source = "entity.id")
    GetMovieResponseDto map(MovieEntity entity);
}

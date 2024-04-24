package moratorium.se.itmo.blps.controller.movie.dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonSerialize
@Getter
@Builder
@EqualsAndHashCode
public class GetMoviesResponseDto {

    @ArraySchema(schema = @Schema(name = "Фильмы", implementation = GetMovieResponseDto.class))
    private final List<GetMovieResponseDto> movies;
}

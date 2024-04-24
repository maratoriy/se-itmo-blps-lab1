package moratorium.se.itmo.blps.controller.review.dto;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.movie.dto.GetMovieReviewResponseDto;

@RequiredArgsConstructor
@Getter
@JsonSerialize
@Builder
@EqualsAndHashCode
public class GetAssignedReviewsResponseDto {

    @ArraySchema(schema = @Schema(implementation = GetMovieReviewResponseDto.class))
    private final List<GetAssignedReviewResponseDto> reviews;
}

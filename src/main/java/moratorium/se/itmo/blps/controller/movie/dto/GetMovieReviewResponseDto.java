package moratorium.se.itmo.blps.controller.movie.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonSerialize
@Builder
@EqualsAndHashCode
public class GetMovieReviewResponseDto {
    @Schema(title = "ID пользователя", example = "1")
    private final Long userId;

    @Schema(title = "Текст рецензии", example = "Фильм не очень")
    private final String content;

    @Schema(title = "Дата публикация")
    private final String publicationDate;
}

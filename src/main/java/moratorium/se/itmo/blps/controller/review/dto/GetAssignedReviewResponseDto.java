package moratorium.se.itmo.blps.controller.review.dto;

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
public class GetAssignedReviewResponseDto {
    @Schema(title = "ID рецензии", example = "1")
    private final Long reviewId;

    @Schema(title = "ID пользователя", example = "1")
    private final Long userId;

    @Schema(title = "ID фильма", example = "1")
    private final Long movieId;

    @Schema(title = "Текст рецензии", example = "Фильм не очень")
    private final String content;

    @Schema(title = "Дата публикация")
    private final String creationDate;
}

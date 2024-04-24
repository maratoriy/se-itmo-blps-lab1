package moratorium.se.itmo.blps.controller.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonDeserialize
@AllArgsConstructor
@EqualsAndHashCode
public class PostReviewRequestDto {
    @NotNull
    @Schema(title = "ID пользователя", example = "1")
    private Long userId;

    @NotEmpty
    @Schema(title = "Текст рецензии", example = "Фильм не очень")
    private String content;

    @NotNull
    @Schema(title = "ID фильма", example = "1")
    private Long movieId;

}

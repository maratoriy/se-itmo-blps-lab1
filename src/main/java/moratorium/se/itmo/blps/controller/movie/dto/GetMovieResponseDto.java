package moratorium.se.itmo.blps.controller.movie.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonSerialize
@EqualsAndHashCode
public class GetMovieResponseDto {
    @Schema(title = "Внутренний id фильма", example = "1")
    private final Long movieId;


    @Schema(title = "Название фильма",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Интересный фильм"
    )
    @Size(max = 255)
    @NotEmpty
    private final String title;

    @Schema(title = "Описание фильма", example = "Фильм с интересным актером")
    private final String description;

    @Schema(title = "Режиссер фильма", example = "Интересный режиссер")
    @Size(max = 255)
    private final String director;

    @Schema(title = "Год выпуска фильма", example = "1900")
    @Min(1895)
    private final Integer releaseYear;

    @Schema(title = "Жанр фильма", example = "Интересный жанр")
    @Size(max = 100)
    private final String genre;

    @Schema(title = "Продолжительность фильма в минутах", example = "70")
    @Positive
    private final Integer duration;
}

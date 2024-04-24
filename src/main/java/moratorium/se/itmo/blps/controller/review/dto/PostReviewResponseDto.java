package moratorium.se.itmo.blps.controller.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonSerialize
@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class PostReviewResponseDto {
    @Schema(title = "Внутренний id ревью", example = "1")
    private final Long reviewId;
}

package moratorium.se.itmo.blps.controller.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonSerialize
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class AddUserResponseDto {
    @Schema(title = "Внутренний id пользователя", example = "1")
    private final Long userId;
}

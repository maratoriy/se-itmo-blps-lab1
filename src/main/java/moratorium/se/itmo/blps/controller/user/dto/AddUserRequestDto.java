package moratorium.se.itmo.blps.controller.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import moratorium.se.itmo.blps.util.Value;

@Getter
@JsonDeserialize
@AllArgsConstructor
@EqualsAndHashCode
public class AddUserRequestDto {
    @NotEmpty
    @Schema(title = "Логин", example = "moratorium")
    private String name;

    @Email
    @NotEmpty
    @Schema(title = "Электронная почта", example = "example@gmail.ru")
    private String email;

    @Value(values = {"USER", "MODERATOR"})
    @Schema(title = "Роль пользователя", example = "USER")
    private String role;
}

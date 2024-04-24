package moratorium.se.itmo.blps.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.user.dto.AddUserRequestDto;
import moratorium.se.itmo.blps.controller.user.dto.AddUserResponseDto;
import moratorium.se.itmo.blps.service.user.UserFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "user", description = "Пользователи")
public class UserController {
    private final UserFacade userFacade;

    @Operation(summary = "Добавить нового пользователя")
    @PostMapping("/add")
    public AddUserResponseDto addUser(@Valid AddUserRequestDto requestDto) {
        return userFacade.addUser(requestDto);
    }
}

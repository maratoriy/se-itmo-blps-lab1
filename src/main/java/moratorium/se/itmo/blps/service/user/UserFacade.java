package moratorium.se.itmo.blps.service.user;

import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.user.dto.AddUserRequestDto;
import moratorium.se.itmo.blps.controller.user.dto.AddUserResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    // @Transactional
    public AddUserResponseDto addUser(AddUserRequestDto requestDto) {
        var newId = userService.addUser(userMapper.map(requestDto));

        return AddUserResponseDto.builder()
                .userId(newId)
                .build();
    }
}

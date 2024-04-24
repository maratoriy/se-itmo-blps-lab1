package moratorium.se.itmo.blps.service.user;

import moratorium.se.itmo.blps.controller.user.dto.AddUserRequestDto;
import moratorium.se.itmo.blps.domain.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity map(AddUserRequestDto requestDto);
}

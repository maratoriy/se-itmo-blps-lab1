package moratorium.se.itmo.blps.service.user;

import java.util.NoSuchElementException;
import java.util.Random;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moratorium.se.itmo.blps.domain.user.UserEntity;
import moratorium.se.itmo.blps.domain.user.UserRepo;
import moratorium.se.itmo.blps.domain.user.UserRole;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final Random random = new Random();

    // @Transactionl
    public Long addUser(UserEntity user) {
        return userRepo.save(user).getId();
    }

    public UserEntity getUser(Long userId) {
        return userRepo.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public UserEntity assignModerator() {
        var moderators = userRepo.findAllByRole(UserRole.MODERATOR);
        if (moderators.isEmpty()) {
            throw new NoSuchElementException();
        }
        return moderators.get(random.nextInt(moderators.size()));
    }
}

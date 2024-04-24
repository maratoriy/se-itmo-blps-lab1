package moratorium.se.itmo.blps.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByRole(UserRole role);
}

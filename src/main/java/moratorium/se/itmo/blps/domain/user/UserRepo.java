package moratorium.se.itmo.blps.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}

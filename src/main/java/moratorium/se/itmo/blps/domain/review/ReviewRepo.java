package moratorium.se.itmo.blps.domain.review;

import java.util.List;

import moratorium.se.itmo.blps.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findAllByReviewer(UserEntity reviewer);
}

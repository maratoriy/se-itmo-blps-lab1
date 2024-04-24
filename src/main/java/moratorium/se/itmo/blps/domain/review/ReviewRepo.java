package moratorium.se.itmo.blps.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {
}

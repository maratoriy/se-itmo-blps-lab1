package moratorium.se.itmo.blps.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<MovieEntity, Long> {
}
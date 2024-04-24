package moratorium.se.itmo.blps.service.review;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.domain.review.ReviewEntity;
import moratorium.se.itmo.blps.domain.review.ReviewRepo;
import moratorium.se.itmo.blps.domain.user.UserEntity;
import moratorium.se.itmo.blps.domain.user.UserRole;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;

    // @Transactional
    public Long saveReview(ReviewEntity review) {
        return reviewRepo.save(review).getId();
    }

    public ReviewEntity getReview(Long reviewId) {
        return reviewRepo.findById(reviewId).orElseThrow(NoSuchElementException::new);
    }

    public List<ReviewEntity> getReviewsByModerator(UserEntity reviewer) {
        if (reviewer.getRole() != UserRole.MODERATOR) {
            throw new NoSuchElementException();
        }
        return reviewRepo.findAllByReviewer(reviewer);
    }
}

package moratorium.se.itmo.blps.service.review;

import java.sql.Timestamp;

import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.movie.dto.GetMovieReviewsResponseDto;
import moratorium.se.itmo.blps.controller.review.dto.GetAssignedReviewsResponseDto;
import moratorium.se.itmo.blps.controller.review.dto.PostReviewRequestDto;
import moratorium.se.itmo.blps.controller.review.dto.PostReviewResponseDto;
import moratorium.se.itmo.blps.domain.review.ReviewEntity;
import moratorium.se.itmo.blps.domain.review.ReviewStatus;
import moratorium.se.itmo.blps.service.movie.MovieService;
import moratorium.se.itmo.blps.service.user.UserService;
import org.springframework.stereotype.Service;

import static moratorium.se.itmo.blps.domain.review.ReviewStatus.POSTED;
import static moratorium.se.itmo.blps.domain.review.ReviewStatus.VALIDATING;

@Service
@RequiredArgsConstructor
public class ReviewFacade {
    private final UserService userService;
    private final MovieService movieService;
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    // @Transactional
    public PostReviewResponseDto postReview(PostReviewRequestDto requestDto) {
        final Long postedReviewId = reviewService.saveReview(
                ReviewEntity.builder()
                        .content(requestDto.getContent())
                        .status(ReviewStatus.VALIDATING)
                        .user(userService.getUser(requestDto.getUserId()))
                        .movie(movieService.getMovie(requestDto.getMovieId()))
                        .reviewer(userService.assignModerator())
                        .build()
        );
        return PostReviewResponseDto.builder()
                .reviewId(postedReviewId)
                .build();
    }

    // @Transactional
    public void changeStatus(Long reviewId, String status) {
        final ReviewStatus newStatus = ReviewStatus.valueOf(status);

        final ReviewEntity review = reviewService.getReview(reviewId);
        review.setStatus(newStatus);
        if (newStatus.equals(POSTED)) {
            review.setPublicationDate(new Timestamp(System.currentTimeMillis()));
        }
        reviewService.saveReview(review);
    }

    public GetAssignedReviewsResponseDto getAssignedReviews(Long moderatorId) {
        final var reviews = reviewService.getReviewsByModerator(userService.getUser(moderatorId))
                .stream()
                .filter(review -> review.getStatus().equals(VALIDATING))
                .map(reviewMapper::mapToAssignedReview)
                .toList();

        return GetAssignedReviewsResponseDto.builder()
                .reviews(reviews)
                .build();
    }

    public GetMovieReviewsResponseDto getMovieReviews(Long movieId) {
        var reviews = movieService.getMovie(movieId)
                .getReviews()
                .stream()
                .filter((review) -> review.getStatus().equals(POSTED))
                .map(reviewMapper::mapToMovieReview)
                .toList();

        return GetMovieReviewsResponseDto.builder()
                .reviews(reviews)
                .build();
    }
}

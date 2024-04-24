package moratorium.se.itmo.blps.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import moratorium.se.itmo.blps.controller.review.dto.GetAssignedReviewsResponseDto;
import moratorium.se.itmo.blps.controller.review.dto.PostReviewRequestDto;
import moratorium.se.itmo.blps.controller.review.dto.PostReviewResponseDto;
import moratorium.se.itmo.blps.service.review.ReviewFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Tag(name = "review", description = "Рецензии на фильмы")
public class ReviewController {
    private final ReviewFacade reviewFacade;

    @Operation(summary = "Опубликовать ревью на оценку")
    @PostMapping("/post")
    public PostReviewResponseDto postReview(PostReviewRequestDto requestDto) {
        return reviewFacade.postReview(requestDto);
    }

    @Operation(summary = "Просмотреть ревью назначенные модератору")
    @GetMapping("/get-assigned-reviews")
    public GetAssignedReviewsResponseDto reviewsResponseDto(@NonNull Long moderatorId) {
        return reviewFacade.getAssignedReviews(moderatorId);
    }

    @Operation(summary = "Изменить статус ревью")
    @PostMapping("/change-status")
    public void changeReviewStatus(@RequestParam Long reviewId, @RequestParam String newStatus) {
        reviewFacade.changeStatus(reviewId, newStatus);
    }
}

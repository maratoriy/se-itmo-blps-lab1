package moratorium.se.itmo.blps.service.review;

import moratorium.se.itmo.blps.controller.movie.dto.GetMovieReviewResponseDto;
import moratorium.se.itmo.blps.controller.review.dto.GetAssignedReviewResponseDto;
import moratorium.se.itmo.blps.domain.review.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "userId", source = "review.user.id")
    @Mapping(target = "publicationDate", source = "review.publicationDate", dateFormat = "dd.MM.YY mm:hh")
    GetMovieReviewResponseDto mapToMovieReview(ReviewEntity review);

    @Mapping(target = "userId", source = "review.user.id")
    @Mapping(target = "reviewId", source = "review.id")
    @Mapping(target = "movieId", source = "review.movie.id")
    @Mapping(target = "creationDate", source = "review.creationDate", dateFormat = "dd.MM.YY mm:hh")
    GetAssignedReviewResponseDto mapToAssignedReview(ReviewEntity review);
}

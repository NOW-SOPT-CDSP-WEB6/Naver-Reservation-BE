package sopt.seminar.sopt.store.dto.response;


import java.util.List;

public record ReviewSummaryResponse(
    int totalReviewCount,
    List<ReviewResponse> userReviewList
) {

  public static ReviewSummaryResponse of(int totalReviewCount,
      List<ReviewResponse> reviewResponses) {
    return new ReviewSummaryResponse(totalReviewCount, reviewResponses);
  }
}

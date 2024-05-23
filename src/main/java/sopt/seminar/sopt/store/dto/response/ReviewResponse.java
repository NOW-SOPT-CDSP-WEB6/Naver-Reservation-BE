package sopt.seminar.sopt.store.dto.response;

import java.time.LocalDateTime;

public record ReviewResponse(
    Long reviewId,
    String name,
    LocalDateTime reviewDate,
    String content
) {

  public static ReviewResponse of(Long reviewId, String name, LocalDateTime reviewDate, String content) {
    return new ReviewResponse(reviewId, name, reviewDate, content);
  }
}

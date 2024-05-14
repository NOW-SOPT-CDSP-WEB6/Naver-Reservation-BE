package sopt.seminar.sopt.store.dto.response;

import java.time.LocalDateTime;

public record ReviewResponse(
    String name,
    LocalDateTime reviewDate,
    String content
) {

  public static ReviewResponse of(String name, LocalDateTime reviewDate, String content) {
    return new ReviewResponse(name, reviewDate, content);
  }
}

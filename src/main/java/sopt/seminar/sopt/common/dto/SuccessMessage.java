package sopt.seminar.sopt.common.dto;

import java.util.Optional;

public record SuccessMessage<T>(

    int status,
    String message,
    Optional<T> data
) {

  public static <T> SuccessMessage<T> of(SuccessMessage successMessage) {
    return new SuccessMessage(successMessage.status, successMessage.message, Optional.empty());
  }

  public static <T> SuccessMessage<T> of(SuccessMessage successMessage, T data) {
    return new SuccessMessage(successMessage.status, successMessage.message, Optional.of(data));
  }
}

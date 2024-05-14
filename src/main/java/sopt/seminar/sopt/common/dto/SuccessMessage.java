package sopt.seminar.sopt.common.dto;

import java.util.Optional;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;

public record SuccessMessage<T>(

    int status,
    String message,
    Optional<T> data
) {

  public static <T> SuccessMessage<T> of(SuccessStatus successStatus) {
    return new SuccessMessage(successStatus.getStatus(), successStatus.getMessage(),
        Optional.empty());
  }

  public static <T> SuccessMessage<T> of(SuccessStatus successStatus, T data) {
    return new SuccessMessage(successStatus.getStatus(), successStatus.getMessage(),
        Optional.of(data));
  }
}

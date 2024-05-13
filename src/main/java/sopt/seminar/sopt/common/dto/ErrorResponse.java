package sopt.seminar.sopt.common.dto;

import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;

public record ErrorResponse(
    int status,
    String message

) {

  public static ErrorResponse of(int status, String message) {
    return new ErrorResponse(status, message);
  }

  public static ErrorResponse of(ErrorMessage errorMessage) {
    return new ErrorResponse(errorMessage.getStatus(), errorMessage.getMessage());
  }
}

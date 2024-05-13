package sopt.seminar.sopt.common.dto;

import sopt.seminar.sopt.common.dto.response.statusEnum.ErrorStatus;

public record ErrorResponse(
      int status,
      String message

  ) {
    public static ErrorResponse of(int status, String message) {
      return new ErrorResponse(status, message);
    }

    public static ErrorResponse of(ErrorStatus errorStatus) {
      return new ErrorResponse(errorStatus.getStatus(), errorStatus.getMessage());
    }
}

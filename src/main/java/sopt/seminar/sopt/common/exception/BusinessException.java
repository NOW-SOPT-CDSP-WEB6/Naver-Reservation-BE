package sopt.seminar.sopt.common.exception;

import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;

public class BusinessException extends RuntimeException {

  private final ErrorMessage errorMessage;

  public BusinessException(ErrorMessage errorMessage) {
    super(errorMessage.getMessage());
    this.errorMessage = errorMessage;
  }
}

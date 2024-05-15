package sopt.seminar.sopt.common.exception;

import lombok.Getter;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;

@Getter
public class NotFoundException extends BusinessException {

  private ErrorMessage errorMessage;

  public NotFoundException(
      ErrorMessage errorMessage) {
    super(errorMessage);
    this.errorMessage = errorMessage;
  }
}

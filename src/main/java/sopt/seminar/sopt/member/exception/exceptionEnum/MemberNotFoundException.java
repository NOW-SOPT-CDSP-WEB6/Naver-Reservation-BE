package sopt.seminar.sopt.member.exception.exceptionEnum;

import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;

public class MemberNotFoundException extends NotFoundException {

  public MemberNotFoundException(
      ErrorMessage errorMessage) {
    super(errorMessage);
  }
}

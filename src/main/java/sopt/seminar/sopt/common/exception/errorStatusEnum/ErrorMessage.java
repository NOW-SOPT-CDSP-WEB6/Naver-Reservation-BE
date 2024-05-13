package sopt.seminar.sopt.common.exception.errorStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
  ;
  private final int status;
  private final String message;
}

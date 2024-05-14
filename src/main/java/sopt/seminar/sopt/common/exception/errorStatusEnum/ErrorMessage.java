package sopt.seminar.sopt.common.exception.errorStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "멤버가 존재하지 않습니다."),
  STORE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "가게가 존재하지 않습니다."),
  ;
  private final int status;
  private final String message;
}

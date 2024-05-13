package sopt.seminar.sopt.common.dto.response.statusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessStatus {

  SUCCESS_OK(HttpStatus.OK.value(), "정상 조회 성공"),
  SUCCESS_CREATED(HttpStatus.CREATED.value(), "정상적으로 생성되었습니다."),
  ;

  private final int status;
  private final String message;

}

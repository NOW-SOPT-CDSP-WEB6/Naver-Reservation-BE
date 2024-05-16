package sopt.seminar.sopt.common.dto.response.statusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessStatus {

  SUCCESS_OK(HttpStatus.OK.value(), "정상 조회 성공하였습니다."),
  SUCCESS_CREATED(HttpStatus.CREATED.value(), "정상적으로 생성되었습니다."),
  SUCCESS_STAR(HttpStatus.OK.value(), "정상적으로 별표 상태가 변경되었습니다."),
  SUCCESS_REVIEW(HttpStatus.OK.value(), "정상적으로 리뷰가 생성되었슨니다."),

  ;

  private final int status;
  private final String message;
}

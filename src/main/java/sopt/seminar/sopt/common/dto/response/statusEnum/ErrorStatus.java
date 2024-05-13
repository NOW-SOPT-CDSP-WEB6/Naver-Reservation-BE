package sopt.seminar.sopt.common.dto.response.statusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorStatus {
  ;
  private final int status;
  private final String message;
}

package sopt.seminar.sopt.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

  뷰티("뷰티"),
  생활_클래스("생활/클래스"),
  식당_카페("식당/카페"),
  숙박("숙박"),
  스포츠_레저("스포츠_레저"),
  공연_전시("공연_전시"),
  병의원("병의원"),
  ;

  private final String category;
}

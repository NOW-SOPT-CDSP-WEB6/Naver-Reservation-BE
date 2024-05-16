package sopt.seminar.sopt.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

  뷰티("beauty"),
  생활_클래스("life_class"),
  식당_카페("restaurant_cafe"),
  숙박("accommodation"),
  스포츠_레저("sports_leisure"),
  공연_전시("performance_exhibition"),
  병의원("hospital"),
  ;
  private final String category;
}

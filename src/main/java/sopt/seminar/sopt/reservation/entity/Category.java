package sopt.seminar.sopt.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

  beauty("뷰티","beauty"),
  life_class("생활/클래스","life_class"),
  restaurant_cafe("식당/카페","restaurant_cafe"),
  accommodation("숙박","accommodation"),
  sports_leisure("스포츠/레저","sports_leisure"),
  performance_exhibition("공연/전시","performance_exhibition"),
  hospital("병의원","hospital"),
  ;
  private final String korean;
  private final String english;
}

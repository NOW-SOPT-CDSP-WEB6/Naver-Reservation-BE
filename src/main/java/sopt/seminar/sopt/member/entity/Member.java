package sopt.seminar.sopt.member.entity;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sopt.seminar.sopt.common.baseEntity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  private String name;

  public Member(long memberId) {
    this.id = memberId;
  }

  @Builder
  public Member(String name) {
    this.name = name;
  }
}

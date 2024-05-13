package sopt.seminar.sopt.store.entity;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.seminar.sopt.common.baseEntity.BaseEntity;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.reservation.entity.Reservation;

@Entity
@NoArgsConstructor
@Getter
public class Store extends BaseEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "store_name")
  private String storeName;

  public Store(String storeName) {
    this.storeName = storeName;
  }
}

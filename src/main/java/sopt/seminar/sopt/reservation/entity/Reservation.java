package sopt.seminar.sopt.reservation.entity;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sopt.seminar.sopt.common.baseEntity.BaseEntity;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.store.entity.Store;

@Entity
@NoArgsConstructor
@Getter
public class Reservation extends BaseEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  private String content;

  @Column(name = "main_description")
  private String mainDescription;

  @Column(name = " sub_description")
  private String subDescription;

  private Integer price;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(name = "review_status")
  private boolean reviewStatus;

  @Column(name = "star_status")
  private boolean starStatus;

  public Reservation(Member member, Store store, String content, String mainDescription,
      String subDescription, Integer price, Category category) {
    this.member = member;
    this.store = store;
    this.content = content;
    this.mainDescription = mainDescription;
    this.subDescription = subDescription;
    this.price = price;
    this.category = category;
    this.reviewStatus = false;
    this.starStatus = false;
  }

  public void updateContent(String newContent) {
    this.content = newContent;
  }


  public void updateReviewStatus() {
    this.reviewStatus = true;
  }

  public void toggleStarStatus() {
    this.starStatus = !this.starStatus;
  }

}

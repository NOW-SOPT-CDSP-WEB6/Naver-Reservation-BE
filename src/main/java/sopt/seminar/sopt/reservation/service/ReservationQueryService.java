package sopt.seminar.sopt.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.member.service.MemberQueryService;
import sopt.seminar.sopt.reservation.dto.response.ReservationCategorizedResponse;
import sopt.seminar.sopt.reservation.entity.Category;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;
import sopt.seminar.sopt.store.entity.Store;

@Service
@RequiredArgsConstructor
public class ReservationQueryService {

  private final ReservationJpaRepository reservationJpaRepository;
  private final MemberQueryService memberQueryService;

  public List<ReservationCategorizedResponse> queryCategorizedReservationList(
      long memberId) {

    Member member = memberQueryService.findById(memberId);
    return findAllReservationByMember(member).stream().map(reservation ->
        ReservationCategorizedResponse.of(reservation.getId(), reservation.getCategory(), member.getName(),
            reservation.getStore().getStoreName(), reservation.getCreatedAt(),
            reservation.getMainDescription(), reservation.getSubDescription(),
            reservation.getPrice(),
            reservation.isReviewStatus(), reservation.isStarStatus()))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<Reservation> findAllReservationByMember(Member member) {
    return reservationJpaRepository.findByMember(member);
  }

  public List<Reservation> findReservationByStore(Store store) {
    return reservationJpaRepository.findByStore(store);
  }
}

package sopt.seminar.sopt.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  public Map<String, List<ReservationCategorizedResponse>> queryCategorizedReservationList(
      long memberId) {

    Member member = memberQueryService.findById(memberId);
    List<Reservation> reservationList = findAllReservationByMember(member);

    Map<String, List<ReservationCategorizedResponse>> categorizedResponseMap = new HashMap<>();

    for (Category category : Category.values()) {
      categorizedResponseMap.computeIfAbsent(category.getCategory(), i -> new ArrayList<>());
    }
    for (Reservation reservation : reservationList) {
      categorizedResponseMap.computeIfPresent(reservation.getCategory(), (key, list) ->
      {
        list.add(ReservationCategorizedResponse.of(reservation.getId(), member.getName(),
            reservation.getStore().getStoreName(), reservation.getCreatedAt(),
            reservation.getMainDescription(), reservation.getSubDescription(),
            reservation.getPrice(),
            reservation.isReviewStatus(), reservation.isStarStatus()));
        return list;
      });
    }
    return categorizedResponseMap;
  }

  private List<Reservation> findAllReservationByMember(Member member) {
    return reservationJpaRepository.findByMember(member);
  }

  public List<Reservation> findReservationByStore(Store store) {
    return reservationJpaRepository.findByStore(store);
  }
}

package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.reservation.entity.Category;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReservationCountPriceService {

  private final ReservationJpaRepository reservationJpaRepository;

  public Map<String, Integer> getCountPriceByCategory(Long memberId, String category) {
    List<Reservation> reservations;

    if (category == null) {
      reservations = findEveryMemberReservation(memberId);
    } else {

      Category inputCategory;

      try {
        inputCategory = Category.valueOf(category);
      } catch (Exception e) {
        throw new NotFoundException(ErrorMessage.CATEGORY_NOT_FOUND);
      }

      reservations = findReservationGroupByCategory(memberId, inputCategory);
    }

    int count = reservations.size();
    int total = reservations.stream()
        .mapToInt(reservation -> reservation.getPrice() != null ? reservation.getPrice() : 0)
        .sum();

    Map<String, Integer> result = new HashMap<>();
    result.put("count", count);
    result.put("totalPrice", total);

    return result;
  }

  private List<Reservation> findReservationGroupByCategory(Long memberId, Category inputCategory) {
    return reservationJpaRepository.findByMemberIdAndCategory(memberId, inputCategory);
  }

  private List<Reservation> findEveryMemberReservation(Long memberId) {
    return reservationJpaRepository.findByMemberId(memberId);
  }

}

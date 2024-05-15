package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReservationCountPriceService {

    private final ReservationJpaRepository reservationJpaRepository;


    public Map<String, Object> getCountPriceByCategory(Long memberId, String category) {
        List<Reservation> reservations;

        if (category != null && !category.isEmpty()) {
            // category 파라미터가 제공되었을 경우 해당 카테고리의 예약만 가져옴
            reservations = reservationJpaRepository.findByMemberIdAndCategory(memberId, category);
        } else {
            // category 파라미터가 없을 경우 memberId에 해당하는 모든 예약을 가져옴
            Member member = new Member();
            member.setId(memberId);
            reservations = reservationJpaRepository.findByMember(member);
        }

        int count = reservations.size();
        int total = reservations.stream()
                .mapToInt(reservation -> reservation.getPrice() != null ? reservation.getPrice() : 0)
                .sum();

        Map<String, Object> result = new HashMap<>();
        result.put("count", count);
        result.put("totalPrice", total);

        return result;
    }



}

package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
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
        List<Reservation> reservations = reservationJpaRepository.findByMemberIdAndCategory(memberId, category);

        int count = reservations.size();
        int total = reservations.stream().mapToInt(Reservation::getPrice).sum();

        Map<String, Object> result = new HashMap<>();
        result.put("count", count);
        result.put("totalPrice", total);

        return result;
    }





}

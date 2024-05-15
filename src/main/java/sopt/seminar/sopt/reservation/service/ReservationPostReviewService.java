package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationPostReviewService {
    private final ReservationJpaRepository reservationJpaRepository;

    public boolean postReview(Long reservationId, PostReviewDTO postReviewRequest) {
    Optional<Reservation> optionalReservation = reservationJpaRepository.findById(reservationId);

    // 예약이 존재하지 않으면 처리 중단
        if (optionalReservation.isEmpty()) {
        return false;
    }

    Reservation reservation = optionalReservation.get();
    // 요청에서 받은 데이터를 Reservation 엔티티의 content 속성에 저장
        reservation.setContent(postReviewRequest.getContent());
        reservation.setStarStatus(!reservation.isReviewStatus());

    // 변경된 예약 정보를 저장
        reservationJpaRepository.save(reservation);

        return true;
}

}

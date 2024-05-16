package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationPostReviewService {
    private final ReservationJpaRepository reservationJpaRepository;

    public boolean postReview(Long reservationId, PostReviewDTO postReviewRequest) {

        Reservation reservation = findByReservationId(reservationId);

        reservation.setContent(postReviewRequest.getContent());
        reservation.setStarStatus(!reservation.isReviewStatus());

        reservationJpaRepository.save(reservation);

        return true;
}


    private Reservation findByReservationId(long reservationId) {
        return reservationJpaRepository.findById(reservationId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.RESERVATION_NOT_FOUND)
        );
    }

}
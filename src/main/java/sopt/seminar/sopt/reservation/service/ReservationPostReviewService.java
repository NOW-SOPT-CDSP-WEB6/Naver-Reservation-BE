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

        // 내용(content) 변경
        reservation.updateContent(postReviewRequest.getContent());

        // 리뷰 상태(reviewStatus) 변경 및 별점 상태(starStatus) 업데이트
        reservation.updateReviewStatus();

        // 변경된 Reservation 저장
        reservationJpaRepository.save(reservation);

        return true;
    }


    private Reservation findByReservationId(long reservationId) {
        return reservationJpaRepository.findById(reservationId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.RESERVATION_NOT_FOUND)
        );
    }

}

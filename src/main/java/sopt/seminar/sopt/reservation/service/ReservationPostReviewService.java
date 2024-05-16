package sopt.seminar.sopt.reservation.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.reservation.dto.request.PostReviewRequest;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;

@Service
@RequiredArgsConstructor
public class ReservationPostReviewService {
    private final ReservationJpaRepository reservationJpaRepository;

    @Transactional
    public boolean postReview(Long reservationId, PostReviewRequest postReviewRequest) {

        Reservation reservation = findByReservationId(reservationId);
        reservation.updateContent(postReviewRequest.content());
        reservation.updateReviewStatus();
        reservationJpaRepository.save(reservation);

        return reservation.isReviewStatus();
    }

    private Reservation findByReservationId(long reservationId) {
        return reservationJpaRepository.findById(reservationId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.RESERVATION_NOT_FOUND)
        );
    }
}

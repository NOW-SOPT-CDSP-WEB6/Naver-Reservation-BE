package sopt.seminar.sopt.reservation.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;
import sopt.seminar.sopt.store.entity.Store;


@Service
@RequiredArgsConstructor
public class ReservationStarService {
    private final ReservationJpaRepository reservationJpaRepository;

    public boolean changeStarStatus(Long reservationId) {
        Reservation reservation = findByReservationId(reservationId);

        reservation.updateReviewStatus(); // 토글 방식으로 변경
        reservationJpaRepository.save(reservation);

        return reservation.isStarStatus();
    }

    private Reservation findByReservationId(long reservationId) {
        return reservationJpaRepository.findById(reservationId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.RESERVATION_NOT_FOUND)
        );
    }

}

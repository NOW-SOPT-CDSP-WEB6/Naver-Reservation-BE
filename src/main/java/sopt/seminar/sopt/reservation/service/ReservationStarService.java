package sopt.seminar.sopt.reservation.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.repository.ReservationJpaRepository;


@Service
@RequiredArgsConstructor
public class ReservationStarService {
    private final ReservationJpaRepository reservationJpaRepository;

    public boolean changeStarStatus(Long reservationId) {
        Reservation reservation = reservationJpaRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + reservationId));

        reservation.setStarStatus(!reservation.isStarStatus()); // 토글 방식으로 변경
        reservationJpaRepository.save(reservation);

        return reservation.isStarStatus();
    }



}

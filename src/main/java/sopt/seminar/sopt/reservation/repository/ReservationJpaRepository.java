package sopt.seminar.sopt.reservation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.reservation.entity.Reservation;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {

  List<Reservation> findByMember(Member member);
}

package sopt.seminar.sopt.reservation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.reservation.entity.Category;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.store.entity.Store;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {

  List<Reservation> findByMemberIdAndCategory(Long memberId, Category category);

  List<Reservation> findByMember(Member member);

  List<Reservation> findByStore(Store store);

  List<Reservation> findByMemberId(Long memberId);
}

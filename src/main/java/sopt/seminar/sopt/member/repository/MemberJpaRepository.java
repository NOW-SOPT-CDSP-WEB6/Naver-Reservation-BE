package sopt.seminar.sopt.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar.sopt.member.entity.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}

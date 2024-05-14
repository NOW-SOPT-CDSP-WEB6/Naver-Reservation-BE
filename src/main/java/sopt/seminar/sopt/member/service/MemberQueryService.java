package sopt.seminar.sopt.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.member.exception.exceptionEnum.MemberNotFoundException;
import sopt.seminar.sopt.member.repository.MemberJpaRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

  private final MemberJpaRepository memberJpaRepository;

  public Member findById(long memberId){
    return memberJpaRepository.findById(memberId).orElseThrow(
        ()-> new MemberNotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
    );
  }

}

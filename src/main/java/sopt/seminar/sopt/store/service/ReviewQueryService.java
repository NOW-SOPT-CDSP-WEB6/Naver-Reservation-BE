package sopt.seminar.sopt.store.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.seminar.sopt.common.exception.NotFoundException;
import sopt.seminar.sopt.common.exception.errorStatusEnum.ErrorMessage;
import sopt.seminar.sopt.member.entity.Member;
import sopt.seminar.sopt.member.service.MemberQueryService;
import sopt.seminar.sopt.reservation.entity.Reservation;
import sopt.seminar.sopt.reservation.service.ReservationQueryService;
import sopt.seminar.sopt.store.dto.response.ReviewResponse;
import sopt.seminar.sopt.store.dto.response.ReviewSummaryResponse;
import sopt.seminar.sopt.store.entity.Store;
import sopt.seminar.sopt.store.repository.StoreJpaRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

  private final MemberQueryService memberQueryService;
  private final ReservationQueryService reservationQueryService;
  private final StoreJpaRepository storeJpaRepository;

  public ReviewSummaryResponse queryStoreReview(long storeId) {

    Store store = findById(storeId);

    List<Reservation> reservationList = reservationQueryService.findReservationByStore(store);
    List<ReviewResponse> reviewResponses = reservationList.stream().map(reservation ->
            ReviewResponse.of(reservation.getMember().getName(), reservation.getCreatedAt(),
                reservation.getContent()))
        .collect(Collectors.toUnmodifiableList());

    return ReviewSummaryResponse.of(reviewResponses.size(), reviewResponses);
  }

  private Store findById(long storeId) {
    return storeJpaRepository.findById(storeId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.STORE_NOT_FOUND)
    );
  }
}

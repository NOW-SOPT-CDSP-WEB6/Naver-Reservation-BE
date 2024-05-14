package sopt.seminar.sopt.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.seminar.sopt.common.dto.SuccessMessage;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;
import sopt.seminar.sopt.reservation.service.ReservationQueryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationReadController {

  private final ReservationQueryService reservationQueryService;

  @GetMapping("/reservations/all")
  public ResponseEntity<?> getCategorizedReservations(@RequestHeader Long memberId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(SuccessMessage.of(SuccessStatus.SUCCESS_OK,
            reservationQueryService.queryCategorizedReservationList(memberId)));
  }
}

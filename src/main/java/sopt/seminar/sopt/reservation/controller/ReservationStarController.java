package sopt.seminar.sopt.reservation.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.seminar.sopt.common.dto.SuccessMessage;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;
import sopt.seminar.sopt.reservation.service.ReservationStarService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationStarController {
    private  final ReservationStarService reservationStarService;

    @PostMapping("/reservations/star/{reservationId}")
    public ResponseEntity<?> changeStarStatus(@PathVariable Long reservationId){
    return ResponseEntity.status(HttpStatus.OK)
            .body(SuccessMessage.of(SuccessStatus.SUCCESS_STAR,
                    reservationStarService.changeStarStatus(reservationId)));
    }
}

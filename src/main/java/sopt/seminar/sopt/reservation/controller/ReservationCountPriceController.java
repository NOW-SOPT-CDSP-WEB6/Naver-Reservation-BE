package sopt.seminar.sopt.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.seminar.sopt.common.dto.SuccessMessage;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;
import sopt.seminar.sopt.reservation.entity.Category;
import sopt.seminar.sopt.reservation.service.ReservationCountPriceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationCountPriceController {
    private  final ReservationCountPriceService reservationCountPriceService;

    @GetMapping("/reservations")
    public ResponseEntity<?> getCountPriceByCategory(@RequestHeader Long memberId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessMessage.of(SuccessStatus.SUCCESS_OK,
                        reservationCountPriceService.getCountPriceByCategory(memberId, null)));
    }

    @GetMapping("/reservations/{category}")
    public ResponseEntity<?> getCountPriceByCategory( @RequestHeader Long memberId,@PathVariable
        String category){
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessMessage.of(SuccessStatus.SUCCESS_OK,
                        reservationCountPriceService.getCountPriceByCategory(memberId,category)));
    }
}

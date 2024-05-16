package sopt.seminar.sopt.reservation.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.seminar.sopt.common.dto.SuccessMessage;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;
import sopt.seminar.sopt.reservation.service.PostReviewDTO;
import sopt.seminar.sopt.reservation.service.ReservationPostReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationPostReviewController {
    private  final ReservationPostReviewService reservationPostReviewService;

    @PostMapping("/review/{reservationId}")
    public ResponseEntity<?> postReview(@PathVariable Long reservationId, @RequestBody PostReviewDTO postReviewRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessMessage.of(SuccessStatus.SUCCESS_REVIEW,
                        reservationPostReviewService.postReview(reservationId,postReviewRequest)));
    }
}

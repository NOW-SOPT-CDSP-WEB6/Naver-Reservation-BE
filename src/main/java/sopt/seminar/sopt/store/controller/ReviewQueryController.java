package sopt.seminar.sopt.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.seminar.sopt.common.dto.SuccessMessage;
import sopt.seminar.sopt.common.dto.response.statusEnum.SuccessStatus;
import sopt.seminar.sopt.store.service.ReviewQueryService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewQueryController {

  private final ReviewQueryService reviewQueryService;

  @GetMapping("/reviews/{storeId}")
  public ResponseEntity<?> getStoreEveryReview(@PathVariable Long storeId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(SuccessMessage.of(SuccessStatus.SUCCESS_OK,
            reviewQueryService.queryStoreReview(storeId)));
  }
}

package sopt.seminar.sopt.reservation.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationCategorizedResponse(
    Long reservationId,
    String userName,
    String storeName,
    LocalDateTime reservationDate,
    String mainDescription,
    String subDescription,
    int price,
    boolean review,
    boolean starMark
) {

  public static ReservationCategorizedResponse of(
      Long reservationId,
      String userName,
      String storeName,
      LocalDateTime reservationDate,
      String mainDescription,
      String subDescription,
      int price,
      boolean review,
      boolean starMark) {

    return new ReservationCategorizedResponse(reservationId, userName, storeName, reservationDate,
        mainDescription, subDescription, price, review, starMark);
  }
}

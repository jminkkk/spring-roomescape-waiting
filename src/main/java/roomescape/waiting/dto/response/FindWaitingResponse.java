package roomescape.waiting.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.waiting.model.WaitingWithRanking;

public record FindWaitingResponse(Long id,
                                  LocalDate date,
                                  LocalTime time,
                                  String theme,
                                  String status) {
    public static FindWaitingResponse of(final WaitingWithRanking waitingWithStatus) {
        Long waitNumber = waitingWithStatus.ranking() + 1;
        return new FindWaitingResponse(
                waitingWithStatus.waiting().getId(),
                waitingWithStatus.waiting().getReservation().getDate(),
                waitingWithStatus.waiting().getReservation().getReservationTime().getStartAt(),
                waitingWithStatus.waiting().getReservation().getTheme().getName(),
                waitNumber + "번째 예약대기");
    }
}
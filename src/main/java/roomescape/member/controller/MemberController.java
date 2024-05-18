package roomescape.member.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomescape.auth.core.AuthenticationPrincipal;
import roomescape.auth.domain.AuthInfo;
import roomescape.member.dto.response.FindReservationResponse;
import roomescape.member.service.MemberService;
import roomescape.reservation.dto.response.FindMembersResponse;
import roomescape.reservation.service.ReservationService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final ReservationService reservationService;

    public MemberController(final MemberService memberService, final ReservationService reservationService) {
        this.memberService = memberService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<FindMembersResponse>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<FindReservationResponse>> getMembersWithReservations(@AuthenticationPrincipal AuthInfo authInfo) {
        return ResponseEntity.ok(reservationService.getReservationsByMember(authInfo));
    }
}

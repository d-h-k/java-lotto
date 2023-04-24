package lotto.present;

import lotto.domain.Ticket;
import lotto.present.vo.IncomePresentVO;
import lotto.present.vo.WinnerPresentVO;

import java.util.List;

public class OutputPresent {
    private static final String STATISTICS_HEAD = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String PRIZE_5TH = "3개 일치 (5000원)- %s개";
    private static final String PRIZE_4TH = "4개 일치 (50000원)- %s개";
    private static final String PRIZE_3RD = "5개 일치 (1500000원)- %s개";
    private static final String PRIZE_1ST = "6개 일치 (2000000000원)- %s개";
    private static final String RETURN_RATE = "총 수익률은 %f2입니다";
    public OutputPresent() {
    }



    public void presentWinners(WinnerPresentVO winnerPresentVO) {
        System.out.println(STATISTICS_HEAD);
        System.out.printf(PRIZE_5TH + System.lineSeparator(), winnerPresentVO.getCountFifth());
        System.out.printf(PRIZE_4TH + System.lineSeparator(), winnerPresentVO.getCountFourth());
        System.out.printf(PRIZE_3RD + System.lineSeparator(), winnerPresentVO.getCountThird());
        System.out.printf(PRIZE_1ST + System.lineSeparator(), winnerPresentVO.getCountFirst());
    }

    public void presentIncome(IncomePresentVO incomePresentVO) {
        System.out.printf(RETURN_RATE, incomePresentVO.getProfitRatio());
        System.out.print(incomePresentVO.getBreakEvenMessage());
    }

    public void presentTickets(List<Ticket> tickets) {
        for(Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}

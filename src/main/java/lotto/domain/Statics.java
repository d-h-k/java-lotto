package lotto.domain;

import java.util.List;

public class Statics {
    private static final String PROFIT_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOSS_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countFirst;
    private final int income;
    private final double profitRatio;


    public Statics(List<Ticket> tickets, Ticket winningTicket) {
        this.countFirst = aggregateFirst(tickets, winningTicket);
        this.countThird = aggregateThird(tickets, winningTicket);
        this.countFourth = aggregateFourth(tickets, winningTicket);
        this.countFifth = aggregateFifth(tickets, winningTicket);
        this.income = aggregateIncome();
        this.profitRatio = aggregateProfitRatio(tickets.size(), this.income);
    }

    private double aggregateProfitRatio(int ticketCount, int income) {
        return (double) income / (double) (ticketCount * 1000);
    }

    private int aggregateIncome() {
        return Prize.FIRST.calculatePrize(this.countFirst) +
                Prize.THIRD.calculatePrize(this.countThird) +
                Prize.FOURTH.calculatePrize(this.countFourth) +
                Prize.FIFTH.calculatePrize(this.countFifth);
    }

    public int getIncome() {
        return income;
    }

    private int aggregateThird(List<Ticket> tickets, Ticket winningTicket) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (Prize.THIRD.isMatch(ticket.overlapNumberCount(winningTicket))) {
                count++;
            }
        }
        return count;
    }

    private int aggregateFourth(List<Ticket> tickets, Ticket winningTicket) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (Prize.FOURTH.isMatch(ticket.overlapNumberCount(winningTicket))) {
                count++;
            }
        }
        return count;
    }

    private int aggregateFifth(List<Ticket> tickets, Ticket winningTicket) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (Prize.FIFTH.isMatch(ticket.overlapNumberCount(winningTicket))) {
                count++;
            }
        }
        return count;
    }

    private int aggregateFirst(List<Ticket> tickets, Ticket winningTicket) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (Prize.FIRST.isMatch(ticket.overlapNumberCount(winningTicket))) {
                count++;
            }
        }
        return count;
    }

    public int getCountFifth() {
        return countFifth;
    }

    public int getCountFourth() {
        return countFourth;
    }

    public int getCountThird() {
        return countThird;
    }

    public int getCountFirst() {
        return countFirst;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public String breakEvenMessage() {
        return this.profitRatio >= 1 ? PROFIT_MESSAGE : LOSS_MESSAGE;
    }

    public int getCountSecond() {
        throw new RuntimeException();
    }
}

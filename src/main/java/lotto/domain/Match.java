package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Match {
    private final Random RANDOM = new Random();
    private final List<Ticket> tickets;

    public Match() {
        this.tickets = new ArrayList<>();
    }

    public void purchase(int count) {
        for (int i = 0; i < count; i++) {
            addTicket(new Ticket(issuance()));
        }
    }

    private Set<Integer> issuance() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size()<6) {
            numbers.add(issueNumber());
        }
        return numbers;
    }

    private int issueNumber() {
        return RANDOM.nextInt(46) + 1;
    }

    private void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<String> renderingTickets() {
        List<String> presentTickets = new ArrayList<>();
        for(Ticket ticket : tickets) {
            presentTickets.add(ticket.rendering());
        }
        return presentTickets;
    }

    public Winners makeWinners(Ticket winningTicket) {
        return new Winners(tickets,winningTicket);
    }
}

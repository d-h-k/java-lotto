package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private final List<Ticket> tickets;

    public static Tickets emptyTickets() {
        return new Tickets(new ArrayList<>());
    }

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int count() {
        return tickets.size();
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void add(Tickets tickets) {
        this.tickets.addAll(tickets.getTickets());
    }
}

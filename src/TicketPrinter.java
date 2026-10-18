public class TicketPrinter {
    private int nextTicketNumber = 1001;

    public String print(String movie, String seat) {
        return "Ticket #" + nextTicketNumber++ + " | " + movie + " | Seat " + seat;
    }
}

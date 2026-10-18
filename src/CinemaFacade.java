public class CinemaFacade {
    private final MovieCatalog catalog = new MovieCatalog();
    private final SeatSelector seatSelector = new SeatSelector();
    private final PaymentService paymentService = new PaymentService();
    private final TicketPrinter ticketPrinter = new TicketPrinter();
    private final EmailSender emailSender = new EmailSender();

    public String bookTicket(String email, String movie, String seat) {
        if (!catalog.exists(movie)) {
            throw new BookingFailedException("Movie not found: " + movie);
        }
        if (!seatSelector.isValidSeat(seat)) {
            throw new BookingFailedException("Invalid seat: " + seat);
        }
        if (!seatSelector.reserve(seat)) {
            throw new BookingFailedException("Seat " + seat + " is already taken");
        }

        int price = catalog.getPrice(movie);
        if (!paymentService.charge(email, price)) {
            seatSelector.release(seat);
            throw new BookingFailedException("Payment failed: insufficient funds");
        }

        String ticket = ticketPrinter.print(movie, seat);
        emailSender.send(email, ticket);
        return ticket;
    }

    public void topUpWallet(String email, int amount){
        paymentService.topUp(email, amount);
    }
}

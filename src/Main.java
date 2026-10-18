public class Main {
    public static void main(String[] args) {
        CinemaFacade cinema = new CinemaFacade();

        cinema.topUpWallet("alice@mail.com", 5000);
        tryBooking(cinema, "alice@mail.com", "1+1", "A1");

        tryBooking(cinema, "bob@mail.com", "Inglorius Bastards", "A1"); //seat taken
        tryBooking(cinema, "bob@mail.com", "Inglorius Bastards", "B2"); //no money

        cinema.topUpWallet("bob@mail.com", 3000);
        tryBooking(cinema, "bob@mail.com", "Inglorius Bastards", "B2"); //success
    }

    public static void tryBooking(CinemaFacade cinema, String email, String movie, String seat){
        try {
            String ticket = cinema.bookTicket(email, movie, seat);
            System.out.println("Booked: " + ticket);
        } catch (BookingFailedException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

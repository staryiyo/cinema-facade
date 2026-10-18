import java.util.HashSet;
import java.util.Set;

public class SeatSelector {
    private static final String SEAT_PATTERN = "[A-C][1-5]";

    private final Set<String> reservedSeats = new HashSet<>();

    public boolean isValidSeat(String seat){
        return seat.matches(SEAT_PATTERN);
    }

    public boolean reserve(String seat){
        return reservedSeats.add(seat);
    }

    public void release(String seat){
        reservedSeats.remove(seat);
    }
}
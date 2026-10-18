import java.util.HashMap;
import java.util.Map;

public class MovieCatalog {
    private final Map<String, Integer> prices = new HashMap<>();

    public MovieCatalog() {
        prices.put("Inglorius Bastards", 2500);
        prices.put("1+1", 2750);
        prices.put("Pulp Fiction", 2800);
    }

    public boolean exists(String movie) {
        return prices.containsKey(movie);
    }

    public int getPrice(String movie) {
        return prices.get(movie);
    }
}

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, Integer> wallets = new HashMap<>();

    public void topUp(String email, int amount) {
        wallets.put(email, wallets.getOrDefault(email, 0) + amount);
    }

    public boolean charge(String email, int amount) {
        int balance = wallets.getOrDefault(email, 0);
        if (balance < amount){
            return false;
        }
        wallets.put(email, balance - amount);
        return true;
    }
}
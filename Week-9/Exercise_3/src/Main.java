package Exercise_3.src;

import Exercise_3.LegacyOrderFacade;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Legacy Order Facade ===");
        LegacyOrderFacade legacyFacade = new LegacyOrderFacade();
        legacyFacade.placeOrder("david@email.com", "prod123", 75.00, "15 Victoria Island");
    }
}

package Exercise_3;

public class LegacyOrderFacade {

    // Composition - wrapping the legacy processor
    private final LegacyOrderProcessor processor;

    public LegacyOrderFacade() {
        this.processor = new LegacyOrderProcessor();
    }

    // Clean, readable method the client calls
    public void placeOrder(String customerEmail, String itemCode,
                           double amount, String deliveryAddress) {

        System.out.println("Placing order for: " + customerEmail);
        processor.processOrder(customerEmail, itemCode, amount, deliveryAddress);
        System.out.println("Order process completed for: " + customerEmail);
    }
}
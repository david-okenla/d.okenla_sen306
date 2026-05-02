package Exercise_1.imports;

import Exercise_2.Logger;
import Exercise_2.TaxCalculator;

public class CheckoutFacade {
    // fields + constructor

    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;
    private Email email;
    private TaxCalculator taxCalculator;
    private Logger logger;
    private SmsService sms; // Bonus: new service added later

    public CheckoutFacade()
    {
        this.inventory = new Inventory();
        this.payment = new Payment();
        this.shipping = new Shipping();
        this.email = new Email();
        this.taxCalculator = new TaxCalculator();
        this.logger = new Logger();
        this.sms = new SmsService();
    }

    public OrderResult checkout(String userId, String productId, double price, String address)
    {
        // TODO: implement

        String trackingNumber = null;

        // If payment fails → no reservation, return failure result.
        if (!payment.charge(userId, price))
        {
            return new OrderResult(false, productId, "No reservation, payment failed");
        }

        // If shipping fails → refund payment, release inventory, return failure
        if (!shipping.isAvailable())
        {
            payment.refund(userId, price);
            return new OrderResult(false, productId, "Payment refunded, shipping unavailable");
        }

        // On success → return tracking number and success message
        if (inventory.checkStock(productId))
        {
            inventory.reserve(productId);
            trackingNumber = shipping.createLabel(address);
            shipping.schedulePickup(trackingNumber);

            double tax = taxCalculator.compute("CA", price);
            double totalPrice = price + tax;

            email.send(userId, "Order Confirmation", "Your order is confirmed. Tracking: " + trackingNumber, " | Total (with tax): $" + totalPrice);

            // Bonus: send SMS notification
            sms.send(userId, "Your order is confirmed! Tracking: " + trackingNumber);

            logger.log(userId, true);

            return new OrderResult(true, trackingNumber, "Order successful");
        }
        else
        {
            payment.refund(userId, price);
            logger.log(userId, false);
            return new OrderResult(false, productId, "Payment refunded, out of stock");
        }
    }

}
package Exercise_1.src;

import Exercise_1.imports.CheckoutFacade;
import Exercise_1.imports.OrderResult;

public class Main {
    public static void main(String[] args) {
        CheckoutFacade checkout = new CheckoutFacade();
        OrderResult result = checkout.checkout("user123", "prod456", 99.99, "123 Main St");
        System.out.println(result);
    }
}

// import java.util.Arrays;

public class CustomerRefactored {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "John Doe",
                "Premium",
                "john@example.com",
                true,
                1
        );

        double[] orders = {120.50, 80.00, 50.25};

        processCustomer(customer, orders);
    }

    /**
     * Main procedure
     */
    public static void processCustomer(Customer customer, double[] orders) {

        validateOrders(orders);
        validateCustomerType(customer.getType());

        double orderTotal = calculateOrderTotal(orders);

        double discountRate = determineDiscountRate(customer.getTypeCode());

        double finalTotal = calculateFinalTotal(orderTotal, discountRate);

        String message = createCustomerMessage(customer, finalTotal);

        displayMessage(message);

        sendCustomerEmail(customer, message);
    }

    /**
     * Calculates total value of orders
     */
    public static double calculateOrderTotal(double[] orders) {

        double sum = 0;

        for (double order : orders) {
            sum += order;
        }

        return sum;
    }

    /**
     * Determines discount percentage
     */
    public static double determineDiscountRate(int customerType) {

        switch (customerType) {

            case 1:
                return 0.10;

            case 2:
                return 0.20;

            default:
                return 0.0;
        }
    }

    /**
     * Calculates total after discount
     */
    public static double calculateFinalTotal(
            double orderTotal,
            double discountRate) {

        return orderTotal - (orderTotal * discountRate);
    }

    /**
     * Creates customer message
     */
    public static String createCustomerMessage(
            Customer customer,
            double finalTotal) {

        String message =
                "Hello " +
                customer.getName() +
                " of " +
                customer.getType() +
                ", your total is " +
                finalTotal;

        if (customer.isVip()) {
            message += " (VIP)";
        }

        return message;
    }

    /**
     * Displays output
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Sends email if available
     */
    public static void sendCustomerEmail(
            Customer customer,
            String message) {

        if (customer.getEmail() != null &&
                !customer.getEmail().isBlank()) {

            System.out.println(
                    "Email sent to " +
                    customer.getEmail() +
                    ": " +
                    message);
        }
    }

    /**
     * Validation for order values
     */
    public static void validateOrders(double[] orders) {

        if (orders == null || orders.length == 0) {
            throw new IllegalArgumentException(
                    "Orders cannot be empty.");
        }

        for (double order : orders) {

            if (order < 0) {
                throw new IllegalArgumentException(
                        "Order values cannot be negative.");
            }
        }
    }

    /**
     * Validation for customer type
     */
    public static void validateCustomerType(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer type is required.");
        }
    }
}

/**
 * Customer class
 */
class Customer {

    private String name;
    private String type;
    private String email;
    private boolean vip;
    private int typeCode;

    public Customer(
            String name,
            String type,
            String email,
            boolean vip,
            int typeCode) {

        this.name = name;
        this.type = type;
        this.email = email;
        this.vip = vip;
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVip() {
        return vip;
    }

    public int getTypeCode() {
        return typeCode;
    }
    
}

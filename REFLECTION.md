# Reflection

## 1. How did you achieve functional cohesion? Which routines did you extract?

I achieved functional cohesion by ensuring that each routine performs a single well-defined task.

The original processCustomer() method handled multiple responsibilities such as:

- Calculating order totals
- Determining discounts
- Calculating final prices
- Building customer messages
- Printing output
- Sending emails
- Performing updates

To improve cohesion, I extracted the following routines:

1. calculateOrderTotal()
2. determineDiscountRate()
3. calculateFinalTotal()
4. createCustomerMessage()
5. displayMessage()
6. sendCustomerEmail()
7. validateOrders()
8. validateCustomerType()

Each routine now has one clear responsibility, making the code easier to maintain, test, and reuse.

---

## 2. What parameter passing issues did you encounter?

The original routine contained many parameters:

```java
processCustomer(
    String n,
    String a,
    double d,
    int t,
    String e,
    boolean g,
    double[] orders,
    int x
)
package Exercise_2;

public class TaxCalculator {
    public double compute(String state, double price) {
        if (state.equals("CA")) {return price * 0.08;} // 8% tax
        return 0.0; // 0% tax;
    }
}

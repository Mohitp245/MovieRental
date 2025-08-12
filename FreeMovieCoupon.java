public class FreeMovieCoupon implements DiscountPolicy {
    private final Customer customer;

    public FreeMovieCoupon(Customer customer) {
        this.customer = customer;
    }

    @Override
    public double applyDiscount(Transaction transaction, double charge) {
        if (customer.getTotalFrequentRenterPoints() >= 10) {
            return 0.0; // one rental free
        }
        return charge;
    }
}
public class BulkRentalCoupon implements DiscountPolicy {
    private final Customer customer;

    public BulkRentalCoupon(Customer customer) {
        this.customer = customer;
    }

    @Override
    public double applyDiscount(Rental rental, double charge) {
        // Only apply $5 off to ONE rental if the customer has 5 or more rentals
        if (customer.getRentals().size() >= 5) {
            return Math.max(charge - 5.0, 0.0); // Avoid negative charge
        }
        return charge;
    }
}
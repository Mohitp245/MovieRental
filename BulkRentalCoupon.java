public class BulkRentalCoupon implements DiscountPolicy {
    private final Customer customer;
    private boolean discountUsed = false; // track if discount already applied

    public BulkRentalCoupon(Customer customer) {
        this.customer = customer;
    }

    @Override
    public double applyDiscount(Transaction transaction, double charge) {
        // Only apply $5 off to ONE rental if the customer has 5 or more rentals
        if (!discountUsed && customer.getTransactions().size() >= 5) {
            discountUsed = true; // mark as used so it won’t apply again
            return Math.max(charge - 5.0, 0.0); // Avoid negative charge
        }
        return charge;
    }
}
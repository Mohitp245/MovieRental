public class DollarOffCoupon implements DiscountPolicy {
    @Override
    public double applyDiscount(Transaction transaction, double originalPrice) {
        if (originalPrice > 5.0) {
            return originalPrice - 1.0;
        }
        return originalPrice;
    }
}
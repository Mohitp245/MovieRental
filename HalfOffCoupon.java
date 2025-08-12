public class HalfOffCoupon implements DiscountPolicy {
    @Override
    public double applyDiscount(Transaction transaction, double originalPrice) {
        return originalPrice * 0.5; // 50% off
    }
}

public class HalfOffCoupon implements DiscountPolicy {
    @Override
    public double applyDiscount(Rental rental, double originalPrice) {
        return originalPrice * 0.5; // 50% off
    }
}

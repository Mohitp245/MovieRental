public class DollarOffCoupon implements DiscountPolicy {
    @Override
    public double applyDiscount(Rental rental, double charge) {
        if (charge > 5.0) {
            return charge - 1.0;
        }
        return charge;
    }
}
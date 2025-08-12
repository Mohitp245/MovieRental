public interface DiscountPolicy {
    double applyDiscount(Transaction transaction, double originalPrice);
}
public class Sale implements Transaction {

    private final Movie movie;
    private final int quantity;
    private DiscountPolicy discountPolicy;

    public Sale(Movie movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    @Override
    public String getTitle() {
        return movie.getTitle();
    }

    @Override
    public double getCharge() {
        return movie.getCharge(quantity);
    }

    @Override
    public double getDiscountedCharge() {
        double original = getCharge();
        if (discountPolicy != null) {
            return discountPolicy.applyDiscount(this, original);
        }
        return original;
    }

    @Override
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(quantity);
    }

    public void setDiscountPolicy(DiscountPolicy policy) {
        this.discountPolicy = policy;
    }
}
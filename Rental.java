public class Rental implements Transaction {

    private final Movie movie;
    private final int daysRented;
    private DiscountPolicy discountPolicy;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
    
    public void setDiscountPolicy(DiscountPolicy policy) {
        this.discountPolicy = policy;
    }
    
    @Override
    public double getDiscountedCharge() {
        double original = getCharge(); // assumes getCharge() gives full price
        if (discountPolicy != null) {
            return discountPolicy.applyDiscount(this, original);
        }
        return original;
    }

    @Override
    public String getTitle() {
        return movie.getTitle();
    }
}
//test 
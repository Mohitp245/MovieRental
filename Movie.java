public class Movie {

    private final String title;
    private final PriceCalculator priceCalculator;
    private final FrequentRenterPointsCalculator pointsCalculator;

    public Movie(String title, PriceCalculator priceCalculator, FrequentRenterPointsCalculator pointsCalculator) {
        this.title = title;
        this.priceCalculator = priceCalculator;
        this.pointsCalculator = pointsCalculator;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCalculator.calculateCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return pointsCalculator.calculatePoints(daysRented);
    }
}

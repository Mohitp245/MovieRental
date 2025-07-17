public class Movie {

    private final String title;
    private Prices priceCode;

    public Movie(String title, Prices priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public Prices getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(Prices priceCode) {
        this.priceCode = priceCode;
    }

    public double getCharge(int daysRented) {
        return priceCode.calculateCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode.calculateFrequentRenterPoints(daysRented);
    }
}

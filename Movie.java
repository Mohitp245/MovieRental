
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String movieTitle;
    private int priceCode;

    public Movie(String title, int price) {
        this.movieTitle = title;
        this.priceCode = price;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return movieTitle;
    }
}

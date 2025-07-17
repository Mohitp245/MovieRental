
public class Rental {

    private final Movie movie;
    private final int daysRented;

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

    public int calculateFrequentRenterPoints() {
        if (movie.getPriceCode() == Movie.NEW_RELEASE && (daysRented > 1)) {
            return 1;
        }
        return 0;
    }

    public double getRentalAmount() {
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR -> {
                amount += 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
            }
            case Movie.NEW_RELEASE ->
                amount += daysRented * 3;
            case Movie.CHILDRENS -> {
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
            }
            default -> {
                throw new IllegalArgumentException("Movie is not categorized. Throwing exception.");
            }
        }
        return amount;
    }
}

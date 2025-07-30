
public class NewReleasePointsCalculator implements FrequentRenterPointsCalculator {

    public int calculatePoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

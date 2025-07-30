
public class NewReleasePriceCalculator implements PriceCalculator {

    public double calculateCharge(int daysRented) {
        return daysRented * 3.0;
    }
}

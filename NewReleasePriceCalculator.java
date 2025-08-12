
public class NewReleasePriceCalculator implements PriceCalculator {

    public double calculateCharge(int daysRented) {
        return daysRented * 3.0;
    }
    @Override
    public double calculateSaleCharge(int quantity) {
        return quantity * 25.0; // Example price for new releases
    }
}

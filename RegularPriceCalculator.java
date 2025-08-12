
public class RegularPriceCalculator implements PriceCalculator {

    public double calculateCharge(int daysRented) {
        double result = 2.0;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    public double calculateSaleCharge(int quantity) {
        return quantity * 15.0; // Example price for new releases
    }
}

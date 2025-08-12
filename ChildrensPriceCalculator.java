
public class ChildrensPriceCalculator implements PriceCalculator {

    public double calculateCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public double calculateSaleCharge(int quantity) {
        return quantity * 10.0; // Example price for new releases
    }
}

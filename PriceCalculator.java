public interface PriceCalculator {
    double calculateCharge(int daysRented);

    default double calculateSaleCharge(int quantity) {
        throw new UnsupportedOperationException("Sale calculation not implemented");
    }
}
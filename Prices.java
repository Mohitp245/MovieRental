public enum Prices {
    REGULAR(2.0, 2, 1.5),
    NEW_RELEASE(3.0, 0, 0),
    CHILDRENS(1.5, 3, 1.5);

    private final double baseCharge;
    private final int baseDays;
    private final double extraDayCharge;

    Prices(double baseCharge, int baseDays, double extraDayCharge) {
        this.baseCharge = baseCharge;
        this.baseDays = baseDays;
        this.extraDayCharge = extraDayCharge;
    }

    public double calculateCharge(int daysRented) {
        if (this == NEW_RELEASE) {
            return daysRented * baseCharge;
        }

        double result = baseCharge;
        if (daysRented > baseDays) {
            result += (daysRented - baseDays) * extraDayCharge;
        }
        return result;
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        if (this == NEW_RELEASE && daysRented > 1) {
            return 2; // Bonus point for multi-day new release
        }
        return 1; // Default is 1 point
    }
}

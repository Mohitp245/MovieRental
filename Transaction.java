public interface Transaction {
    String getTitle();
    double getCharge();
    double getDiscountedCharge();
    int getFrequentRenterPoints();
}
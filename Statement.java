public class Statement {

    private final Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }

    public String printStatement() {
        int frequentRenterPoints = 0;
        double totalAmount = 0;
        StringBuilder result = new StringBuilder("Rental Record for ");
        result.append(customer.getName()).append("\n");

        for (Transaction t : customer.getTransactions()) {
            double currentAmount = t.getDiscountedCharge();
            frequentRenterPoints += t.getFrequentRenterPoints();
            result.append("\t").append(t.getTitle()).append("\t").append(currentAmount).append("\n");
            totalAmount += currentAmount;
        }

        result.append(buildFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private double calculateRentalAmount(Rental rental) {
        return rental.getCharge();
    }

    private int calculateFrequentRenterPoints(double charge) {
        int points = 1;
        points += charge;
        return points;
    }

    private String buildRentalLine(Rental rental, double amount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
    }

    private String buildFooter(double totalAmount, int points) {
        return "Amount owed is " + totalAmount + "\n" +
               "You earned " + points + " frequent renter points";
    }
}
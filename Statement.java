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

        for (Rental rental : customer.getRentals()) {
            double currentAmount = calculateRentalAmount(rental);
            frequentRenterPoints += calculateFrequentRenterPoints(rental);

            result.append(buildRentalLine(rental, currentAmount));
            totalAmount += currentAmount;
        }

        result.append(buildFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private double calculateRentalAmount(Rental rental) {
        return rental.getCharge();
    }

    private int calculateFrequentRenterPoints(Rental rental) {
        int points = 1;
        points += rental.getCharge();
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
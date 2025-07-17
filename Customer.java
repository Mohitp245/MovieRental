
import java.util.ArrayList;

public class Customer {

    private final String customerName;
    private final ArrayList<Rental> customerRentals = new ArrayList<>();

    public Customer(String name) {
        this.customerName = name;
    }

    public void addRental(Rental title) {
        customerRentals.add(title);
    }

    public String getName() {
        return customerName;
    }

    
    public String prinStatement() {

        int frequentRenterPoints = 0;
        double totalAmount = 0;
        StringBuilder result = new StringBuilder("Rental Record for ");
        result.append(getName()).append("\n");

        for (int i = 0; i < customerRentals.size(); i++) {

            Rental currentRental = customerRentals.get(i);
            double currentAmount = currentRental.getRentalAmount();
            // determine amounts for each line

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            frequentRenterPoints += currentRental.calculateFrequentRenterPoints();

            // show figures for this rental
            result.append("\t").append(currentRental.getMovie().getTitle()).append("\t").append(currentAmount).append("\n");
            totalAmount += currentAmount;
        }

        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }
    
    public String printStatementXML() {
        int frequentRenterPoints = 0;
        double totalAmount = 0;
        StringBuilder result = new StringBuilder();
  
        result.append("&lt;customer&gt;\n");
        result.append("  &lt;name&gt;").append(getName()).append("&lt;/name&gt;\n");
        result.append("  &lt;rentals&gt;\n");
  
        for (Rental currentRental : customerRentals) {
            double currentAmount = currentRental.getRentalAmount();
  
            // add frequent renter points
            frequentRenterPoints++;
            frequentRenterPoints += currentRental.calculateFrequentRenterPoints();
  
            result.append("    &lt;rental&gt;\n");
            result.append("      &lt;movie&gt;").append(currentRental.getMovie().getTitle()).append("&lt;/movie&gt;\n");
            result.append("      &lt;amount&gt;").append(currentAmount).append("&lt;/amount&gt;\n");
            result.append("    &lt;/rental&gt;\n");
  
            totalAmount += currentAmount;
        }
  
        result.append("  &lt;/rentals&gt;\n");
        result.append("  &lt;totalAmount&gt;").append(totalAmount).append("&lt;/totalAmount&gt;\n");
        result.append("  &lt;frequentRenterPoints&gt;").append(frequentRenterPoints).append("&lt;/frequentRenterPoints&gt;\n");
        result.append("&lt;/customer&gt;");
  
        return result.toString();
    }

}
// Testing


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

}

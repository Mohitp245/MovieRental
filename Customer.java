
import java.util.ArrayList;
import java.util.List;

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

    
    public List<Rental> getRentals() {
    return customerRentals;
}

}


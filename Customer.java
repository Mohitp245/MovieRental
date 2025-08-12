
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String customerName;
    private final ArrayList<Transaction> transactions = new ArrayList<>();


    public Customer(String name) {
        this.customerName = name;
    }

    public String getName() {
        return customerName;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        for (Transaction t : transactions) {
            totalPoints += t.getFrequentRenterPoints();
        }
        return totalPoints;
    }
}


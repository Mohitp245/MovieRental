public class Main {
    public static void main(String[] args) {
        // Create some sample movies
        Movie movie1 = new Movie("The Matrix", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Toy Story", Movie.CHILDRENS);
        Movie movie3 = new Movie("John Wick", Movie.REGULAR);

        // Create rentals for those movies
        Rental rental1 = new Rental(movie1, 3); // 3 days
        Rental rental2 = new Rental(movie2, 5); // 5 days
        Rental rental3 = new Rental(movie3, 2); // 2 days

        // Create a customer and add the rentals
        Customer customer = new Customer("John Doe");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        // Print the plain text and XML statements
        System.out.println(customer.prinStatement());
        System.out.println();
        System.out.println(customer.printStatementXML());
    }
}
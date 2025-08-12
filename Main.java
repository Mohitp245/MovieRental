public class Main {
    public static void main(String[] args) {
        // Create movies with different pricing and points calculators
        Movie newReleaseMovie = new Movie(
            "The Matrix Resurrections",
            new NewReleasePriceCalculator(),
            new NewReleasePointsCalculator()
        );

        Movie childrenMovie = new Movie(
            "Frozen II",
            new ChildrensPriceCalculator(),
            new ChildrensPointsCalculator()
        );

        Movie regularMovie = new Movie(
            "The Godfather",
            new RegularPriceCalculator(),
            new RegularPointsCalculator()
        );

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
        Customer carol = new Customer("Carol");

        // Alice rents new release and children movies
        Rental aliceRental1 = new Rental(newReleaseMovie, 4); // 4 days
        Rental aliceRental2 = new Rental(childrenMovie, 3);   // 3 days

        // Apply HalfOffCoupon to first rental for Alice
        aliceRental1.setDiscountPolicy(new HalfOffCoupon());

        alice.addTransaction(aliceRental1);
        alice.addTransaction(aliceRental2);

        // Bob rents multiple movies to test BulkRentalCoupon
        bob.addTransaction(new Rental(newReleaseMovie, 1));
        bob.addTransaction(new Rental(childrenMovie, 2));
        bob.addTransaction(new Rental(regularMovie, 2));
        bob.addTransaction(new Rental(childrenMovie, 3));

        Rental bobRental5 = new Rental(regularMovie, 4);
        bobRental5.setDiscountPolicy(new BulkRentalCoupon(bob)); // Bulk discount applies on 5+ rentals
        bob.addTransaction(bobRental5);

        // Carol rents a movie and should get it free via FreeRentalCoupon
        Rental carolRental = new Rental(regularMovie, 5);
        carolRental.setDiscountPolicy(new FreeMovieCoupon(carol));
        carol.addTransaction(carolRental);

        // Print statements for all customers
        System.out.println("=== Alice's Statement ===");
        Statement aliceStatement = new Statement(alice);
        System.out.println(aliceStatement.printStatement());

        System.out.println("\n=== Bob's Statement ===");
        Statement bobStatement = new Statement(bob);
        System.out.println(bobStatement.printStatement());

        System.out.println("\n=== Carol's Statement ===");
        Statement carolStatement = new Statement(carol);
        System.out.println(carolStatement.printStatement());

        // Also show frequent renter points for each customer
        System.out.println("Frequent Renter Points:");
        System.out.println("Alice: " + alice.getTotalFrequentRenterPoints());
        System.out.println("Bob: " + bob.getTotalFrequentRenterPoints());
        System.out.println("Carol: " + carol.getTotalFrequentRenterPoints());
    }
}
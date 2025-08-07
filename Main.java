public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie(
            "The Matrix",
            new NewReleasePriceCalculator(),
            new NewReleasePointsCalculator()
        );
        Movie movie2 = new Movie(
            "Frozen",
            new ChildrensPriceCalculator(),
            new ChildrensPointsCalculator()
        );

        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 5);
        rental1.setDiscountPolicy(new HalfOffCoupon());  // Apply 50% off coupon

        Customer customer1 = new Customer("Alice");
        customer1.addRental(rental1);
        customer1.addRental(rental2);

        Movie movie3 = new Movie(
            "The Matrix",
            new NewReleasePriceCalculator(),
            new NewReleasePointsCalculator()
        );
        Movie movie4 = new Movie(
            "Amazing Spiderman",
            new ChildrensPriceCalculator(),
            new ChildrensPointsCalculator()
        );

        // ADD THESE LINES (start)
        Movie movie5 = new Movie(
            "Oppenheimer",
            new RegularPriceCalculator(),
            new RegularPointsCalculator()
        );

        Customer customer2 = new Customer("Bob");

        // Add 4 rentals first
        customer2.addRental(new Rental(movie1, 1));
        customer2.addRental(new Rental(movie2, 2));
        customer2.addRental(new Rental(movie3, 2));
        customer2.addRental(new Rental(movie4, 3));

        // Add the 5th rental with the BulkRentalCoupon
        Rental rental5 = new Rental(movie5, 3);
        rental5.setDiscountPolicy(new BulkRentalCoupon(customer2));
        customer2.addRental(rental5);
        // ADD THESE LINES (end)

        Statement statement1 = new Statement(customer1);
        System.out.println(statement1.printStatement());
        System.out.println("Rental 1 original price: " + rental1.getCharge());
        System.out.println("Rental 1 with 50% off: " + rental1.getDiscountedCharge() + "\n");

        Statement statement2 = new Statement(customer2);
        System.out.println(statement2.printStatement());
    }
}

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

        Customer customer = new Customer("Alice");
        customer.addRental(rental1);
        customer.addRental(rental2);

        Statement statement = new Statement(customer);
        System.out.println(statement.printStatement());
        System.out.println("Rental 1 original price: " + rental1.getCharge());
        System.out.println("Rental 1 with 50% off: " + rental1.getDiscountedCharge());
    }
}

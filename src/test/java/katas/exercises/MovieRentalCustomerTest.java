package katas.exercises;

import katas.exercises.movieRental.Rental;
import katas.exercises.movieRental.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovieRentalCustomerTest {
    @Test
    public void test() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }
    @Test
    public void testHtmlStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expectedHtml = "" +
                "<h1>Rental Record for <em>Bob</em></h1>" +
                "<table>" +
                "<tr><td>Jaws</td><td>2.0</td></tr>" +
                "<tr><td>Golden Eye</td><td>3.5</td></tr>" +
                "<tr><td>Short New</td><td>3.0</td></tr>" +
                "<tr><td>Long New</td><td>6.0</td></tr>" +
                "<tr><td>Bambi</td><td>1.5</td></tr>" +
                "<tr><td>Toy Story</td><td>3.0</td></tr>" +
                "</table>" +
                "<p>Amount owed is <em>19.0</em></p>" +
                "<p>You earned <em>7</em> frequent renter points</p>";

        assertEquals(expectedHtml, customer.htmlStatement());
    }
    @Test
    public void testHtmlStatement2() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Charlie");
        customer.addRental(new Rental(new Movie("The Matrix", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("John Wick", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Finding Nemo", Movie.CHILDRENS), 4));

        String expectedHtml = "" +
                "<h1>Rental Record for <em>Charlie</em></h1>" +
                "<table>" +
                "<tr><td>The Matrix</td><td>3.5</td></tr>" +
                "<tr><td>John Wick</td><td>6.0</td></tr>" +
                "<tr><td>Finding Nemo</td><td>3.0</td></tr>" +
                "</table>" +
                "<p>Amount owed is <em>12.5</em></p>" +
                "<p>You earned <em>4</em> frequent renter points</p>";

        assertEquals(expectedHtml, customer.htmlStatement());
    }

}

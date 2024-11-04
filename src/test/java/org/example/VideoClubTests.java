package org.example;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VideoClubTests {
    @Test
    public void testCrearMovie() {
        Movie tenet = new Movie("Tenet", Movie.NEW_RELEASE);
        assertThat(tenet.getTitle(), equalTo("Tenet"));
    }

    @Test
    public void testPriceCode() {
        Movie tenet = new Movie("Tenet", Movie.NEW_RELEASE);
        Movie busan = new Movie("Train to Busan", Movie.REGULAR);
        Movie padre = new Movie("Padre no hay más que uno", Movie.CHILDRENS);

        assertThat(tenet.getPriceCode(), equalTo(Movie.NEW_RELEASE));
        assertThat(busan.getPriceCode(), equalTo(Movie.REGULAR));
        assertThat(padre.getPriceCode(), equalTo(Movie.CHILDRENS));
    }

    @Test
    public void testRental() {
        Movie tenet = new Movie("Tenet", Movie.NEW_RELEASE);
        Rental rental = new Rental(tenet, 2);
        assertThat(rental.getMovie().getTitle(), equalTo("Tenet"));
        assertThat(rental.getDaysRented(), equalTo(2));
    }

    @Test
    public void testCustomer() {
        Customer customer = new Customer("domingogallardo");
        assertThat(customer.getName(), equalTo("domingogallardo"));
    }

    @Test
    public void testCustomerEmptyStatement() {
        Customer customer = new Customer("domingogallardo");
        String statement = customer.statement();
        assertThat(statement, allOf(
                containsString("Rental Record for domingogallardo"),
                containsString("Amount owed is 0.0"),
                containsString("You earned 0 frequent renter points")));
    }

    @Test
    public void testCustomerFullStatement() {
        Customer customer = new Customer("domingogallardo");
        Movie tenet = new Movie("Tenet", Movie.NEW_RELEASE);
        Movie busan = new Movie("Train to Busan", Movie.REGULAR);
        Movie padre = new Movie("Padre no hay más que uno", Movie.CHILDRENS);

        Rental rental1 = new Rental(tenet, 2);
        Rental rental2 = new Rental(busan, 2);
        Rental rental3 = new Rental(padre, 1);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        assertThat(customer.statement(), allOf(
                containsString("Rental Record for domingogallardo"),
                stringContainsInOrder("Tenet", "6.0"),
                stringContainsInOrder("Train to Busan", "2.0"),
                stringContainsInOrder("Padre no hay más que uno", "1.5"),
                containsString("Amount owed is 9.5"),
                containsString("You earned 4 frequent renter points")));
    }
}
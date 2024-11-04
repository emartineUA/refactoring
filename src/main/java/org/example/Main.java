package org.example;

public class Main {
    public static void main(String[] args) {
        Movie tenet = new Movie("Tenet", Movie.NEW_RELEASE);
        Movie busan = new Movie("Train to Busan", Movie.REGULAR);
        Movie padre = new Movie("Padre no hay más que uno", Movie.CHILDRENS);

        Rental rental1 = new Rental(tenet, 2);
        Rental rental2 = new Rental(busan, 2);
        Rental rental3 = new Rental(padre, 1);

        Customer customer = new Customer("domingogallardo");

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        System.out.println(customer.statement());
        System.out.println("\n************ HTML **************\n");
        System.out.println(customer.htmlStatement());
    }
}

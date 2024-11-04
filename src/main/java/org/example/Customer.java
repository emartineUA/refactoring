package org.example;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration allRentals = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (allRentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) allRentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";

        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration allRentals = rentals.elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        result += "<ul>\n";
        while (allRentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) allRentals.nextElement();

            //show figures for this rental
            result += "<li>" + each.getMovie().getTitle() + ":" +
                    String.valueOf(each.getCharge()) + "</li>\n";

        }
        result += "</ul>\n";
        //add footer lines
        result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> frequent renter points</p>\n";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

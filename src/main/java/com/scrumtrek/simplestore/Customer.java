package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String m_Name;
    private List<Rental> m_Rentals = new ArrayList<Rental>();
    private static final int REGULAR_CURRENT_PRICE = 2;  

    public Customer(String name) {
        m_Name = name;
    }

    public String getName() {
        return m_Name;
    }

    public void addRental(Rental arg) {
        m_Rentals.add(arg);
    }

    public String Statement() {
        Report report = new Report();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

      
        String result = Report.TITLE + m_Name + "\n";


        for (Rental each : m_Rentals) {

            double currentPrice = getCurrentMoviePrice(each); // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + currentPrice + "\n";

            totalAmount += currentPrice;
        }

        // Add footer lines
        result += Report.AMOUNT_TEXT_REPORT + totalAmount + "\n";

        result += Report.EARNED_TEXT + frequentRenterPoints + Report.END_PART;

        return result;
    }

    public double getCurrentMoviePrice(Rental rental) {
        double currentPrice = 0;

        // Determine amounts for each line
        switch (rental.getMovie().getPriceCode()) {
            case Regular:
                currentPrice += REGULAR_CURRENT_PRICE;
                if (rental.getDaysRented() > 2) {
                    currentPrice += (rental.getDaysRented() - 2) * 1.5;
                }
                break;

            case NewRelease:
                currentPrice += rental.getDaysRented() * 3;
                break;

            case Childrens:
                currentPrice += 1.5;
                if (rental.getDaysRented() > 3) {
                    currentPrice = (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return currentPrice;
    }
    
}

package com.scrumtrek.simplestore.printer;

import com.scrumtrek.simplestore.Rental;
import com.scrumtrek.simplestore.printer.Printer;

public class ConsolePrinter implements Printer {

    private StringBuilder message = new StringBuilder();

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String getHTMLHeader(boolean isPrinted, String name, String text) {
        if (isPrinted) {
            return text + " " + name + HTML_BR;
        }
        return "";
    }

    @Override
    public String getHTMLContent(int contentType, Rental rental) {
        switch (contentType) {
            case CONTENT_EMPTY: {
                return "";
            }

            case CONTENT_ONLY_RENTAL: {
                return HTML_TAB_OPEN + rental.toString() + HTML_TAB_CLOSE;
            }
            case CONTENT_RENTAL_WITH_MOVIE: {
                return HTML_TAB_OPEN + rental.getMovie().getTitle() + " " + rental.getMovie().getPriceCode() + HTML_TAB_CLOSE + HTML_BR;
            }
            case CONTENT_RENTAL_WITH_TOTAL: {
                return HTML_TAB_OPEN + rental.getAmount() + HTML_TAB_CLOSE + HTML_BR;
            }
            case CONTENT_FULL: {
                return HTML_TAB_OPEN + rental.getMovie().getTitle() + " " + rental.getMovie().getPriceCode() + " " + rental.getAmount() + HTML_TAB_CLOSE + HTML_BR;
            }

        }
        return null;
    }

    @Override
    public String getHTMLFooter(boolean isPrinted, String text, double totalAmount) {
        if (isPrinted) {
            return text + HTML_BR;
        }
        return "";
    }

    @Override
    public String getPlainTextHeader(boolean isPrinted, String name, String text) {
        if (isPrinted) {
            return text + " " + name + PLAIN_BR;
        }
        return "";
    }

    @Override
    public String getPlainTextContent(int contentType, Rental rental) {
        switch (contentType) {
            case CONTENT_EMPTY: {
                return "";
            }

            case CONTENT_ONLY_RENTAL: {
                return PLAIN_TAB +  rental.toString() + PLAIN_TAB;
            }
            case CONTENT_RENTAL_WITH_MOVIE: {
                return PLAIN_TAB + rental.getMovie().getTitle() + " " + rental.getMovie().getPriceCode() + PLAIN_TAB + PLAIN_BR;
            }
            case CONTENT_RENTAL_WITH_TOTAL: {
                return PLAIN_TAB + rental.getAmount() + PLAIN_TAB + PLAIN_BR;
            }
            case CONTENT_FULL: {
                return PLAIN_TAB + rental.getMovie().getTitle() + " " + rental.getMovie().getPriceCode() + " " + rental.getAmount() + PLAIN_TAB + PLAIN_BR;
            }

        }
        return null;
    }

    @Override
    public String getPlainTextFooter(boolean isPrinted, String text, double totalAmount) {
        if (isPrinted) {
            return text + PLAIN_BR;
        }
        return "";
    }

}

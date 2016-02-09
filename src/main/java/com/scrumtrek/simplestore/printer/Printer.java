package com.scrumtrek.simplestore.printer;

import com.scrumtrek.simplestore.Rental;

public interface Printer {

    public static final String HTML_BR = "<br>";
    public static final String PLAIN_BR = "\n";
    public static final String PLAIN_TAB = "\t";
    public static final String HTML_TAB_OPEN = "<table>";
    public static final String HTML_TAB_CLOSE = "</table>";
    
    public static final int CONTENT_EMPTY = 0;
    public static final int CONTENT_ONLY_RENTAL = 1;
    public static final int CONTENT_RENTAL_WITH_MOVIE = 2;
    public static final int CONTENT_RENTAL_WITH_TOTAL = 3;
    public static final int CONTENT_FULL = 4;

    void print(String message);
    
    public String getHTMLHeader(boolean isPrinted, String name, String text);
    
    public String getHTMLContent(int contentType, Rental rental);
    
    public String getHTMLFooter(boolean isPrinted, String text, double totalAmount);
    
        public String getPlainTextHeader(boolean isPrinted,  String name, String text);
    
    public String getPlainTextContent(int contentType, Rental rental);
    
    public String getPlainTextFooter(boolean isPrinted, String text, double totalAmount);
}

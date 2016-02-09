/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore.codes;

/**
 *
 * @author root
 */
public class AdultPriceCode implements PriceCodes{
 public static final int ADULT_BONUS = 2;
    public static final int ADULT_DAYS = 5;
    public static final double ADULT_ADD = 1.6;
    public static final String ADULT_PRICE_CODE_NAME = "ADULT_PRICE_CODE";

    @Override
    public double getAmount(double amount, int rentalDays) {
        if (rentalDays > ADULT_DAYS) {
            return (rentalDays - ADULT_DAYS) * ADULT_ADD + ADULT_BONUS;
        }
        return ADULT_BONUS;
    }

    @Override
    public String getName() {
        return ADULT_PRICE_CODE_NAME;
    }
    
}

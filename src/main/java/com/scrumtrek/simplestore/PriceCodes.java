package com.scrumtrek.simplestore;

public enum PriceCodes {
	Regular(2.0, 1.5, 2),
	NewRelease(0.0, 3.0, 0),
	Childrens(1.5, 1.5, 3);
        
        private double firstPrice;
        private double amountPrice;
        private int dayFirstPrice;
        
        PriceCodes(double firstPrice, double amountPrice, int dayFirstPrice){
            this.firstPrice = firstPrice;
            this.amountPrice = amountPrice;
            this.dayFirstPrice = dayFirstPrice;
        }

    public double getFirstPrice() {
        return firstPrice;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public int getDayFirstPrice() {
        return dayFirstPrice;
    }
        
        
}

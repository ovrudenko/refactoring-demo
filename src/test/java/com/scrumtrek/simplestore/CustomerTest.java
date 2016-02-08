/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrumtrek.simplestore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class CustomerTest {

    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Customer.
     */
    //@Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRental method, of class Customer.
     */
    @Test
    public void testAddRental() {
        System.out.println("addRental");
        Rental arg = null;
        Customer instance = new Customer("Bon Jovi");
        instance.addRental(new Rental(new Movie("007", PriceCodes.NewRelease), 3));
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Bon Jovi", instance.getName());
    }

    /**
     * Test of Statement method, of class Customer.
     */
    @Test
    public void testRegularStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Regular);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 3.5 + "\n";
        expResult += "Amount owed is 3.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
        @Test
    public void testChildrensStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.Childrens);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 1.5 + "\n";
        expResult += "Amount owed is 1.5\n";
        expResult += "You earned 1 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }
    
            @Test
    public void tesNewReleaseStatement() {
        System.out.println("Statement");
        Customer instance = new Customer("Igor Startsev");
        Movie m = new Movie("007", PriceCodes.NewRelease);
        instance.addRental(new Rental(m, 3));
        String expResult = "Rental record for " + instance.getName() + "\n";
        expResult += "\t" + m.getTitle() + "\t" + 9.0 + "\n";
        expResult += "Amount owed is 9.0\n";
        expResult += "You earned 2 frequent renter points.";

        String result = instance.Statement();
        System.out.println("result=" + result);
        System.out.println("expRes=" + expResult);
        //result += "Amount owed is 3.5 \n";
        // result += "You earned 1 frequent renter points.";
        assertTrue(result.equals(expResult));
        // TODO review the generated test code and remove the default call to fail.

    }

}
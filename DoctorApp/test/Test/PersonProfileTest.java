/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// Class to be tested
import doctorapp.PersonProfile.*;
import doctorapp.PersonProfile;
import junit.framework.Assert;

/**
 *
 * @author mosborn1987
 */
public class PersonProfileTest {

    PersonProfile m_profile;

    public PersonProfileTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void test_1() {
        // Test Description:
        // This test will make sure that the Constructor is working
        // correctly, when passed a valid first, middle and last name.

        FullName fn;

        try {
            fn = new PersonProfile.FullName("Mario", "Alberto", "Osborn");
            assertTrue(fn.getFirstString().compareTo("Mario") == 0);
            assertTrue(fn.getMiddleString().compareTo("Alberto") == 0);
            assertTrue(fn.getLastString().compareTo("Osborn") == 0);
            
        } catch (InvalidNameException ex) {
            fail("The name - Mario Alberto Osborn - is valid, constructor failed");
        }
    }

    @Test
    public void test_2() {
        // Test Description:
        // An invalid name will be passed. The constructor should throw an
        // exception
        FullName fn;

        try {
            fn = new PersonProfile.FullName(null, "Alberto", "Osborn");

            fail("The constructor should not have taken 'null' as a first name parameter");

        } catch (InvalidNameException ex) {
            // Passed!!
        }
    }
    
        @Test
    public void test_3() {
        // Test Description:
        // Test toString()

        FullName fn;

        try {
            fn = new PersonProfile.FullName("Mario", "Alberto", "Osborn");
            assertTrue(fn.getFirstString().compareTo("Mario") == 0);
            assertTrue(fn.getMiddleString().compareTo("Alberto") == 0);
            assertTrue(fn.getLastString().compareTo("Osborn") == 0);
            assertTrue(fn.toString().compareTo("Mario Alberto Osborn")== 0);

        } catch (InvalidNameException ex) {
            fail("The name - Mario Alberto Osborn - is valid, constructor failed");
        }
    }
    
            @Test
    public void test_4() {
        // Test Description:
        // Test toString()

        FullName fn;

        try {
            fn = new PersonProfile.FullName("Mario", "", "Osborn");
            assertTrue(fn.getFirstString().compareTo("Mario") == 0);
            assertTrue(fn.getMiddleString().compareTo("") == 0);
            assertTrue(fn.getLastString().compareTo("Osborn") == 0);
            assertTrue(fn.toString().compareTo("Mario Osborn")== 0);

        } catch (InvalidNameException ex) {
            fail("The name - Mario Alberto Osborn - is valid, constructor failed");
        }
    }

 }

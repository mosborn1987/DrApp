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
    public void test_1(){
        // Test FullName Class
        FullName fn;
        boolean success = true;
        
        try{
            fn = new PersonProfile.FullName("Mario", "Alberto", "Osborn");
            assertTrue(fn.getFirstString().compareTo("Mario") == 0);
            assertTrue(fn.getMiddleString().compareTo("Alberto") == 0);
            assertTrue(fn.getLastString().compareTo("Osborn") == 0);

        }catch(InvalidNameException ex)
        {
            fail("The name Mario Osborn is valid, constructor failed");
        }
    }
}

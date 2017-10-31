/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import doctorapp.LoginCredentials;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mosborn1987
 */
public class LoginCredentialsTest {

    public LoginCredentialsTest() {
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
    public void UserName_Test_1() {
        LoginCredentials.UserName un;
        try {
            un = new LoginCredentials.UserName("Mario");
        } catch (LoginCredentials.InvalidUserName ex) {
            fail("UserName Constructor failed");
        }
    }

    @Test
    public void UserName_Test_2() {
        LoginCredentials.UserName un;
        try {
            un = new LoginCredentials.UserName(null);
            fail("UserName Constructor should have but did not fail");
        } catch (LoginCredentials.InvalidUserName ex) {
            // The catch-code should be run. 
        }
    }
    
    
    @Test
    public void UserName_Test_3() {
        LoginCredentials.UserName un;
        try {
            un = new LoginCredentials.UserName("");
            fail("UserName Constructor should have but did not fail");
        } catch (LoginCredentials.InvalidUserName ex) {
            // The catch-code should be run. 
        }
    }

    @Test
    public void UserName_Password_1() {

    }

    @Test
    public void UserName_Email_1() {

    }

}

package com.mycompany.prog5121_poe_v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    @Test
    public void testValidUsername() {
        Login user = new Login("k_12", "password@1", "+27831234567");
        assertTrue(user.checkUserName());
    }
    
    @Test
    public void testInvalidUsername() {
        Login user = new Login("Soule", "Password@1", "+2781234567");
        assertFalse(user.checkUserName());
    }
    
    @Test
    public void testValidPassword() {
        Login user = new Login("k_12", "Password@1", "+27831234567");
        assertTrue(user.checkPasswordComplexity());
    
    }
    
    @Test
    public void testInvalidPassword() {
        Login user = new Login("k_12", "password", "+27831234567");
        assertFalse(user.checkPasswordComplexity());
    }
    
    @Test
    public void testValidCellPhone() {
        Login user = new Login("k_12", "Password@1", "+27831234567");
        assertTrue(user.checkCellPhoneNumber());
    }
    
    @Test
    public void testInvalidCellPhone() {
        Login user = new Login("k_12", "Password@1", "0831234567");
        assertFalse(user.checkCellPhoneNumber());
    }
}
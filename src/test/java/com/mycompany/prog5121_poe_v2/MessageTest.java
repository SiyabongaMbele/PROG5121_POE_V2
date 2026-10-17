package com.mycompany.prog5121_poe_v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    @Test
    public void testValidMessageID() {
        
        Message msg = 
                new Message(
                        "1234567890",
                        1,
                        "+27831234567",
                        "Hello World"
                );
        
        assertTrue(msg.checkMessageID());
    }
    
    @Test
    public void testInvalidMessageID() {
        
        Message msg = 
                new Message(
                            "12345678901",
                            1,
                            "+27831234567",
                            "Hello World"
                );
        
        assertFalse(msg.checkMessageID());
    }
    
    @Test
    
    public void testValidRecipientCell() {
        
        Message msg = 
                new Message(
                        "1234567890",
                        1,
                        "+27831234567",
                        "Hello World"
                );
        
        assertTrue(msg.checkRecipientCell());
    }
    
    @Test
    public void testInvalidRecipientCell() {
        
        Message msg = 
                new Message(
                        "1234567890",
                         1,
                        "0831234567",
                        "Hello World"
                );
        assertFalse(msg.checkRecipientCell());
    }
    
    @Test
    public void testMessageHashCreation() {
        
        Message msg = 
                new Message(
                        "1234567890",
                        1,
                        "+27831234567",
                        "Hello World"
                );
        
        String expectedHash =
                "12:1:HELLOWORLD";
        
        assertEquals(
                expectedHash,
                msg.createMessageHash()
        );
    }
}

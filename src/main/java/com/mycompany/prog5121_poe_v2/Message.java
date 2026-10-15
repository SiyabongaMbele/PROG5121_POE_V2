package com.mycompany.prog5121_poe_v2;

public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    
    public Message(String messageID, 
            int messageNumber,
            String recipient,
            String message) {
        
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
    }
    
    public boolean checkMessageID() {
        
        return messageID.length() <= 10;
    }
    
    public boolean checkRecipientCell() {
        return
recipient.matches("\\+27\\d{9}$");
    }
}
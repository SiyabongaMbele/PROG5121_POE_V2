package com.mycompany.prog5121_poe_v2;

import java.util.ArrayList;

public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    
    public static ArrayList<String> sentMessages = 
            new ArrayList<>();
    
    public static ArrayList<String> recipients = 
            new ArrayList<>();
    
    public static ArrayList<String> messageHashes = 
            new ArrayList<>();
    
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

    public String createMessageHash() {
        
        String firstWord = message.split(" ")[0];
        String lastWord = message.split(" ")[message.split(" "
        ).length - 1];
        
        messageHash = 
                messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord.toUpperCase()
                + lastWord.toUpperCase();
        
        return messageHash;
}
     
    public static int getTotalMessagesSent() {
        return sentMessages.size();
    }
    public String createMessageID() {
        
        long randomNumber = (long)(Math.random() * 1000000000);
        
        messageID = String.valueOf(randomNumber);
        
        return messageID;
    }
    
    public static ArrayList<String> storedMessages = 
            new ArrayList<>();
    
    public static ArrayList<String> disregardedMessages = 
            new ArrayList<>();
}
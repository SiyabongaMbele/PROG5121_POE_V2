package com.mycompany.prog5121_poe_v2;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;

import java.io.FileWriter;

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
    
    public static ArrayList<String> storedMessages = 
            new ArrayList<>();
    
    public static ArrayList<String> disregardedMessages = 
            new ArrayList<>();
    
    public static ArrayList<String> messageIDs = 
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
        
    public static void populatePOETestData() {
        
        // Sent Messages
        sentMessages.add("Did you get the cake?");
        recipients.add("+278345557896");
        messageIDs.add("MSG001");
        messageHashes.add("MS:1:DIDCAKE");
        
        sentMessages.add("It is dinner time !");
        recipients.add("0838884567");
        messageIDs.add("MSG004");
        messageHashes.add("MS:4:ITTIME");
        
        // Stored Messages
        storedMessages.add(
                "Where are you? You are late! I have asked you to be on time."
        );
        
        storedMessages.add("OK, I am leaving without you."
                );
        
        // Disregards Messages
        disregardedMessages.add("Yohoooo, I am at your gate."
        );
    }
    
    public static void saveStoredMessagesToJSON() {

    try {

        Gson gson = new Gson();

        FileWriter writer =
                new FileWriter(
                        "storedMessages.json"
                );

        gson.toJson(
                storedMessages,
                writer
        );

        writer.close();

        System.out.println(
                "Stored messages saved to JSON."
        );

    } catch (Exception e) {

        System.out.println(
                "Error saving JSON file."
        );
    }
}
    
public static void loadStoredMessagesFromJSON() {

    try {

        Gson gson = new Gson();

        Type listType =
                new TypeToken<ArrayList<String>>() {
                }.getType();

        FileReader reader =
                new FileReader(
                        "storedMessages.json"
                );

        storedMessages =
                gson.fromJson(
                        reader,
                        listType
                );

        reader.close();

        System.out.println(
                "Stored messages loaded from JSON."
        );

    } catch (Exception e) {

        System.out.println(
                "Error loading JSON file."
        );
    }
}    
    
}
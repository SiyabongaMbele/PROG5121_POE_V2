package com.mycompany.prog5121_poe_v2;

import java.util.Scanner;

public class PROG5121_POE_V2 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("===== USER REGISTRATION =====");
        
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        
        System.out.print("Enter Cell Number: ");
        String cellNumber = input.nextLine();
        
        Login user = new Login(username, password, cellNumber);
        
        String registrationMessage = 
                user.registerUser();
        
        System.out.println(registrationMessage);
        
        boolean registrationSuccess = 
                user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber();
        
        if (registrationSuccess) {
           
        System.out.println("\n===== LOGIN =====");
        
        System.out.println("Enter First Name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter Username: ");
        String loginUsername = input.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();
        
        boolean loginSuccess =
                user.loginUser(loginUsername, loginPassword);
        
        System.out.println(
                user.returnLoginStatus(
                        loginSuccess,
                        firstName,
                        lastName)
);
        
if(loginSuccess) {
    
   Message.populatePOETestData();
   
   Message.saveStoredMessagesToJSON();
   
   Message.loadStoredMessagesFromJSON();
   
   boolean exit = false;
   
   while (!exit) {
    
    System.out.println("""
    1. Send Messages
    2. Show Recently Sent Messages
    3. Quit
    4. Stored Mesages
    """);

    int choice =
Integer.parseInt(input.nextLine());
    
switch (choice) {
    
    case 1:
        System.out.println("How Many Messages would You Like to Send? ");
        
        int numberOfMessages = 
                Integer.parseInt(input.nextLine());
        
        for (int i = 1; i <= numberOfMessages; i++) {
            
            System.out.println(
                      "\nMessage Number: " + i
            );
            
        String recipientNumber;
        Message temp;
        
        do {
            
            System.out.print("Enter Recipient Number: ");
            recipientNumber = input.nextLine();
            
            temp = new Message(
                    "1234567890",
                    i,
                    recipientNumber,
                    ""
            );
            
            if (!temp.checkRecipientCell()) {
                
                System.out.println(""
                        + "Cellphone Number Incorrected Formatted. Please Try Again."
                );
            }
            
        } while (!temp.checkRecipientCell());
        
        System.out.println("Enter Message: ");
        String messageText = input.nextLine();
        
        if (messageText.length() > 250) {
            
            System.out.println(
                    "Message exceeds 250 characters by "
                    + (messageText.length() - 250)
                    + " characters."
            );
            
            continue;
        }
        
        if (messageText.length() > 250) {
            
            System.out.println("Please Enter a Message of Less Than 250 characters."
            );
            
            continue;
        }
            Message msg = 
                    new Message("",
                    i,
                    recipientNumber,
                    messageText);
            
            msg.createMessageID();
            
            System.out.println("""
            1. Send Message
            2. Disregard Message
            3. Store Message To Send Later"""
            );
            
            int action = 
                    Integer.parseInt(input.nextLine());
            
            switch(action) {
                
                case 1:
            
            Message.sentMessages.add(messageText);
            
            Message.recipients.add(recipientNumber);
            
            Message.messageHashes.add(msg.createMessageHash()
            );
            
            System.out.println("Message Successfully Sent."
            );
        
             break;
        
        case 2: 
        
            Message.disregardedMessages.add(messageText);
            
            System.out.println("Press 0 To Delete Message."
            );
            
            int deleteChoice = 
                    Integer.parseInt(input.nextLine());
            
            if (deleteChoice == 0) {
                
               Message.disregardedMessages.add(messageText);
                
               System.out.println("Message Deleted."
               );
        }
            
            break;
            
        case 3:
        
            Message.storedMessages.add(messageText);
            
            System.out.println("Message Successfully Stored."
            );
            
            break;
            
        default: 
        
            System.out.println("Invalid Option."
            );
            }
            
        }
            
        
    case 2:
        if (Message.sentMessages.isEmpty()) {
            
            System.out.println(
                    "No Messages Have Been Sent."
            );
            
        } else {
            
            System.out.println(
                    "\n===== RECENTLY SENT MESSAGES ====="
            );
            
            System.out.println(
                    "Total Messages Sent: "
                    + Message.getTotalMessagesSent()
            );
            
            System.out.println("Stored Messages: "
                    + Message.storedMessages.size()
            );
            
            System.out.println("Disregarded Messages: "
                    + Message.disregardedMessages.size()
            );
            
            for (int i = 0;
                    i < Message.sentMessages.size();
                    i++) {
                
            System.out.println(
                     "\nRecipient: "
                     + Message.recipients.get(i)
                );
            
            System.out.println(
                    "Message: "
                    + Message.sentMessages.get(i)
            );
            
            System.out.println(
                    "Hash: "
                    + Message.messageHashes.get(i)
            );       
            
        }
    }   
        
    break;
        
    case 3:
        System.out.println("Goodbye."); 
                        exit = true;
                        break;
    
    case 4:
        System.out.println("""
    ===== STORED MESSAGES =====

    1. Display Sender and Recipient
    2. Display Longest Message
    3. Search By Message ID
    4. Search By Recipient
    5. Delete By Message Hash
    6. Display Full Report
    """);
    
    int storedChoice = 
            
Integer.parseInt(input.nextLine());
    
    switch (storedChoice)
        
    {
        case 1:
            
    System.out.println(
        "\n===== STORED MESSAGE CONTACTS ====="
);
    
    for (int i = 0;
            i <
            Message.storedMessages.size();
            i++) {
        
        System.out.println("\nSender: Siya Mbele"
        );
        
        System.out.println(
        "Recipient: "
        + Message.recipients.get(i %
                Message.recipients.size()
        )
        );
        
        System.out.println(
                 "Stored Message: "
                +
        Message.storedMessages.get(i)
        );
    }
    
    break;
    
    case 2:

    String longestMessage = "";

    for (String msg : Message.storedMessages) {

        if (msg.length() > longestMessage.length()) {

            longestMessage = msg;
        }
    }

    System.out.println(
            "\n===== LONGEST STORED MESSAGE ====="
    );

    System.out.println(
            longestMessage
    );

    break;
    
    case 3:

    System.out.print(
            "Enter Message ID: "
    );

    String searchID =
            input.nextLine();

    boolean found = false;

    for (int i = 0;
            i < Message.messageIDs.size();
            i++) {

        if (Message.messageIDs.get(i)
                .equals(searchID)) {

            System.out.println(
                    "Message: "
                    + Message.sentMessages.get(i)
            );

            found = true;
        }
    }

    if (!found) {

        System.out.println(
                "Message ID not found."
        );
    }

    break;
    
    case 4:

    System.out.print(
            "Enter Recipient Number: "
    );

    String recipientSearch =
            input.nextLine();

    boolean recipientFound = false;

    for (int i = 0;
            i < Message.recipients.size();
            i++) {

        if (Message.recipients.get(i)
                .equals(recipientSearch)) {

            System.out.println(
                    "Message: "
                    + Message.sentMessages.get(i)
            );

            recipientFound = true;
        }
    }

    if (!recipientFound) {

        System.out.println(
                "No messages found for recipient."
        );
    }

    break;
    
    case 5:

    System.out.print(
            "Enter Message Hash: "
    );

    String hashToDelete =
            input.nextLine();

    boolean deleted = false;

    for (int i = 0;
            i < Message.messageHashes.size();
            i++) {

        if (Message.messageHashes.get(i)
                .equals(hashToDelete)) {

            Message.messageHashes.remove(i);

            if (i < Message.sentMessages.size()) {
                Message.sentMessages.remove(i);
            }

            if (i < Message.recipients.size()) {
                Message.recipients.remove(i);
            }

            System.out.println(
                    "Message deleted successfully."
            );

            deleted = true;

            break;
        }
    }

    if (!deleted) {

        System.out.println(
                "Message hash not found."
        );
    }

    break;
    
    case 6:
        
        System.out.println(
        "\n===== FULL MESSAGE REPORT ======"
        );
        
        for (int i = 0;
                i <
                Message.sentMessages.size(
                );
                i++) {
            System.out.println(
            "\nMessage Hash: "
            +
            Message.messageHashes.get(i)
                    );
            
            System.out.println(
            "Recipient: "
            + Message.recipients.get(i)
            );
            
            System.out.println(
            "Message: "
            +
            Message.sentMessages.get(i)
            );
            
            System.out.println(
            "-------------------------------------------"
            );
        }
        
        break;
                        
    default:
        System.out.println("Invalid Option");
    }
}
   }
   
}

        }
        
    }
    
}
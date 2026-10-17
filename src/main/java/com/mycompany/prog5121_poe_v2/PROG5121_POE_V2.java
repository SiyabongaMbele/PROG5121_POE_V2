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
        
        System.out.println(user.registerUser());
        
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
   boolean exit = false;
   
   while (!exit) {
    
    System.out.println("""
    1. Send Messages
    2. Show Recently Sent Messages
    3. Quit
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
            
            System.out.println("Disregarded Messages:"
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
    
    default:
        System.out.println("Invalid Option");
    }

  }

  }

 }
    
}
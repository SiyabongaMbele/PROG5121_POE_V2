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
    
    System.out.println("""
    1. Send Messages
    2. Show Recently Sent Messages
    3. Quit
    """);

    int choice =
Integer.parseInt(input.nextLine());
    
switch (choice) {
    
    case 1:
        System.out.println("Send Message Selected"); 
        break;
        
    case 2:
        System.out.println("Coming Soon"); 
        break;
        
    case 3:
        System.out.println("Goodbye."); 
        break;
    
    default:
        System.out.println("Invalid Option");
}

}

}

}

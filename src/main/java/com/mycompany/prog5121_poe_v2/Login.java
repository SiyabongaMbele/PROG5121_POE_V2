package com.mycompany.prog5121_poe_v2;

public class Login {
    
    private String username;
    private String storedUsername;
    private String password;
    private String storedPassword;
    private String cellPhoneNumber;
    public String registerUser() {
        
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains at least eight characters, a capital letter, a number and a special character.";
        }
        
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        storedUsername = username;
        storedPassword = password;
        
        return "User has been registered successfully.";
    }
    
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        
        return enteredUsername.equals(storedUsername)
                && enteredPassword.equals(storedPassword);
    }
    
    public String returnLoginStatus(boolean loginSuccess,
            String firstName,
            String lastName) {
        
        if (loginSuccess) {
            return "Welcome " + firstName + " "
                    + lastName
                    + "it is great to see you again.";
        }
        
        return "Username or password incorrect, please try again.";
    }
    
    public Login(String username, String password, String cellPhoneNumber){
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }
    
    public boolean checkUserName(){
        return username.contains("_") && username.length() <= 5;
    }
    
    public boolean checkPasswordComplexity() {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }
    
    public boolean checkCellPhoneNumber(){
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
}
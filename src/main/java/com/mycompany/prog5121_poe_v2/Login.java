package com.mycompany.prog5121_poe_v2;

public class Login {
    
    private String username;
    private String password;
    private String cellPhoneNumber;
    
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
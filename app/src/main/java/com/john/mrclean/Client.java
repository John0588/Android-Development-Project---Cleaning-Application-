package com.john.mrclean;

public class Client {
    public String signUp_FullName, signUp_UserName, signUp_Email, signUp_Password, signUp_PhoneNumber;

    public Client() {

    }
    public Client(String signUp_FullName, String signUp_UserName, String signUp_Email, String signUp_Password, String signUp_PhoneNumber) {
        this.signUp_FullName = signUp_FullName;
        this.signUp_UserName = signUp_UserName;
        this.signUp_Email = signUp_Email;
        this.signUp_Password = signUp_Password;
        this.signUp_PhoneNumber = signUp_PhoneNumber;
    }
}

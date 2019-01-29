package com.example.demo.stmpSend;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthencator extends Authenticator{
    private  String username;
    private String password;
    public MyAuthencator(String usernmae,String password){
        this.username=usernmae;
        this.password=password;
    }
    public PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication(username,password);
    }

}

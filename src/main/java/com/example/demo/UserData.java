package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class UserData {
    public String userName;
    public String passWord;
    public String six;
    public List<UserDDDD> uaer;

    public String ceshi(){
        return "ceshi";
    }public String ceshi1(){
        return "ceshi1";
    }


}


package com.example.mymusicplayer;

public class User {
    private int id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private String gender;

    public User(int id, String userName, String name, String email, String password, String gender){
        this.id = id;
        this.userName = userName;
        this.name =name;
        this.email = email;
        this.gender = gender;
        this.password =  password;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }

    public void setUserName(String user){
        this.userName = user;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String mail){
        this.email = mail;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    //Getters
    public int getId(){
        return this.id;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getGender(){
        return this.gender;
    }
}

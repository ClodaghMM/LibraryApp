package com.example.libraryapp;

public class User {

    public String Name;
    public String Title;
    public String email;

    public User(String name, String title, String email){
        this.Name = name;
        this.Title = title;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

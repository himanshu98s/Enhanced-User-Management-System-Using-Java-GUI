package com.system;

public class RegularUser extends User {

    public RegularUser(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Regular User");
    }
}
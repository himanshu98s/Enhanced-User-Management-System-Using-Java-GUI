package com.system;

public class AdminUser extends User {

    public AdminUser(int id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }
}
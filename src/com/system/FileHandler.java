package com.system;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveToFile(ArrayList<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (User u : users) {
                writer.write(u.getId() + "," + u.getName() + "," + u.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<User> loadFromFile() {
        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new RegularUser(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                ));
            }
        } catch (IOException e) {
            System.out.println("File not found, starting fresh.");
        }

        return users;
    }
}
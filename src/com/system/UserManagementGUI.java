package com.system;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserManagementGUI extends Application {

    UserManager manager = new UserManager();

    TextArea output = new TextArea();

    @Override
    public void start(Stage stage) {

        manager.getUsers().addAll(FileHandler.loadFromFile());

        TextField idField = new TextField();
        idField.setPromptText("Enter ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        Button addBtn = new Button("Add User");
        Button viewBtn = new Button("View Users");
        Button searchBtn = new Button("Search User");
        Button sortNameBtn = new Button("Sort by Name");
        Button sortIdBtn = new Button("Sort by ID");
        Button deleteBtn = new Button("Delete User");
        Button saveBtn = new Button("Save");
        Button exitBtn = new Button("Exit");

        output.setEditable(false);
        output.setPrefHeight(300);



        // ADD USER
        addBtn.setOnAction(e -> {

            try {

                int id =
                        Integer.parseInt(
                                idField.getText()
                        );

                String name =
                        nameField.getText();

                String email =
                        emailField.getText();

                boolean added =
                        manager.addUser(
                                new RegularUser(
                                        id,
                                        name,
                                        email
                                )
                        );

                if(added)
                {
                    showAlert("User added");
                }
                else
                {
                    showAlert("Add failed");
                }

            }

            catch(Exception ex)
            {
                showAlert("Invalid input");
            }

        });



        // VIEW USERS
        viewBtn.setOnAction(e -> {

            output.clear();

            for(User u:
                    manager.getUsers())
            {

                output.appendText(

                        "ID: "
                        +u.getId()

                        +" Name: "
                        +u.getName()

                        +" Email: "
                        +u.getEmail()

                        +"\n"

                );

            }

        });



        // SEARCH
        searchBtn.setOnAction(e -> {

            output.clear();

            String keyword =
                    nameField.getText();

            for(User u:
                    manager.searchUserByName(
                            keyword
                    ))
            {

                output.appendText(

                        u.getName()

                        +"\n"

                );

            }

        });



        // SORT NAME
        sortNameBtn.setOnAction(e -> {

            manager.sortUsersByName();

            viewBtn.fire();

        });



        // SORT ID
        sortIdBtn.setOnAction(e -> {

            manager.sortUsersById();

            viewBtn.fire();

        });



        // DELETE USER
        deleteBtn.setOnAction(e -> {

            try {

                int id =

                        Integer.parseInt(
                                idField.getText()
                        );

                manager.deleteUser(id);

                showAlert(
                        "Deleted"
                );

            }

            catch(Exception ex)
            {

                showAlert(
                        "Delete failed"
                );

            }

        });



        // SAVE
        saveBtn.setOnAction(e -> {

            FileHandler.saveToFile(
                    manager.getUsers()
            );

            showAlert(
                    "Saved"
            );

        });



        // EXIT
        exitBtn.setOnAction(e -> {

            FileHandler.saveToFile(
                    manager.getUsers()
            );

            stage.close();

        });



        VBox root =
                new VBox(
                        10,
                        idField,
                        nameField,
                        emailField,

                        addBtn,
                        viewBtn,
                        searchBtn,

                        sortNameBtn,
                        sortIdBtn,

                        deleteBtn,
                        saveBtn,
                        exitBtn,

                        output
                );


        root.setPadding(
                new Insets(
                        20
                )
        );



        Scene scene =
                new Scene(
                        root,
                        500,
                        700
                );

        stage.setScene(
                scene
        );

        stage.setTitle(
                "User Management System"
        );

        stage.show();

    }




    private void showAlert(
            String msg
    )
    {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setContentText(
                msg
        );

        alert.show();

    }




    public static void main(
            String[] args
    )
    {

        launch();

    }

}
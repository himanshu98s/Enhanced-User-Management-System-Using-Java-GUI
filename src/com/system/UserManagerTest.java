package com.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserManagerTest {

    @Test
    void testAddUser() {

        UserManager manager =
                new UserManager();

        boolean result =

                manager.addUser(

                        new RegularUser(
                                1,
                                "James",
                                "james@gmail.com"
                        )

                );

        assertTrue(result);

    }



    @Test
    void testDeleteUser() {

        UserManager manager =
                new UserManager();

        manager.addUser(

                new RegularUser(
                        1,
                        "Alex",
                        "alex@gmail.com"
                )

        );

        boolean deleted =
                manager.deleteUser(
                        1
                );

        assertTrue(
                deleted
        );

    }



    @Test
    void testSearchUser() {

        UserManager manager =
                new UserManager();

        manager.addUser(

                new RegularUser(
                        1,
                        "Nathan",
                        "nathan@gmail.com"
                )

        );

        int size =

                manager.searchUserByName(
                        "Nathan"
                )

                .size();

        assertEquals(
                1,
                size
        );

    }

}
package com.system;

public class Evaluation {

    public static void evaluateUser(User user, int score) {
        System.out.println("Evaluating " + user.getName());

        if (score > 80) {
            System.out.println("Reward granted.");
        } else if (score < 40) {
            System.out.println("Penalty applied.");
        } else {
            System.out.println("Normal performance.");
        }
    }
}
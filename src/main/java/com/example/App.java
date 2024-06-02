package com.example;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator c = new Calculator();

        while (true) {
            System.out.print("Enter a string: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equals("")) {
                System.exit(0);
            }

            double answer = 0;
            try {
                answer = c.calc(userInput);
                System.out.println(answer);
            } catch (Exception e) {
                System.out.println("Input error; string is incorrect");
            }

        }

    }
}
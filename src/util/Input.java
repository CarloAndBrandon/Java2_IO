package util;

import java.util.Scanner;

//Problem 3
public class Input {

    private Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public Boolean yesNo(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public int getInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int userInput = getInt();
        if (userInput < min || userInput > max) {
            System.out.println("This is an invalid input, please try again.");
            return getInt(prompt, min, max);
        } else {
            return userInput;
        }
    }

    public int getInt(){
        String userInput = scanner.nextLine();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Sorry, you did not enter an integer. Please enter an integer.");
            return getInt();
        }

    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        return getInt();
    }

    public double getDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double userInput = getDouble();
        if (userInput < min || userInput > max) {
            System.out.println("This is an invalid input, please try again.");
            return getDouble(prompt, min, max);
        } else {
            return userInput;
        }
    }

    public double getDouble() {
        String userInput = scanner.nextLine();
        try {
            return Double.valueOf(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Sorry, you did not enter a number or one within the correct range. Please try again.");
            return getDouble();
        }

    }

    public double getDouble(String prompt){
        System.out.println(prompt);
        return getDouble();
    }

//    Bonus 1
    public int getBinary() {
        System.out.println("Enter a Binary number.");
        String userInput = scanner.nextLine();
        try {
            return Integer.valueOf(userInput, 2);
        } catch (NumberFormatException nfe) {
            System.out.println("Sorry, you did not enter a Binary number. Please try again.");
            return getBinary();
        }
    }

//    Bonus 2
    public int getHexidecimal() {
        System.out.println("Enter a Hexidecimal number.");
        String userInput = scanner.nextLine();
        try {
            return Integer.valueOf(userInput, 16);
        } catch (NumberFormatException nfe) {
            System.out.println("Sorry, you did not enter a Hexidecimal number. Please try again.");
            return getHexidecimal();
        }
    }
}
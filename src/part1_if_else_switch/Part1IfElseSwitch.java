package part1_if_else_switch;

import java.util.Scanner;

public class Part1IfElseSwitch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1. Syntax
        System.out.println("=== Part 1. If/else and switch syntax ===");

        // Part 1.1 Relational operators
        System.out.println("\n--- Part 1.1 Relational operators ---");
        int number = readInt(scanner, "Enter an integer number: ");
        int limit = 10;

        if (number == limit) {
            System.out.println(number + " == " + limit);
        }
        if (number != limit) {
            System.out.println(number + " != " + limit);
        }
        if (number > limit) {
            System.out.println(number + " > " + limit);
        }
        if (number < limit) {
            System.out.println(number + " < " + limit);
        }
        if (number >= limit) {
            System.out.println(number + " >= " + limit);
        }
        if (number <= limit) {
            System.out.println(number + " <= " + limit);
        }

        // Part 1.2 Strings comparison with equals()
        System.out.println("\n--- Part 1.2 String.equals() ---");
        System.out.print("Enter the secret word (hint: java): ");
        String word = scanner.nextLine();

        if (word.equals("java")) {
            System.out.println("Correct! The word is java.");
        } else {
            System.out.println("Wrong word :(");
        }

        // == compares references, equals() compares text, so we use equals()
        if (word.equalsIgnoreCase("JAVA")) {
            System.out.println("(ignoring the case it is also java)");
        }

        // Part 1.3 Logical operators
        System.out.println("\n--- Part 1.3 Logical operators ---");
        int age = readInt(scanner, "Enter your age: ");
        System.out.print("Do you have a ticket? (yes/no): ");
        String answer = scanner.nextLine();
        boolean hasTicket = answer.equals("yes");

        // && (and) - both conditions must be true
        if (age >= 18 && hasTicket) {
            System.out.println("You can enter the cinema (adult with a ticket).");
        }

        // || (or) - at least one condition must be true
        if (age < 12 || age > 65) {
            System.out.println("You get a discount (child or senior).");
        }

        // ! (not) - inverts the condition
        if (!hasTicket) {
            System.out.println("You have no ticket, please buy one.");
        }

        // Part 1.4 Conditions with user input
        System.out.println("\n--- Part 1.4 Conditions with user input ---");
        int grade = readInt(scanner, "Enter your exam score (0-100): ");

        if (grade >= 90 && grade <= 100) {
            System.out.println("Grade A");
        } else if (grade >= 75) {
            System.out.println("Grade B");
        } else if (grade >= 60) {
            System.out.println("Grade C");
        } else if (grade >= 0) {
            System.out.println("Grade F, try again next time");
        } else {
            System.out.println("Score can't be negative!");
        }

        // Part 1.5 Nested if/else
        System.out.println("\n--- Part 1.5 Nested if/else ---");
        int year = readInt(scanner, "Enter a year to check if it is a leap year: ");

        if (year > 0) {
            if (year % 4 == 0) {
                if (year % 100 == 0 && year % 400 != 0) {
                    System.out.println(year + " is NOT a leap year (divisible by 100).");
                } else {
                    System.out.println(year + " is a leap year.");
                }
            } else {
                System.out.println(year + " is NOT a leap year.");
            }
        } else {
            System.out.println("Year must be positive.");
        }

        // Part 1.6 Switch
        System.out.println("\n--- Part 1.6 Switch ---");
        int day = readInt(scanner, "Enter a day of the week (1-7): ");

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
            case 7:
                // two cases share one code block
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("There is no such day.");
        }

        // switch also works with strings
        System.out.print("Enter a color (red/green/yellow): ");
        String color = scanner.nextLine();

        switch (color) {
            case "red":
                System.out.println("Stop!");
                break;
            case "yellow":
                System.out.println("Get ready.");
                break;
            case "green":
                System.out.println("Go!");
                break;
            default:
                System.out.println("Unknown color.");
        }

        scanner.close();
    }

    // reads int from console, asks again if user typed not a number
    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("That is not a number, try again.");
            }
        }
    }
}

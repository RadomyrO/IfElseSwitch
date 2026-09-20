package part3_recommender;

import java.util.Scanner;

public class Part3Recommender {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 3. Improved conversation - book recommender
        System.out.println("Hi! I am BookBot and I can recommend you a book to read.");

        // Part 3.1 Input name
        System.out.print("What is your name? ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "friend"; // default name if user typed nothing
        }

        // Part 3.2 Input age
        System.out.print("Nice to meet you, " + name + "! How old are you? ");
        int age = readInt(scanner);

        if (age < 5 || age > 120) {
            System.out.println("Hmm, " + name + ", that age looks strange. Please run me again.");
            scanner.close();
            return;
        }

        // Part 3.3 Input genre
        System.out.println("Which genre do you like the most?");
        System.out.println("(detective, fantasy, sci-fi, non-fiction, romance, horror)");
        System.out.print("Your genre: ");
        String genre = scanner.nextLine().trim().toLowerCase();

        // Part 3.4 Choose a book depending on genre and age
        String book = "";

        switch (genre) {
            case "detective":
                if (age <= 12) {
                    book = "\"The Boxcar Children\" by Gertrude Chandler Warner";
                } else if (age <= 16) {
                    book = "\"The Adventures of Sherlock Holmes\" by Arthur Conan Doyle";
                } else if (age <= 25) {
                    book = "\"And Then There Were None\" by Agatha Christie";
                } else {
                    book = "\"The Girl with the Dragon Tattoo\" by Stieg Larsson";
                }
                break;

            case "fantasy":
                if (age <= 12) {
                    book = "\"Harry Potter and the Philosopher's Stone\" by J.K. Rowling";
                } else if (age <= 16) {
                    book = "\"The Hobbit\" by J.R.R. Tolkien";
                } else if (age <= 25) {
                    book = "\"The Name of the Wind\" by Patrick Rothfuss";
                } else {
                    book = "\"The Lord of the Rings\" by J.R.R. Tolkien";
                }
                break;

            case "sci-fi":
                if (age <= 12) {
                    book = "\"A Wrinkle in Time\" by Madeleine L'Engle";
                } else if (age <= 16) {
                    book = "\"Ender's Game\" by Orson Scott Card";
                } else if (age <= 25) {
                    book = "\"Dune\" by Frank Herbert";
                } else {
                    book = "\"The Three-Body Problem\" by Liu Cixin";
                }
                break;

            case "non-fiction":
                if (age <= 12) {
                    book = "\"Who Was Albert Einstein?\" by Jess Brallier";
                } else if (age <= 16) {
                    book = "\"The Diary of a Young Girl\" by Anne Frank";
                } else if (age <= 25) {
                    book = "\"Sapiens\" by Yuval Noah Harari";
                } else {
                    book = "\"Thinking, Fast and Slow\" by Daniel Kahneman";
                }
                break;

            case "romance":
                if (age <= 12) {
                    book = "\"Anne of Green Gables\" by L.M. Montgomery";
                } else if (age <= 16) {
                    book = "\"The Fault in Our Stars\" by John Green";
                } else if (age <= 25) {
                    book = "\"Pride and Prejudice\" by Jane Austen";
                } else {
                    book = "\"Me Before You\" by Jojo Moyes";
                }
                break;

            case "horror":
                // horror is not for small kids, so nested check here
                if (age <= 12) {
                    System.out.println("Horror is a bit scary for your age, " + name + ". Let's try something softer!");
                    book = "\"Goosebumps: Welcome to Dead House\" by R.L. Stine";
                } else if (age <= 17) {
                    book = "\"Coraline\" by Neil Gaiman";
                } else {
                    book = "\"Dracula\" by Bram Stoker";
                }
                break;

            default:
                // genre not in the list
                System.out.println("I don't know the genre \"" + genre + "\" yet :(");
                if (age <= 16) {
                    book = "\"The Hobbit\" by J.R.R. Tolkien (a good book for everyone)";
                } else {
                    book = "\"1984\" by George Orwell (a good book for everyone)";
                }
        }

        // Part 3.5 Print the recommendation
        System.out.println();
        System.out.println(name + ", I recommend you to read: " + book);
        System.out.println("Happy reading, and see you next time!");

        scanner.close();
    }

    // asks again until user types a number
    private static int readInt(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please type a number, for example 15: ");
            }
        }
    }
}

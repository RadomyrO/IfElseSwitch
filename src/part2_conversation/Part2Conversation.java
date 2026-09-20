package part2_conversation;

import java.util.Scanner;

public class Part2Conversation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 2. Plain conversation (see flowchart in docs/Part2Flowchart.png)
        System.out.println("Hello! I will try to guess what you do during the day :)");

        // Part 2.1 Input age
        System.out.print("How old are you? ");
        int age = readInt(scanner);

        // Part 2.2 Check age and print supposed activity
        if (age < 0 || age > 120) {
            // wrong input branch
            System.out.println("Hmm, I don't think that is a real age. Try to run me again.");
        } else if (age <= 6) {
            System.out.println("You are " + age + ", so I think you stay at home, go for a walk and go to kindergarten.");
        } else if (age <= 17) {
            System.out.println("You are " + age + ", so I think you go to school. Good luck with homework!");
        } else if (age <= 22) {
            System.out.println("You are " + age + ", so I think you study at university. Hope the exams are easy!");
        } else if (age <= 60) {
            System.out.println("You are " + age + ", so I think you have a job. Don't work too much!");
        } else {
            System.out.println("You are " + age + ", so I think you are retired. Enjoy your free time!");
        }

        System.out.println("Thank you for the conversation, bye!");
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

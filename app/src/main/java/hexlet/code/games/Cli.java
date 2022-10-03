package hexlet.code.games;

import java.util.Scanner;

public class Cli {
    public static String greetUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = sc.next();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }
}

package github.benlewis9000.battleText;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean gameLive = true;
        Scanner sc = new Scanner(System.in);

        // User enters name

        System.out.println("\nPlease enter your name:");
        String n = sc.nextLine();

        // Create users Player

        Player p = new Player(n, 20, 20, 2, 1);

        // Print users stats
        p.getStats();

        /*
             Enter Game Loop
         */

        while (gameLive) {

            System.out.println("What would you like to do?");
            System.out.println("  - Battle\n  - Stats\n  - Quit");

            String s = sc.nextLine();

            switch (s.toLowerCase()) {

                case "battle":
                    System.out.println("You have entered a new battle... good luck!");
                    new Battle(p);
                    break;

                case "stats":

                    // Print player stats (maybe inv (potions, weapons) in future)

                    p.getStats();
                    break;

                case "quit":
                    System.out.println("You have left the game...");

                    // End game

                    gameLive = false;
                    break;
            }
        }
    }

}


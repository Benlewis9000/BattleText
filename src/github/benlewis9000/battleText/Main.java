package github.benlewis9000.battleText;

import java.util.Scanner;

import static github.benlewis9000.battleText.Handlers.delay;

public class Main {
    public static void main(String[] args) {

        boolean gameLive = true;
        Scanner sc = new Scanner(System.in);

        // User enters name

        System.out.println("\nPlease enter your name:");
        String n = sc.nextLine();

        // Create users Player

        Player p = new Player(n, 20, 20, 2, 1);

        printInstructions(p);

        p.printStats();

        /*
             Enter Game Loop
         */

        while (gameLive) {

            System.out.println("What would you like to do?");
            System.out.println("  - Battle\n  - Stats\n  - Quit\n");

            String s = sc.nextLine();

            switch (s.toLowerCase()) {

                case "battle":
                    System.out.println("You have entered a new battle... good luck!");
                    new Battle(p);
                    break;

                case "stats":

                    // Print player stats (maybe inv (potions, weapons) in future)

                    p.printStats();
                    break;

                case "quit":
                    System.out.println("You have left the game...");

                    // End game

                    gameLive = false;
                    break;

            }
        }
    }

    public static void printInstructions(Player p){

        delay(500);
        System.out.println("\nWelcome, " + p.getName() + ", to BattleText, " +
                "a\nsimple text based fighting game.");
        delay(4000);
        System.out.println("\nWhen a choice is to be made, a\nlist will appear. Please enter\nthe text exactly as you see to\nmake your choice.");
        delay(6000);
        System.out.println("\nThe game will now begin.");
        delay(2000);
        System.out.println("Good luck!");
        delay(2000);

    }

}


package github.benlewis9000.battleText;

import github.benlewis9000.battleText.Enemy;
import github.benlewis9000.battleText.Player;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static github.benlewis9000.battleText.Handlers.delay;

public class Battle {

    Enemy e = new Enemy(1);

    /*
          New Battle
     */

    public Battle (Player p) {

        boolean battleLive = true;
        // When false, battle ends. Otherwise, rounds loop.

        while (battleLive){

            //delay(2000);

            // Get enemies difficulty
            int d = e.getDifficulty();

            // Set round counter
            int round = 1;

            boolean roundLive = true;

            while (roundLive) {

                //    Announce round no.
                delay(2000);

                System.out.println("\n#-  Round: " + String.valueOf(round) + " -#");

                /*
                      Player's Turn
                 */

                //    List player options

                delay(1000);

                System.out.println("\nWhat would you like to do?");
                System.out.println("  - Fight");
                System.out.println("  - Potion");
                System.out.println("  - Run");

                //    Get Player input...

                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();

                //    Carry out player command...

                switch (s.toLowerCase()) {
                    case "fight":

                        delay(500);

                        // Attack enemy
                        p.attack(p, e);

                        // Get enemy's health
                        int endHealth = e.getHealth();

                        // Check for enemy death
                        if (endHealth <= 0) {
                            System.out.println("  Well done, you destroyed the enemy!");

                            // End round and fight
                            roundLive = false;
                            battleLive = false;

                        }

                        break;
                    case "potion":
                        System.out.println("You do not have any potions!");
                        continue;
                        // Find a way to offer option to choose again without killing loop.
                        // Perhaps enter a new loop object? this:
                        // Have choice in another loop seperate to round, seperate to battle?

                    case "run":
                        leaveBattle(p);
                        roundLive = false;
                        battleLive = false;
                        break;
                }

                // If the player leaves, exit BEFORE the enemy can attack
                // Checks to see if battleLive is false, if so, break;
                if (!(battleLive)) break;

                /*
                      Enemy's Turn
                 */

                // Enemy attacks player

                delay(1000);

                e.attack(p, e);

                int endHealth = p.getHealth();

                delay (500);
                // Check for player death. If health = 0, end fight
                if (endHealth <= 0){
                    System.out.println("\nYou have been defeated.\nFight Over: LOSS");
                }
                else {
                    System.out.println("  You have " + endHealth + " remaining.");
                }

                // increment round
                round++;

                // DELAY 2 seconds
                //delay(2000);
            }
        }
    }

    public void leaveBattle(Player p) {
        p.setHealth(p.getMaxHealth());
        System.out.println("You have fled the battle.");
        // Add currency and run penalty? or Lives?
    }

}

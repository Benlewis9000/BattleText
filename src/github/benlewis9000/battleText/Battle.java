package github.benlewis9000.battleText;

import github.benlewis9000.battleText.Enemy;
import github.benlewis9000.battleText.Player;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static github.benlewis9000.battleText.Handlers.delay;

public class Battle {

    Enemy e = new Enemy(1);
    boolean battleLive = true;
    // When false, battle ends. Otherwise, rounds loop.

    /*
          New Battle
     */

    public Battle (Player p) {

        startBattle(p);

    }

    public void startBattle(Player p){
        while (battleLive){

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
                System.out.println("  - Run\n");

                //    Get Player input...

                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();

                //    Carry out player command...

                switch (s.toLowerCase()) {
                    case "fight":

                        delay(500);

                        // Attack enemy
                        p.attack(e);

                        // Get enemy's health
                        //int endHealth = e.getHealth();

                        // Check for enemy death
                        if (e.isDead()) {
                            System.out.println("  Well done, you destroyed the enemy!\nFight Over: WIN");

                            p.incStrength();

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

                    case "stats":
                        p.printStats();
                        continue;

                    case "run":
                        leaveBattle(p);
                        roundLive = false;
                        break;

                    default :
                        System.out.println("ERROR: Command not recognised.");
                        continue;
                }

                // If the player leaves, exit BEFORE the enemy can attack
                // Checks to see if battleLive is false, if so, break;
                if (!(battleLive)) break;

                /*
                      Enemy's Turn
                 */

                // Enemy attacks player

                delay(1000);

                e.attack(p);

                delay (500);

                if (p.isDead()){
                    System.out.println("\nYou have been defeated.\nFight Over: LOSS\n");
                    delay(1000);
                    leaveBattle(p);
                    break;
                }
                else {
                    System.out.println("  You have " + p.getHealth() + " remaining.");
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
        this.battleLive = false;
        // Add currency and run penalty? or Lives?
    }

}

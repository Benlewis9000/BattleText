package github.benlewis9000.battleText;

import java.util.Random;

import static github.benlewis9000.battleText.Handlers.delay;

public class Enemy {

    private int difficulty;
    private int health;


    public Enemy (int difficulty){
        this.setDifficulty(difficulty);
        int health = new Random().nextInt(10) + difficulty * 10;
        this.setHealth(health);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {

        /*
             Difficulty is used as a multiplier for;
             - Health
             - Attack strength
             with the help of random values.
         */

        if (difficulty > 3){
            this.difficulty = 3;
        }
        else if (difficulty < 1) {
            this.difficulty = 1;
        }
        else this.difficulty = difficulty;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack (Player p){

        // Announce Enemy's go
        System.out.println("\nENEMY:");

        int r = new Random().nextInt(2);
        int m = new Random().nextInt(2);
        m++;
        int dmg = r + difficulty*m;

        p.setHealth(p.getHealth() - dmg);

        // DELAY 1 second
        delay(200);
        System.out.println("  Ouch! The enemy dealt '" + dmg + "' dmg.");
    }

    public boolean isDead(){
        if (this.getHealth() <= 0){
            return true;
        }
        else return false;
    }

}

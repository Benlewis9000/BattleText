package me.benLewis.net;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Enemy {

    int difficulty;
    int health;

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

    public Enemy (int difficulty){
        this.setDifficulty(difficulty);
        int h = new Random().nextInt(10) + difficulty * 10;
        // DEBUG System.out.println(String.valueOf(h));
        this.setHealth(h);
    }

    public void attack (Player p, Enemy e){

        // Announce Enemy's go
        System.out.println("\nENEMY:");

        // Throws InterruptedException ? >>
        // TimeUnit.SECONDS.sleep(1);

        int r = new Random().nextInt(4);
        int m = new Random().nextInt(2);
        m++;
        int dmg = r + difficulty*m;

        p.setHealth(p.getHealth() - dmg);
        System.out.println("  Ouch! The enemy dealt '" + dmg + "' dmg.");
    }
}

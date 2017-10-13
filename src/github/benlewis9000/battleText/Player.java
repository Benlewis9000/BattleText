package github.benlewis9000.battleText;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static github.benlewis9000.battleText.Handlers.delay;

public class Player {

    private String name;
    private int health;
    private int maxHealth;
    private int strength;
    private int level;

    public Player (String name, int health, int maxHealth, int strength, int level){
        this.setName(name);

        // Initialise maxHealth before health
        this.setMaxHealth(maxHealth);
        this.setHealth(health);

        this.setStrength(strength);
        this.setLevel(level);
    }

    /*
          Name
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
          Health
     */

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > this.getMaxHealth()) {
            this.health = this.getMaxHealth();
            System.out.println("// Health set to maxHealth " + this.getMaxHealth() + " //");
        }
        else this.health = health;

       // DEBUG System.out.println(this.getName() + "'s Health is now " + this.getHealth());
    }

    /*
          Max Health
     */

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /*
          Strength
     */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength > 10){
            this.strength = 10;
            System.out.println("// Strength maxed, set to 10 //");
        }
        else {
            this.strength = strength;
        }

        // DEBUG System.out.println(this.getName() + "'s Strength is now " + this.getStrength());
    }

    /*
          Level
     */

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /*          Player            */


    public void printStats (){
        String nme = this.getName();

        int hth = this.getHealth();
        int str = this.getStrength();
        int lvl = this.getLevel();

        System.out.println("\n-*#   " + nme + "'s Stats   #*-");
        System.out.println("    Health: " + String.valueOf(hth));
        System.out.println("    Strength: " + String.valueOf(str));
        System.out.println("    Level: " + String.valueOf(lvl));
        System.out.println("#*-------------------*#\n");

    }

    public void attack(Enemy enemy){

        // Announce Player's go
        System.out.println(this.getName().toUpperCase() + ":");

        // Randomiser to see if attack hits
        int r = new Random().nextInt(14);
        int chance = r - enemy.getDifficulty();

        if (!(chance <= 1)) {

            int ranDmg = new Random().nextInt(3);
            int dmg = this.getStrength() + ranDmg - 1;

            // Hit
            enemy.setHealth(enemy.getHealth() - dmg);

            delay(500);
            System.out.println("  HIT!");
            delay(500);
            System.out.println("  You have dealt " + dmg + " dmg.");
            delay(500);
            System.out.println("  Enemy's health is now at " + enemy.getHealth() + ".");

        } else {

            // Miss

            delay(500);

            System.out.println("  Miss...");

            delay(500);

            System.out.println("  Enemy's health remains at " + enemy.getHealth() + ".");
        }
    }

    public void incStrength(){
        this.setStrength(this.getStrength()+1);

        delay(500);
        System.out.println("\nYour strength has increased!\nNew Strength: " + this.getStrength());
    }

    public void levelUp(){
        int newLvl = this.getLevel() + 1;
        System.out.println("\n" + this.getName() + " has levelled up!\nNew level: " + newLvl);
        this.setLevel(newLvl);
    }

    public boolean isDead(){
        if (this.getHealth() <= 0){
            return true;
        }
        else return false;
    }
}

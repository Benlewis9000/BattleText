package github.benlewis9000.battleText;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static github.benlewis9000.battleText.Handlers.delay;

public class Player {

    String name;
    int health;
    int maxHealth;
    int strength;
    int level;

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

    public Player (String name, int health, int maxHealth, int strength, int level){
        this.setName(name);

        // Initialise maxHealth before health
        this.setMaxHealth(maxHealth);
        this.setHealth(health);

        this.setStrength(strength);
        this.setLevel(level);
    }


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

    public void levelUp(){
        int newLvl = this.getLevel() + 1;
        System.out.println("\n" + this.getName() + " has levelled up!\nNew level: " + newLvl);
        this.setLevel(newLvl);
    }

    public void attack(Player p, Enemy e){

        // Announce Player's go
        System.out.println(p.getName().toUpperCase() + ":");

        // Randomiser to see if attack hits
        int r = new Random().nextInt(14);
        int chance = r - e.getDifficulty();

        if (!(chance <= 1)) {

            int ranDmg = new Random().nextInt(3);
            int dmg = p.getStrength() + ranDmg - 1;

            // Hit
            e.setHealth(e.getHealth() - dmg);

            delay(500);
            System.out.println("  HIT!");
            delay(500);
            System.out.println("  You have dealt " + dmg + " dmg.");
            delay(500);
            System.out.println("  Enemy's health is now at " + e.getHealth() + ".");

        } else {

            // Miss

            delay(500);

            System.out.println("  Miss...");

            delay(500);

            System.out.println("  Enemy's health remains at " + e.getHealth() + ".");
        }
    }

    public void incStrength(Player p){
        p.setStrength(p.getStrength()+1);

        delay(500);
        System.out.println("\nYour strength has increased!\nNew Strength: " + p.getStrength());

    }
}

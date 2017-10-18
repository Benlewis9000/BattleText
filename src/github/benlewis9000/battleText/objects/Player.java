package github.benlewis9000.battleText.objects;

import java.util.Random;

import static github.benlewis9000.battleText.util.Handlers.delay;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int strength;
    private int level;

    /**
     * @param name The name the player will be referred to as.
     * @param health The starting health of the player.
     * @param maxHealth The limit for the players health.
     * @param strength Modifier that affects players attack damage, increments after each win.
     * @param level WIP
     */
    public Player (String name, int health, int maxHealth, int strength, int level){
    	this.name = name;
    	this.health = health;
    	this.maxHealth = maxHealth;
    	this.strength = strength;
    	this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
            System.out.println("// Health set to maxHealth " + maxHealth + " //");
        } else {
            this.health = health;
        }

       // DEBUG System.out.println(this.getName() + "'s Health is now " + this.getHealth());
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength > 10){
            this.strength = 10;
            System.out.println("// Strength maxed, set to 10 //");
        } else {
            this.strength = strength;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void printStats (){
        String nme = this.getName();

        int hp = this.getHealth();
        int str = this.getStrength();
        int lvl = this.getLevel();

        System.out.println("\n-*#   " + nme + "'s Stats   #*-");
        System.out.println("    Health: " + String.valueOf(hp));
        System.out.println("    Strength: " + String.valueOf(str));
        System.out.println("    Level: " + String.valueOf(lvl));
        System.out.println("#*-------------------*#\n");

    }

    public void attack(Enemy enemy){
        System.out.println(this.getName().toUpperCase() + ":");

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
        strength++;

        delay(500);
        System.out.println("\nYour strength has increased!\nNew Strength: " + this.getStrength());
    }

    public void levelUp(){
        level++;
        System.out.println("\n" + this.getName() + " has levelled up!\nNew level: " + level);
    }

    public boolean isDead(){
        return health < 0;
    }
}

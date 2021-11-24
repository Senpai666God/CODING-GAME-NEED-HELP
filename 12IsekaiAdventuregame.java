
package isekaiadventuregame;
import java.util.Scanner;
import java.util.Random;
public class IsekaiAdventuregame {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
       
        // Game variables
        String[] enemies = { "Demon king's son", "Demon King", "Satella", "Your inner demon" };
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;
       
        //Player variables
        int health = 125;
        int attackDamage = 45;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // Percentage
       
        boolean running = true;
       
        System.out.println("welcome to Isekai anime world");
       
        GAME:
        while(running) {
            System.out.println("---------------------------------------------------");
           
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies [rand.nextInt(enemies.length)];
            System.out.println("\t#  " + enemy + " has appeared! #\n");
           
            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
               
                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                   
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken +  " in retaliation!");
                   
                    if(health < 1) {
                        System.out.println("\t You have taken too much damage, you are an Isekai Failure!");
                        break;
                    }
                }
                else if (input.equals("2")) {
                    if(numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health Potion, healing yourself for " + healthPotionHealAmount + "."
                                        + "\n\t> You now have " + health + " HP "
                                        + "\n\t> You have  " + numHealthPotions + " health potions left. \n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left! Defeat the enemy for a chance at one!\n");
                    }
                }
                else if (input.equals("3")) {
                    System.out.println("\t You run away from the " + enemy + "!");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid Command!");
                }
            }
           
            if(health < 1)
                System.out.println("You have returned to the real world as a Isekai failure.");
                break;
           
        }
       
        System.out.println("------------------------------------------------");
        System.out.println(" # " + enemies + " was defeated # ");
        System.out.println(" # You have " + health + " HP left. #");
        if(rand.nextInt(100) < healthPotionDropChance) {
            numHealthPotions++;
            System.out.println(" # The " + enemies + " dropped a health potion! # ");
            System.out.println(" # You now have " + numHealthPotions + " health Potion(s). # ");
        }
        System.out.println("------------------------------------------------");
        System.out.println("what would you like to do now?");
        System.out.println("1. Continue Fighting");
        System.out.println("2. Flee from Isekai World");
       
        String input = in.nextLine();
       
        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
       
        if(input.equals("1")) {
            System.out.println ("You continue on as an isekai fighter!");
        
        }
        else if(input.equals("2")) {
            System.out.println("You wake back up in your bed... was that truly an Isekai adventure???");
            
        }
       
        System.out.println(" # THANKS FOR BEING AN ISEKAI CHARACTER HERE!!! # ");

    }
}
    
   


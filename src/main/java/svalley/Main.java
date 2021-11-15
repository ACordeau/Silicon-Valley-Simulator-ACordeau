package main.java.svalley;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        start();
    }

    /**
     * Starting point of the game.
     * @return boolean true if game completes.
     */
    public static boolean start() {
        // System.out.println("Hello World!");

        int random;
        TechGiantFactory tgf = new TechGiantFactory();
        
        TechGiant tg1 = null;
        random = randomTechGiantNumber();
        tg1 = tgf.randomTechGiant(random);
        
        TechGiant tg2 = null;
        do {
            random = randomTechGiantNumber();
            tg2 = tgf.randomTechGiant(random);
        } while (tg1.getName().equals(tg2.getName()));
        
        tg1.initialStartup();
        tg2.initialStartup();

        return true;
    }
    
    /**
     * Code encapsulation for creating a random number
     * when creating tech giants.
     * @return random int between 1 and 4.
     */
    public static int randomTechGiantNumber() {
        
        Random rand = new Random();
        int random;
        random = rand.nextInt(4 - 1 + 1) + 1;
        return random;
    }

}

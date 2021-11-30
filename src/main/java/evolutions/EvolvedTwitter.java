/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Startup;
import main.java.startups.Twitter;

public class EvolvedTwitter extends Twitter {

    /**
     * Decorator for Twitter.
     * @param startup Twitter.
     */
    public EvolvedTwitter(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Twitter Hyper");
        System.out.println("STARTUP TWITTER HAS EVOLVED INTO TWITTER HYPER!");
    }
    
}

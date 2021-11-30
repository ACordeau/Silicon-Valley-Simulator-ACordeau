/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Startup;
import main.java.startups.YouTube;

public class EvolvedYouTube extends YouTube {

    /**
     * Decorator for YouTube.
     * @param startup YouTube.
     */
    public EvolvedYouTube(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("YouTube Red");
        System.out.println("STARTUP YOUTUBE HAS EVOLVED INTO YOUTUBE RED!");
    }
    
}

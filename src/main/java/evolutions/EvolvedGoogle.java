/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Google;
import main.java.startups.Startup;

public class EvolvedGoogle extends Google {

    /**
     * Decorator for Google.
     * @param startup Google.
     */
    public EvolvedGoogle(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Google Plus");
        System.out.println("STARTUP GOOGLE HAS EVOLVED INTO GOOGLE PLUS!");
    }
    
}

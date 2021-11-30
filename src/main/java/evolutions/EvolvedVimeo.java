/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Startup;
import main.java.startups.Vimeo;

public class EvolvedVimeo extends Vimeo {

    /**
     * Decorator for Vimeo.
     * @param startup Vimeo.
     */
    public EvolvedVimeo(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Mega Vimeo");
        System.out.println("STARTUP VIMEO HAS EVOLVED INTO MEGA VIMEO!");
    }
    
}

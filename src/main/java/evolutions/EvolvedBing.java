/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Bing;
import main.java.startups.Startup;

public class EvolvedBing extends Bing {

    /**
     * Decorator for Bing.
     * @param startup Bing.
     */
    public EvolvedBing(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Bing Plus");
        System.out.println("STARTUP BING HAS EVOLVED INTO BING PLUS!");
    }

}

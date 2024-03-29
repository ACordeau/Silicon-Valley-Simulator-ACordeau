/**
 * This file uses the decorator pattern to
 * evolve a startup. This is for requirement 11.
 */

package main.java.evolutions;

import main.java.startups.Startup;
import main.java.startups.TikTok;

public class EvolvedTikTok extends TikTok {

    /**
     * Decorator for TikTok.
     * @param startup TikTok.
     */
    public EvolvedTikTok(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("TikTok Plus");
        System.out.println("STARTUP TIKTOK HAS EVOLVED INTO TIKTOK PLUS!");
    }
    
}

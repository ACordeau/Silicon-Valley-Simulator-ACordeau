package main.java.evolutions;

import main.java.startups.Snapchat;
import main.java.startups.Startup;

public class EvolvedSnapchat extends Snapchat {

    /**
     * Decorator for Snapchat.
     * @param startup Snapchat.
     */
    public EvolvedSnapchat(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Super Snapchat");
        System.out.println("STARTUP SNAPCHAT HAS EVOLVED INTO SUPER SNAPCHAT!");
    }
    
}

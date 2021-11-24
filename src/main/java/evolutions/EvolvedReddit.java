package main.java.evolutions;

import main.java.startups.Reddit;
import main.java.startups.Startup;

public class EvolvedReddit extends Reddit {

    public EvolvedReddit(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Reddit Enhanced");
        System.out.println("STARTUP REDDIT HAS EVOLVED INTO REDDIT ENHANCED!");
    }
    
}

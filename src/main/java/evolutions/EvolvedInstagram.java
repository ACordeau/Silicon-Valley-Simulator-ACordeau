package main.java.evolutions;

import main.java.startups.Instagram;
import main.java.startups.Startup;

public class EvolvedInstagram extends Instagram {

    public EvolvedInstagram(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Super Instagram");
        System.out.println("STARTUP INSTAGRAM HAS EVOLVED INTO SUPER INSTAGRAM!");
    }
    
}

package main.java.evolutions;

import main.java.startups.Facebook;
import main.java.startups.Startup;

public class EvolvedFacebook extends Facebook {

    public EvolvedFacebook(Startup startup) {
        //super();
        super.setLevel(startup.getLevel());
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Facebook Blue");
        System.out.println("STARTUP FACEBOOK HAS EVOLVED INTO FACEBOOK BLUE!");
    }
    
}

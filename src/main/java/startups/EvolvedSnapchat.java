package main.java.startups;

public class EvolvedSnapchat extends Snapchat {

    public EvolvedSnapchat(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Super Snapchat");
        System.out.println("STARTUP SNAPCHAT HAS EVOLVED INTO SUPER SNAPCHAT!");
    }
    
}

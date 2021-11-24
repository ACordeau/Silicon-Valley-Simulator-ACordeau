package main.java.startups;

public class EvolvedReddit extends Reddit {

    public EvolvedReddit(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Reddit Enhanced");
        System.out.println("STARTUP REDDIT HAS EVOLVED INTO REDDIT ENHANCED!");
    }
    
}

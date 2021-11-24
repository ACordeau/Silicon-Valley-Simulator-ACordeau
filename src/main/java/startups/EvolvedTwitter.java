package main.java.startups;

public class EvolvedTwitter extends Twitter {

    public EvolvedTwitter(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Twitter Hyper");
        System.out.println("STARTUP TWITTER HAS EVOLVED INTO TWITTER HYPER!");
    }
    
}

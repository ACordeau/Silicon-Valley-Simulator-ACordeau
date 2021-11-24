package main.java.startups;

public class EvolvedGoogle extends Google {

    public EvolvedGoogle(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Google Plus");
        System.out.println("STARTUP GOOGLE HAS EVOLVED INTO GOOGLE PLUS!");
    }
    
}

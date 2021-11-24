package main.java.startups;

public class EvolvedBing extends Bing {

    public EvolvedBing(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Bing Plus");
        System.out.println("STARTUP BING HAS EVOLVED INTO BING PLUS!");
    }

}

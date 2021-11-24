package main.java.startups;

public class EvolvedVimeo extends Vimeo {

    public EvolvedVimeo(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("Mega Vimeo");
        System.out.println("STARTUP VIMEO HAS EVOLVED INTO MEGA VIMEO!");
    }
    
}

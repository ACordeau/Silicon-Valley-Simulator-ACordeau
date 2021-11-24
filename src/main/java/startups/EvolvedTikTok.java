package main.java.startups;

public class EvolvedTikTok extends TikTok {

    public EvolvedTikTok(Startup startup) {
        super();
        super.setHealth(startup.getHealth() + 100);
        super.setCurrentHealth(startup.getHealth());
        super.setAttack(startup.getAttack() + 10);
        super.setDefense(startup.getDefense() + 10);
        super.setIsEvolved(true);
        super.setName("TikTok Plus");
        System.out.println("STARTUP TIKTOK HAS EVOLVED INTO TIKTOK PLUS!");
    }
    
}

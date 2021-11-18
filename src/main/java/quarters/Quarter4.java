package main.java.quarters;

import main.java.gameplay.Gameplay;
import main.java.techgiants.TechGiant;

public class Quarter4 implements Quarters {

    Gameplay game;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;

    /**
     * Default constructor.
     * 
     * @param newGame current game.
     */
    public Quarter4(Gameplay newGame) {

        game = newGame;

    }

    @Override
    public void setQuarter1() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter2() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter3() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter4() {
        System.out.println("\nStarting Quarter 4");
        System.out.println("MONEY LAUNDERING!");
        System.out.println("BROWSING TECH GIANTS WIN MORE"
                + " MONEY FROM ALL OTHER TECH GIANTS!");
        game.setQuarterState(game.getQuarter4());
        
        setTechGiants();
        
        moneyLaundering(tg1);
        moneyLaundering(tg2);

    }

    @Override
    public void endQuarter() {
        System.out.println("\nEnding Quarter 4");
        System.out.println("MONEY LAUNDERING SCHEME HAS BEEN THWARTED!");
        
        launderingBust(tg1);
        launderingBust(tg2);

    }
    
    private void setTechGiants() {
        tg1 = game.getTechGiant1();
        tg2 = game.getTechGiant2();
    }
    
    private boolean moneyLaundering(TechGiant tg) {
        
        if (!tg.getType().equals("BROWSING")) {
            tg.setIsExtraCut(true);
            return true;
        } else {
            return false;
        }
        
    }
    
    private boolean launderingBust(TechGiant tg) {
        
        tg.setIsExtraCut(false);
        return true;
        
    }

}

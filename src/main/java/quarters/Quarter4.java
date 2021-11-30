/**
 * This file uses the State pattern to
 * create quarters where different effects
 * take place. This is for requirement 9, 4, and 5.
 * This is the Quarter 4 where if a tech giant loses 
 * against a tech giant of type Browser, they lose 
 * more money to them.
 */

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

    //Error message if this is somehow reached.
    @Override
    public void setQuarter1() {
        System.err.println("Error Message");

    }

    //Error message if this is somehow reached.
    @Override
    public void setQuarter2() {
        System.err.println("Error Message");

    }

    //Error message if this is somehow reached.
    @Override
    public void setQuarter3() {
        System.err.println("Error Message");

    }

    //Sets which tech giants are browsers.
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
    
    //Sets extra cut boolean
    private boolean moneyLaundering(TechGiant tg) {
        
        if (!tg.getType().equals("BROWSER")) {
            tg.setIsExtraCut(true);
            return true;
        } else {
            return false;
        }
        
    }
    
    //Sets extra cut boolean
    private boolean launderingBust(TechGiant tg) {
        
        tg.setIsExtraCut(false);
        return true;
        
    }

}

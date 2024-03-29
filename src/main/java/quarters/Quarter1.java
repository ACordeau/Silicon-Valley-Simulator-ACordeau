/**
 * This file uses the State pattern to
 * create quarters where different effects
 * take place. This is for requirement 9, 4, and 5.
 * This is the Quarter 1 where all tech giants gain 
 * 25 percent interest for their money.
 */

package main.java.quarters;

import main.java.gameplay.Gameplay;
import main.java.techgiants.TechGiant;

public class Quarter1 implements Quarters {

    private Gameplay game;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    private static final double INTEREST = .25;
    
    /**
     * Default constructor.
     * @param newGame current game.
     */
    public Quarter1(Gameplay newGame) {

        game = newGame;

    }

    //Gives both TechGiants 25 percent increase in money.
    @Override
    public void setQuarter1() {
        System.out.println("\nStarting Quarter 1");
        System.out.println("THIS IS A NEUTRAL QUARTER WHERE ALL TECH GIANTS"
                + " CAN THRIVE EQUALLY.");
        System.out.println("ALL TECH GIANTS GAIN 25% INTEREST!");
        game.setQuarterState(game.getQuarter1());

        setTechGiants();
        
        interest(tg1);
        interest(tg2);

    }

    //Error message in case this is somehow reached.
    @Override
    public void setQuarter2() {
        System.err.println("Error Message");

    }

    @Override
    public void setQuarter3() {
        System.err.println("Error Message");

    }

    @Override
    public void setQuarter4() {
        System.err.println("Error Message");

    }

    @Override
    public void endQuarter() {
        System.out.println("\nEnding Quarter 1");
    }
    
    private void setTechGiants() {
        tg1 = game.getTechGiant1();
        tg2 = game.getTechGiant2();
    }
    
    private void interest(TechGiant tg) {
        
        tg.setMoney((int)(tg.getMoney() + (tg.getMoney() * INTEREST)));
        
    }

}

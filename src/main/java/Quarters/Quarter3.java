package main.java.Quarters;

import main.java.Gameplay.Gameplay;

public class Quarter3 implements Quarters {

    Gameplay game;

    /**
     * Default constructor.
     * @param newGame current game.
     */
    public Quarter3(Gameplay newGame) {

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
        System.out.println("\nStarting Quarter 3");
        game.setQuarterState(game.getQuarter3());

    }

    @Override
    public void setQuarter4() {
        System.out.println("Error Message");

    }

    @Override
    public void endQuarter() {
        // TODO Auto-generated method stub
        
    }

}

package main.java.Quarters;

import main.java.Gameplay.Gameplay;

public class Quarter4 implements Quarters{
    
    Gameplay game;

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
        game.setQuarterState(game.getQuarter4());

    }

    @Override
    public void endQuarter() {
        // TODO Auto-generated method stub
        
    }

}

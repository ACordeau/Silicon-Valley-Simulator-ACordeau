package main.java.svalley;

public class Quarter1 implements Quarters {

    private Gameplay game;
    
    public Quarter1(Gameplay newGame) {

        game = newGame;

    }

    @Override
    public void setQuarter1() {
        System.out.println("\nStarting Quarter 1");
        game.setQuarterState(game.getQuarter1());


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
        System.out.println("Error Message");

    }

    @Override
    public void endQuarter() {
        
    }

}

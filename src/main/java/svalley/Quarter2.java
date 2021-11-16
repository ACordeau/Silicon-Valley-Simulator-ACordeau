package main.java.svalley;

public class Quarter2 implements Quarters {

    Gameplay game;

    public Quarter2(Gameplay newGame) {

        game = newGame;

    }

    @Override
    public void setQuarter1() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter2() {
        System.out.println("\nStarting Quarter 2");
        game.setQuarterState(game.getQuarter2());
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
    public void undo() {
        // TODO Auto-generated method stub
        
    }

}

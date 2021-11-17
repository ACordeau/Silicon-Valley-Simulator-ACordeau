package main.java.quarters;

import main.java.gameplay.Gameplay;
import main.java.techgiants.TechGiant;

public class Quarter3 implements Quarters {

    Gameplay game;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    private static final double PERCENTAGE_CUT = .25;
    private static final String VIDSHARE = "VIDEO SHARING";
    private static final String IMGSHARE = "IMAGE SHARING";

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
        System.out.println("WE ARE ENTERING A FINANCIAL IMBALANCE IN CERTAIN AREAS!");
        System.out.println("VIDEO SHARING NET INCOME IS UP BY 25%");
        System.out.println("IMAGE SHARING NET INCOME IS DOWN BY 25%");
        game.setQuarterState(game.getQuarter3());
        
        setTechGiants();
        
        financialImbalance(tg1);
        financialImbalance(tg2);

    }

    @Override
    public void setQuarter4() {
        System.out.println("Error Message");

    }

    @Override
    public void endQuarter() {
        System.out.println("\nEnding Quarter 3");
        System.out.println("FINANCIAL REBALANCING IN PROGRESS!");
        financialRebalance(tg1);
        financialRebalance(tg2);
        
    }
    
    private void setTechGiants() {
        tg1 = game.getTechGiant1();
        tg2 = game.getTechGiant2();
    }
    
    private boolean financialImbalance(TechGiant tg) {
        int currAtk;
        int newAtk;
        if (tg.getStartups().size() == 0) {
            return false;
        }
        
        for (int i = 0; i < tg.getStartups().size(); i++) {
            if (tg.getStartups().get(i).getType().equals(VIDSHARE)) {
                currAtk = tg.getStartups().get(i).getAttack();
                newAtk = (int) Math.ceil((currAtk + (currAtk * PERCENTAGE_CUT)));
                tg.getStartups().get(i).setAttack(newAtk);
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getAttack());
            }
            
            if (tg.getStartups().get(i).getType().equals(IMGSHARE)) {
                currAtk = tg.getStartups().get(i).getAttack();
                newAtk = (int) Math.floor((currAtk - (currAtk * PERCENTAGE_CUT)));
                tg.getStartups().get(i).setAttack(newAtk);
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getAttack());
            }
        }
        
        return true;
    }
    
    private boolean financialRebalance(TechGiant tg) {
        int currAtk;
        int newAtk;
        if (tg.getStartups().size() == 0) {
            return false;
        }
        
        for (int i = 0; i < tg.getStartups().size(); i++) {
            if (tg.getStartups().get(i).getType().equals(IMGSHARE)) {
                currAtk = tg.getStartups().get(i).getAttack();
                newAtk = (int) Math.ceil((currAtk + (currAtk * PERCENTAGE_CUT)));
                tg.getStartups().get(i).setAttack(newAtk);
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getAttack());
            }
            
            if (tg.getStartups().get(i).getType().equals(VIDSHARE)) {
                currAtk = tg.getStartups().get(i).getAttack();
                newAtk = (int) Math.floor((currAtk - (currAtk * PERCENTAGE_CUT)));
                tg.getStartups().get(i).setAttack(newAtk);
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getAttack());
            }
        }
        
        return true;
    }

}

/**
 * This file uses the State pattern to
 * create quarters where different effects
 * take place. This is for requirement 9, 4, and 5.
 * This is the Quarter 2 where a random type is chosen
 * and all Startups of that type lose 
 * 10 percent of their health.
 */

package main.java.quarters;

import java.util.Random;

import main.java.gameplay.Gameplay;
import main.java.techgiants.TechGiant;

public class Quarter2 implements Quarters {

    Gameplay game;
    String type;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    private static final double PERCENTAGE_CUT = .1;

    /**
     * Default constructor.
     * @param newGame current game.
     */
    public Quarter2(Gameplay newGame) {

        game = newGame;

    }

    //Error message if this is somehow reached.
    @Override
    public void setQuarter1() {
        System.err.println("Error Message");

    }

    //Makes the Startups lose their HP.
    @Override
    public void setQuarter2() {
        this.type = randomType();
        System.out.println("\nStarting Quarter 2: Market Crash");
        System.out.println("STARTUPS OF TYPE " + type + " LOSE 10% OF THEIR "
                + "MAX REVENUE!");
        game.setQuarterState(game.getQuarter2());

        setTechGiants();
        int lostHp = 0;
        int startHp = 0;
        int currentHp = 0;
        String startupType = "";

        executeCuts(tg1, startHp, currentHp, lostHp, startupType);
        executeCuts(tg2, startHp, currentHp, lostHp, startupType);

    }

    //Error message if this is somehow reached.
    @Override
    public void setQuarter3() {
        System.err.println("Error Message");

    }

    //Error message if this is somehow reached.
    @Override
    public void setQuarter4() {
        System.err.println("Error Message");

    }

    @Override
    public void endQuarter() {

        System.out.println("\nEnding Quarter 2");
        System.out.println("All REVENUE LOST DURING THE MARKET CRASH IS RETURNED BY INVESTORS!");

        setTechGiants();
        int gainHp = 0;
        int startHp = 0;
        int currentHp = 0;
        String startupType = "";

        regainCuts(tg1, startHp, currentHp, gainHp, startupType);
        regainCuts(tg2, startHp, currentHp, gainHp, startupType);

    }

    //Chooses a random type.
    private String randomType() {
        String type;
        String[] types = { "IMAGE SHARING", "VIDEO SHARING", "BROWSER", "SOCIAL MEDIA" };
        Random random = new Random();
        int rand;
        rand = random.nextInt(4);
        type = types[rand];
        return type;
    }

    private void setTechGiants() {
        tg1 = game.getTechGiant1();
        tg2 = game.getTechGiant2();
    }

    //Algorithm for HP loss.
    private void executeCuts(TechGiant tg, int startHp, 
            int currentHp, int lostHp, String startupType) {

        for (int i = 0; i < tg.getStartups().size(); i++) {

            startHp = tg.getStartups().get(i).getHealth();
            currentHp = tg.getStartups().get(i).getCurrentHealth();
            startupType = tg.getStartups().get(i).getType();

            if (startupType.equals(this.type)) {
                lostHp = (int) (startHp - (startHp * PERCENTAGE_CUT));
                
                if (currentHp < lostHp) {
                    tg.getStartups().get(i).setCurrentHealth(1);
                } else {
                    tg.getStartups().get(i).setCurrentHealth(lostHp);
                }
                
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

    //Regain HP after the quarter is over.
    private void regainCuts(TechGiant tg, int startHp, 
            int currentHp, int gainHp, String startupType) {

        for (int i = 0; i < tg.getStartups().size(); i++) {
            startHp = tg.getStartups().get(i).getHealth();
            currentHp = tg.getStartups().get(i).getCurrentHealth();
            startupType = tg.getStartups().get(i).getType();

            if (startupType.equals(this.type)) {
                gainHp = (int) (startHp - (startHp * PERCENTAGE_CUT));
                if ((currentHp + gainHp) > startHp) {
                    tg.getStartups().get(i).setCurrentHealth(startHp);
                } else {
                    tg.getStartups().get(i).setCurrentHealth(currentHp + gainHp);
                }
                //System.out.println(tg.getStartups().get(i).getName() 
                //        + " " + tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

}

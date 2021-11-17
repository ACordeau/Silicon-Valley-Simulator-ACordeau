package main.java.quarters;

import java.util.Random;

import main.java.gameplay.Gameplay;
import main.java.techgiants.TechGiant;

public class Quarter2 implements Quarters {

    Gameplay game;
    String type;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    private static final double PERCENTAGE_CUT = .5;

    /**
     * Default constructor.
     * @param newGame current game.
     */
    public Quarter2(Gameplay newGame) {

        game = newGame;

    }

    @Override
    public void setQuarter1() {
        System.out.println("Error Message");

    }

    @Override
    public void setQuarter2() {
        this.type = randomType();
        System.out.println("\nStarting Quarter 2: Market Crash");
        System.out.println("STARTUPS OF TYPE " + type + " LOSE 50% REVENUE!");
        game.setQuarterState(game.getQuarter2());

        setTechGiants();
        int lostHp = 0;
        int startHp = 0;
        String startupType = "";

        executeCuts(tg1, startHp, lostHp, startupType);
        executeCuts(tg2, startHp, lostHp, startupType);

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

    private String randomType() {
        String type;
        String[] types = { "IMAGE SHARING", "VIDEO SHARING", "BROWSING", "SOCIAL MEDIA" };
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

    private void executeCuts(TechGiant tg, int startHp, int lostHp, String startupType) {

        for (int i = 0; i < tg.getStartups().size(); i++) {

            startHp = tg.getStartups().get(i).getHealth();
            startupType = tg.getStartups().get(i).getType();

            if (startupType.equals(this.type)) {
                lostHp = (int) (startHp * PERCENTAGE_CUT);
                tg.getStartups().get(i).setCurrentHealth(lostHp);
                System.out.println(tg.getStartups().get(i).getName() 
                        + " " + tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

    private void regainCuts(TechGiant tg, int startHp, 
            int currentHp, int gainHp, String startupType) {

        for (int i = 0; i < tg.getStartups().size(); i++) {
            startHp = tg.getStartups().get(i).getHealth();
            currentHp = tg.getStartups().get(i).getCurrentHealth();
            startupType = tg.getStartups().get(i).getType();

            if (startupType.equals(this.type)) {
                gainHp = (int) (startHp * .5);
                tg.getStartups().get(i).setCurrentHealth(currentHp + gainHp);
                System.out.println(tg.getStartups().get(i).getName() 
                        + " " + tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

}

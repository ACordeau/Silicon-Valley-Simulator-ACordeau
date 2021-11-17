package main.java.Quarters;

import java.util.Random;

import main.java.Gameplay.Gameplay;
import main.java.TechGiants.TechGiant;

public class Quarter2 implements Quarters {

    Gameplay game;
    String type;
    private TechGiant tg1 = null;
    private TechGiant tg2 = null;
    private static final double PERCENTAGE_CUT = .5;

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
        String type = "";

        executeCuts(tg1, startHp, lostHp, type);
        executeCuts(tg2, startHp, lostHp, type);

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
        String type = "";

        regainCuts(tg1, startHp, currentHp, gainHp, type);
        regainCuts(tg2, startHp, currentHp, gainHp, type);

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

    private void executeCuts(TechGiant tg, int startHp, int lostHp, String type) {

        for (int i = 0; i < tg.getStartups().size(); i++) {

            startHp = tg.getStartups().get(i).getHealth();
            type = tg.getStartups().get(i).getType();

            if (type.equals(this.type)) {
                lostHp = (int) (startHp * PERCENTAGE_CUT);
                tg.getStartups().get(i).setCurrentHealth(lostHp);
                // System.out.println(tg.getStartups().get(i).getName() + " " +
                // tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

    private void regainCuts(TechGiant tg, int startHp, int currentHp, int gainHp, String type) {

        for (int i = 0; i < tg.getStartups().size(); i++) {
            startHp = tg.getStartups().get(i).getHealth();
            currentHp = tg.getStartups().get(i).getCurrentHealth();
            type = tg.getStartups().get(i).getType();

            if (type.equals(this.type)) {
                gainHp = (int) (startHp * .5);
                tg.getStartups().get(i).setCurrentHealth(currentHp + gainHp);
                // System.out.println(tg.getStartups().get(i).getName() + " " +
                // tg.getStartups().get(i).getCurrentHealth());
            }
        }

    }

}

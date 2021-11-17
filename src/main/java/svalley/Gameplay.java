package main.java.svalley;

import java.util.Random;

public class Gameplay {

    private Quarters q1;
    private Quarters q2;
    private Quarters q3;
    private Quarters q4;

    private Quarters currentQ;
    
    private TechGiantFactory tgf = new TechGiantFactory();

    private TechGiant tg1 = null;
    private TechGiant tg2 = null;

    /**
     * Starting point of the game.
     * 
     * @return boolean true if game completes.
     */
    public boolean start() {

        int random;
        
        random = randomTechGiantNumber();
        tg1 = tgf.randomTechGiant(random);
        
        do {
            random = randomTechGiantNumber();
            tg2 = tgf.randomTechGiant(random);
        } while (tg1.getName().equals(tg2.getName()));

        tg1.initialStartup();
        tg2.initialStartup();

        q1 = new Quarter1(this);
        q2 = new Quarter2(this);
        q3 = new Quarter3(this);
        q4 = new Quarter4(this);

        int count = 0;

        do {
            if (currentQ == null) {
                currentQ = q1;
                currentQ.setQuarter1();
                count++;
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter1) {
                currentQ = q2;
                currentQ.setQuarter2();
                count++;
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter2) {
                currentQ = q3;
                currentQ.setQuarter3();
                count++;
            } else if (currentQ instanceof Quarter3) {
                currentQ = q4;
                currentQ.setQuarter4();
                count++;
            } else {
                currentQ = q1;
                currentQ.setQuarter1();
                count++;
            }

        } while (count != 4/*!gameOver(tg1, tg2)*/);

        return true;
    }

    /**
     * Code encapsulation for creating a random number when creating tech giants.
     * 
     * @return random int between 1 and 4.
     */
    public static int randomTechGiantNumber() {

        Random rand = new Random();
        int random;
        random = rand.nextInt(4 - 1 + 1) + 1;
        return random;
    }

    public static boolean gameOver(TechGiant tg1, TechGiant tg2) {

        if (tg1.getMoney() <= 0 || tg2.getMoney() <= 0) {
            //determineWinner();
            return true;
        } else if (tg1.getStartups().size() == 0 || tg2.getStartups().size() == 0) {
            //determineWinner();
            return true;
        } else {
            return false;
        }

    }

    public void setQuarterState(Quarters newQuarter) {

        currentQ = newQuarter;

    }

    public void setQuarter1() {
        currentQ.setQuarter1();
    }

    public void setQuarter2() {
        currentQ.setQuarter2();
    }

    public void setQuarter3() {
        currentQ.setQuarter3();
    }

    public void setQuarter4() {
        currentQ.setQuarter4();
    }

    public Quarters getQuarter1() {
        return q1;
    }

    public Quarters getQuarter2() {
        return q2;
    }

    public Quarters getQuarter3() {
        return q3;
    }

    public Quarters getQuarter4() {
        return q4;
    }
    
    public TechGiant getTechGiant1() {
        return this.tg1;
    }
    
    public TechGiant getTechGiant2() {
        return this.tg2;
    }

}

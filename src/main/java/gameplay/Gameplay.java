package main.java.gameplay;

import java.util.Random;

import main.java.quarters.Quarter1;
import main.java.quarters.Quarter2;
import main.java.quarters.Quarter3;
import main.java.quarters.Quarter4;
import main.java.quarters.Quarters;
import main.java.startups.Startup;
import main.java.techgiants.TechGiant;
import main.java.techgiants.TechGiantFactory;

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

        

        do {
            if (currentQ == null) {
                currentQ = q1;
                currentQ.setQuarter1();
                offQuarterEvents(tg1);
                offQuarterEvents(tg1);
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter1) {
                currentQ = q2;
                currentQ.setQuarter2();
                boolean battleFlag = true;
                do {
                    battleFlag = battle(tg1, tg2);
                    battleFlag = battle(tg2, tg1);
                } while (battleFlag == true);
                
                takeover(tg1, tg2);
                
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter2) {
                currentQ = q3;
                currentQ.setQuarter3();
                
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter3) {
                currentQ = q4;
                currentQ.setQuarter4();
                
                currentQ.endQuarter();
            } else {
                currentQ = q1;
                currentQ.setQuarter1();
                
                currentQ.endQuarter();
            }

        } while (!gameOver(tg1, tg2));

        return true;
    }
    
    /**
     * Entry point where battle takes place
     * @param enemy Tech giant to fight.
     * @return boolean for success or failure.
     */
    public boolean battle(TechGiant tg1, TechGiant tg2) {
        
        Startup startupOne = tg1.getStartups().get(0);
        Startup startupTwo = tg2.getStartups().get(0);
        
        if (startupOne.getCurrentHealth() == 0 || startupTwo.getCurrentHealth() == 0) {
            return false;
        }

        int attack = startupOne.getAttack() + startupOne.randomDamage();

        int defend = startupTwo.getDefense();

        int inflicted = attack - defend;

        
        if ((startupTwo.getCurrentHealth() - inflicted) <= 0) {
            startupTwo.setCurrentHealth(0);
        } else {
            startupTwo.setCurrentHealth(startupTwo.getCurrentHealth() - inflicted);
        }
        System.out.println("\n" + tg2.getName() + "'s " + startupTwo.getName() + " loses "
                + inflicted + "M dollars and has "
                + startupTwo.getCurrentHealth() + "M left!");

        if (startupTwo.getCurrentHealth() == 0) {
            System.out.println("\n" + tg2.getName() + "'s " + startupTwo.getName() + " has gone bankrupt! \n"
                    + tg1.getName() + " wins this corporate battle!");
            
            return false;
        }
        
        return true;
    }
    
    public Startup takeover(TechGiant tg1, TechGiant tg2) {
        Startup startupOne = tg1.getStartups().get(0);
        Startup startupTwo = tg2.getStartups().get(0);
        
        if (startupOne.getCurrentHealth() == 0) {
            startupOne.setCurrentHealth(startupOne.getHealth());
            tg2.addStartup(tg1.removeStartup(0));
            tg2.gainMoney(tg1.loseMoney(tg2));
            return startupOne;
        } else {
            startupTwo.setCurrentHealth(startupTwo.getHealth());
            tg1.addStartup(tg2.removeStartup(0));
            tg1.gainMoney(tg2.loseMoney(tg1));
            return startupTwo;
        }
        
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

    /**
     * Decides if the game is over or not based on
     * current Tech Giant money and number of Startups.
     * @param tg1 TechGiant 1
     * @param tg2 TechGiant 2
     * @return boolean true or false based on result
     */
    public static boolean gameOver(TechGiant tg1, TechGiant tg2) {

        if (tg1.getMoney() <= 0 || tg1.getStartups().size() == 0) {
            System.out.println("\n" + tg1.getName() + " has completely left the market!");
            System.out.println(tg2.getName() + " has achieved corporate supremacy!");
            return true;
        } else if (tg2.getMoney() <= 0 || tg2.getStartups().size() == 0) {
            System.out.println("\n" + tg2.getName() + " has completely left the market!");
            System.out.println(tg1.getName() + " has achieved corporate supremacy!");
            return true;
        } else {
            return false;
        }

    }
    
    public boolean offQuarterEvents(TechGiant tg) {
        
        //increaseStartupDef(tg);
        
        //startupBattle(tg);
        
        //evolution(tg);
        
        //itemShop(tg);
        
        return true;
    }

    /**
     * Sets the new State of gameplay.
     * @param newQuarter quarter.
     */
    public void setQuarterState(Quarters newQuarter) {

        currentQ = newQuarter;

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

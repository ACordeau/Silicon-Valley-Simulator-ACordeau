package main.java.gameplay;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import main.java.items.StimulusBoost;
import main.java.quarters.Quarter1;
import main.java.quarters.Quarter2;
import main.java.quarters.Quarter3;
import main.java.quarters.Quarter4;
import main.java.quarters.Quarters;
import main.java.startups.Startup;
import main.java.startups.StartupFactory;
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
    
    public Gameplay() {
        init();
    }

    /**
     * Starting point of the game.
     * 
     * @return boolean true if game completes.
     */
    public boolean start() {

        do {
            if (currentQ == null) {
                currentQ = q1;
                currentQ.setQuarter1();
                offQuarterEvents(tg1);
                offQuarterEvents(tg2);
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter1) {
                currentQ = q2;
                currentQ.setQuarter2();
                System.out.println("\n\nBEGINNING BATTLE BETWEEN TECH GIANTS\n\n");
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
                offQuarterEvents(tg1);
                offQuarterEvents(tg2);
                currentQ.endQuarter();
            } else {
                currentQ = q1;
                currentQ.setQuarter1();
                
                currentQ.endQuarter();
            }

        } while (!gameOver(tg1, tg2));

        return true;
    }
    
    private void init() {
        
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

        if (inflicted <= 0) {
            inflicted = 1;
        }
        
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
            startupOne.levelUp();
            
            return false;
        }
        
        return true;
    }
    
    public boolean startupBattle(TechGiant tg, Startup encountered, boolean battleFlag) {
        Startup battler = tg.getStartups().get(0);
        
        if (!battleFlag) {
            return false;
        }
        
        int attack = battler.getAttack() + battler.randomDamage();

        int defend = encountered.getDefense();

        int inflicted = attack - defend;
        
        if (inflicted <= 0) {
            inflicted = 1;
        }

        if ((encountered.getCurrentHealth() - inflicted) <= 0) {
            encountered.setCurrentHealth(0);
        } else {
            encountered.setCurrentHealth(encountered.getCurrentHealth() - inflicted);
        }
        System.out.println("\nWild " + encountered.getName() + " loses "
                + inflicted + "M dollars and has "
                + encountered.getCurrentHealth() + "M left!");

        if (encountered.getCurrentHealth() == 0) {            
            System.out.println("\n" + tg.getName() + " buys out " + encountered.getName() + " for 100M dollars!");
            tg.setMoney(tg.getMoney() - 100);
            encountered.setCurrentHealth(encountered.getHealth());
            tg.addStartup(encountered);
            battler.levelUp();
            
            return false;
        }
        
        return true;
    }
    
    public boolean startupBattle(Startup encountered, TechGiant tg, boolean battleFlag) {
        Startup battler = tg.getStartups().get(0);
        
        if (!battleFlag) {
            return false;
        }
        
        int attack = encountered.getAttack() + encountered.randomDamage();

        int defend = battler.getDefense();

        int inflicted = attack - defend;
        
        if (inflicted <= 0) {
            inflicted = 1;
        }

        if ((battler.getCurrentHealth() - inflicted) <= 0) {
            battler.setCurrentHealth(0);
        } else {
            battler.setCurrentHealth(battler.getCurrentHealth() - inflicted);
        }
        System.out.println("\n" + tg.getName() + "'s " + battler.getName() + " loses "
                + inflicted + "M dollars and has "
                + battler.getCurrentHealth() + "M left!");

        if (battler.getCurrentHealth() == 0) {
            System.out.println("\nWild " + encountered.getName() + " runs off with " + tg.getName() + "'s money!");
            
            tg.loseMoney(encountered);
            battler.setCurrentHealth(battler.getHealth());
            
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
        random = rand.nextInt(4) + 1;
        return random;
    }
    
    public static int randomStartupNumber() {

        Random rand = new Random();
        int random;
        random = rand.nextInt(10) + 1;
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

        if (tg1.getStartups().size() == 0) {
            System.out.println("\n" + tg1.getName() + " has completely left the market!");
            System.out.println(tg2.getName() + " has achieved corporate supremacy!");
            return true;
        } else if (tg2.getStartups().size() == 0) {
            System.out.println("\n" + tg2.getName() + " has completely left the market!");
            System.out.println(tg1.getName() + " has achieved corporate supremacy!");
            return true;
        } else {
            return false;
        }

    }
    
    public boolean offQuarterEvents(TechGiant tg) {
        
        System.out.println("\n\n" + tg.getName() + "'s turn!\n\n");
        
        increaseStartupDef(tg);
        
        Startup encountered = randomEncounter();
        System.out.println("\nA wild " + encountered.getName() + " challenges " + tg.getName() + "'s marketing skills!");
        equalize(encountered, tg);
        
        boolean battleFlag = true;
        do {
            battleFlag = startupBattle(tg, encountered, battleFlag);
            battleFlag = startupBattle(encountered, tg, battleFlag);
        } while (battleFlag == true);
        
        //evolution(tg);
        
        buyItem(tg);
        
        return true;
    }
    
    public List<Startup> increaseStartupDef(TechGiant tg) {
        
        List<Startup> list = new LinkedList<>();
        
        for (int i = 0; i < tg.getStartups().size(); i++) {
            Startup temp = tg.getStartups().get(i);
            if (temp.getCurrentHealth() < temp.getHealth()) {
                temp.setDefense(temp.getDefense() + temp.getLevel());
                list.add(temp);
            }
        }
        
        return list;
    }
    
    public Startup randomEncounter() {
        int random = randomStartupNumber();
        StartupFactory sf = new StartupFactory();
        Startup encountered = sf.randomStartup(random);
        return encountered;
    }
    
    private void equalize(Startup encountered, TechGiant tg) {
        Startup equalizer = tg.getStartups().get(0);

        if(equalizer.getLevel() < 5) {
            while (encountered.getLevel() < equalizer.getLevel()) {
                encountered.encounterLevelUp();
            }
        } else {
            while (encountered.getLevel() <= equalizer.getLevel()) {
                encountered.encounterLevelUp();
            }
        }
        
    }
    
    public boolean buyItem(TechGiant tg) {
        
        StimulusBoost item = new StimulusBoost();
        Random rand = new Random();
        int random = rand.nextInt(100) + 1;
        
        if (tg.getMoney() <= item.getCost()) {
            System.out.println("\n" + tg.getName() + " does not have enough revenue to obtain a Simulus Boost");
            return false;
        }
        
        if (random > 90) {
            tg.setMoney(tg.getMoney() - item.getCost());
            tg.addItem(item);
            System.out.println("\n" + tg.getName() + " has obtained a stimulus boost to give to a Startup for " + item.getCost() + "M dollars!");
            return true;
        }
        else {
            System.out.println("\n" + tg.getName() + " chose not to obtain a stimulus boost.");
            return false;
        }
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

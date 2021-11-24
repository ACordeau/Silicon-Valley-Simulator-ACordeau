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
import main.java.startups.Bing;
import main.java.startups.EvolvedBing;
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
                System.out.println(tg1.getName() + " sends out " + tg1.getStartups().get(0).getName() 
                        + " Rank: " + tg1.getStartups().get(0).getLevel());
                System.out.println(tg2.getName() + " sends out " + tg2.getStartups().get(0).getName() 
                        + " Rank: " + tg2.getStartups().get(0).getLevel());
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
                offQuarterEvents(tg1);
                offQuarterEvents(tg2);
                currentQ.endQuarter();
            } else if (currentQ instanceof Quarter3) {
                currentQ = q4;
                currentQ.setQuarter4();
                System.out.println("\n\nBEGINNING BATTLE BETWEEN TECH GIANTS\n\n");
                System.out.println(tg1.getName() + " sends out " + tg1.getStartups().get(0).getName() 
                        + " Rank: " + tg1.getStartups().get(0).getLevel());
                System.out.println(tg2.getName() + " sends out " + tg2.getStartups().get(0).getName() 
                        + " Rank: " + tg2.getStartups().get(0).getLevel());
                boolean battleFlag = true;
                do {
                    battleFlag = battle(tg1, tg2);
                    battleFlag = battle(tg2, tg1);
                } while (battleFlag == true);
                
                takeover(tg1, tg2);
                currentQ.endQuarter();
            } else {
                currentQ = q1;
                currentQ.setQuarter1();
                offQuarterEvents(tg1);
                offQuarterEvents(tg2);
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
        
        boolean useItem;
        
        if (startupOne.getCurrentHealth() < (startupOne.getHealth() * .5) 
                && tg1.getItems().size() != 0) {
            useItem = calculateUseItem();
            if (useItem == true) {
                tg1.useItem(startupOne);
                System.out.println("\n" + tg1.getName() + " used a Stimulus Boost to"
                        + " grow " + startupOne.getName() + "'s economy."
                        + " Current revenue is now " + startupOne.getCurrentHealth());
                return true;
            }
        }
        
        
        boolean crit;
        boolean miss = calculateMiss();
        if (miss == false) {
            crit = calculateCrit();
        } else {
            crit = false;
        }
        
        if (miss == false) { 

            int attack = startupOne.getAttack() + startupOne.randomDamage();
            
            if (crit == true) {
                attack = attack * 2;
                System.out.println("\n NEXT ATTACK IS A CRITICAL HIT");
            }
    
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
            System.out.println("\n" + tg1.getName() + "'s " + startupOne.getName() + " attacks " 
                    + tg2.getName() + "'s " + startupTwo.getName() + " and it loses "
                    + inflicted + "M dollars and has "
                    + startupTwo.getCurrentHealth() + "M left!");
        
        } else {
            System.out.println("\n" + tg1.getName() + "'s " + startupOne.getName() + " missed "
                    + "their attack!");
        }

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
        
        boolean crit;
        boolean miss = calculateMiss();
        if (miss == false) {
            crit = calculateCrit();
        } else {
            crit = false;
        }
        
        if (miss == false) {
            
            int attack = battler.getAttack() + battler.randomDamage();
            
            if (crit == true) {
                attack = attack * 2;
                System.out.println("\n NEXT ATTACK IS A CRITICAL HIT");
            }
    
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
            System.out.println("\n" + tg.getName() + "'s " + battler.getName() + " attacks Wild " 
                    + encountered.getName() + " and it loses "
                    + inflicted + "M dollars and has "
                    + encountered.getCurrentHealth() + "M left!");
        
        } else {
            System.out.println("\n" + tg.getName() + "'s " + battler.getName() + " missed "
                    + "their attack!");
        }

        if (encountered.getCurrentHealth() == 0) {            
            System.out.println("\n" + tg.getName() + " buys out " 
                    + encountered.getName() + " for 100M dollars!");
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
        
        boolean crit;
        boolean miss = calculateMiss();
        if (miss == false) {
            crit = calculateCrit();
        } else {
            crit = false;
        }
        
        if (miss == false) {
        
            int attack = encountered.getAttack() + encountered.randomDamage();
            
            if (crit == true) {
                attack = attack * 2;
                System.out.println("\n NEXT ATTACK IS A CRITICAL HIT");
            }
    
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
            System.out.println("\nWild" + encountered.getName() + " attacks " + tg.getName() 
                    + "'s " + battler.getName() +  " and it loses "
                    + inflicted + "M dollars and has "
                    + battler.getCurrentHealth() + "M left!");
        
        } else {
            System.out.println("\nWild " + encountered.getName() + " missed "
                    + "their attack!");
        }

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
        
        evolution(tg);
        
        Startup encountered = randomEncounter();
        System.out.println("\nA wild " + encountered.getName() + " challenges " + tg.getName() + "'s marketing skills!");
        equalize(encountered, tg);
        
        boolean battleFlag = true;
        do {
            battleFlag = startupBattle(tg, encountered, battleFlag);
            battleFlag = startupBattle(encountered, tg, battleFlag);
        } while (battleFlag == true);
        
        buyItem(tg);
        
        return true;
    }
    
    public void evolution(TechGiant tg) {
        Startup temp;
        for (int i = 0; i < tg.getStartups().size(); i++) {
            if ((tg.getStartups().get(i).getLevel() >= 5) 
                    && (tg.getStartups().get(i).getIsEvolved() == false)) {
                
                temp = tg.getStartups().remove(i);
                
                temp = temp.evolve();
                
                tg.getStartups().add(i, temp);
                
                System.out.println("Revenue: " + tg.getStartups().get(i).getHealth());
                System.out.println("Net income: " + tg.getStartups().get(i).getAttack());
                System.out.println("Market share: " + tg.getStartups().get(i).getDefense());
            }
        }
        
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
    
    private boolean calculateMiss() {
        Random rand = new Random();
        int random = rand.nextInt(100) + 1;
        
        if (random >= 45 && random <= 65) {
            return true;
        } else {
            return false;
        }
        
    }
    
    private boolean calculateCrit() {
        Random rand = new Random();
        int random = rand.nextInt(100) + 1;
        
        if (random >= 13 && random <= 15) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean calculateUseItem() {
        Random rand = new Random();
        int random = rand.nextInt(100) + 1;
        
        if (random >= 20 && random <= 55) {
            return true;
        } else {
            return false;
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
        
        if (random < 90) {
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

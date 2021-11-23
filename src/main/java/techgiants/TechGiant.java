package main.java.techgiants;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import main.java.items.StimulusBoost;
import main.java.startups.Startup;
import main.java.startups.StartupFactory;

public class TechGiant {

    private static final int MAX_STARTUPS = 6;
    private static final double BIG_CUT = .3;
    private boolean extraCut;
    private int money;
    private List<Startup> startups = new LinkedList<>();
    private List<Startup> extraStartups = new LinkedList<>();
    private List<StimulusBoost> items = new LinkedList<>();
    private String name;
    private String type;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtraCut() {
        return extraCut;
    }

    public void setIsExtraCut(boolean extraCut) {
        this.extraCut = extraCut;
    }

    /**
     * Initialization of TechGiant to determine beginning Startup.
     * 
     * @return random int associated with Startup.
     */
    public int initialStartup() {
        StartupFactory sf = new StartupFactory();
        Startup startup = null;
        Random rand = new Random();
        int random = rand.nextInt(10 - 1 + 1) + 1;
        startup = sf.randomStartup(random);
        this.addStartup(startup);
        System.out.println(this.getName() + "'s first Startup is " + startup.getName());
        return random;
    }

    /**
     * Add Startup to list of TechGiant Startups.
     * 
     * @param startup to add to the list.
     * @return boolean for success or failure.
     */
    public boolean addStartup(Startup startup) {

        if (!isFull()) {
            startups.add(startup);
            System.out.println("\n" + startup.getName() + " has been added to the corporate market!");
            return true;
        } else if (isFull()) {
            extraStartups.add(startup);
            System.out.println("The market is full, " + startup.getName() + " was sent to market training camp!");
            return false;
        } else {
            return false;
        }

    }

    /**
     * Remove Startup from list of TechGiant Startups.
     * 
     * @param startupIdx index of startup.
     * @return boolean for success or failure.
     */
    public Startup removeStartup(int startupIdx) {
        if (startups.size() == 0) {
            return null;
        } else {
            Startup temp = startups.remove(startupIdx);
            if (!isEmpty()) {
                moveFromBench();
            }
            return temp;
        }

    }
    
    private void moveFromBench() {
        startups.add(extraStartups.remove(0));
    }

    public List<Startup> getStartups() {
        return startups;
    }
    
    public List<StimulusBoost> getItems() {
        return items;
    }
    
    public boolean addItem(StimulusBoost item) {
        if (item == null) {
            return false;
        }
        
        items.add(item);
        return true;
    }
    
    public boolean useItem(Startup startup) {
        if (items.size() == 0) {
            return false;
        }
        
        StimulusBoost item = items.remove(0);
        startup.setCurrentHealth(startup.getCurrentHealth() + item.getHeal());
        if (startup.getCurrentHealth() > startup.getHealth()) {
            startup.setCurrentHealth(startup.getHealth());
        }
        
        return true;
        
    }

    /**
     * Tells us if the Tech Giant has 6 startups already.
     * 
     * @return boolean for success or failure.
     */
    public boolean isFull() {
        if (startups.size() >= MAX_STARTUPS) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEmpty() {
        if (extraStartups.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void gainMoney(int newMoney) {
        setMoney(getMoney() + newMoney);
    }
    
    public int loseMoney(Startup temp) {
        Random rand = new Random();
        int random = rand.nextInt(temp.getCurrentHealth()) + 10;
        System.out.println("\n" + this.getName() + " loses " + random + "M dollars to " + temp.getName());
        return random;
    }
    
    public int loseMoney(TechGiant tg) {
        Random rand = new Random();
        int random = rand.nextInt(100 - 60) + 40;
        int extra;
        
        if (tg.extraCut == true) {
            extra = (int) (random * BIG_CUT);
            System.out.println("\n" + this.getName() + " gives " + random + "M dollars to " + tg.getName() + " plus an extra " + extra + " for losing to a browsing company!");
            return random + extra;
        } else {
            System.out.println("\n" + this.getName() + " gives " + random + "M dollars to " + tg.getName());
            return random;
        }
        
    }

}

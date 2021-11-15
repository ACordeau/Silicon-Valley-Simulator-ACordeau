package main.java.svalley;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TechGiant {

    private static final int MAX_STARTUPS = 6;
    private int money;
    private List<Startup> startups = new LinkedList<>();
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

    /**
     * Initialization of TechGiant to determine
     * beginning Startup.
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
     * @param startup to add to the list.
     * @return boolean for success or failure.
     */
    public boolean addStartup(Startup startup) {

        if (!isFull()) {
            startups.add(startup);
            return true;
        } else {
            return false;
        }

    }

    public List<Startup> getStartups() {
        return startups;
    }

    /**
     * Tells us if the Tech Giant has 6 startups already.
     * @return boolean for success or failure.
     */
    public boolean isFull() {
        if (startups.size() >= MAX_STARTUPS) {
            return true;
        } else {
            System.out.println("Oh no, you already have six startups and "
                    + "can't bear the financial load of any more!");
            return false;
        }
    }

}

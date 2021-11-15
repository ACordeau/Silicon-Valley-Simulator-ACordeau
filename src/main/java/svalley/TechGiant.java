package main.java.svalley;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TechGiant {

    private final static int MAX_STARTUPS = 6;
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

    public boolean isFull() {
        if (startups.size() >= MAX_STARTUPS) {
            return true;
        } else {
            return false;
        }
    }

}

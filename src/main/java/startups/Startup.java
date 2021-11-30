/**
 * This file is a class for a Startup
 * that can be made into other types.
 * This file satisfies Requirement 1.
 */

package main.java.startups;

import java.util.Random;

import main.java.evolutions.EvolvedBing;
import main.java.evolutions.EvolvedFacebook;
import main.java.evolutions.EvolvedGoogle;
import main.java.evolutions.EvolvedInstagram;
import main.java.evolutions.EvolvedReddit;
import main.java.evolutions.EvolvedSnapchat;
import main.java.evolutions.EvolvedTikTok;
import main.java.evolutions.EvolvedTwitter;
import main.java.evolutions.EvolvedVimeo;
import main.java.evolutions.EvolvedYouTube;

public class Startup {

    private static final int MAX_LEVEL = 15;
    
    private int health;
    private int currentHealth;
    private int attack;
    private int defense;
    private boolean isEvolved;
    private int level;
    private String name;
    private String type;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public boolean getIsEvolved() {
        return isEvolved;
    }

    public void setIsEvolved(boolean evolve) {
        this.isEvolved = evolve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
     * Decides on a random amount of damage.
     * @return random damage number.
     */
    public int randomDamage() {
        Random rand = new Random();
        int random = rand.nextInt(attack * 3) + level;
        return random;
    }
    
    /**
     * Algorithm for deciding how leveling up works.
     * Helps satisfy requirement 11.
     * @return boolean for success or failure.
     */
    public boolean levelUp() {
        if (getLevel() == MAX_LEVEL) {
            System.out.println("Max Startup level already reached!");
            return false;
        }
        

        
        System.out.println(this.getName() + " has gained a rank!");
        
        setLevel(getLevel() + 1);
        System.out.println("Rank: " + getLevel());
        
        Random rand = new Random();
        int random;
        
        random = rand.nextInt(35) + 1;
        setHealth((int)((getHealth() + (getHealth() * .25) + random)));
        System.out.println("Revenue: " + getHealth());
        
        setCurrentHealth(getHealth());
        System.out.println("Current revenue raises to total revenue!");
        
        random = rand.nextInt(5 + getLevel());
        setAttack(getAttack() + random);
        System.out.println("Net income: " + getAttack());
        
        random = rand.nextInt(3 + getLevel());
        setDefense(getDefense() + random);
        System.out.println("Market share: " + getDefense());
        return true;
        
    }
    
    /**
     * Algorithm that brings up the level of
     * randomly encountered startups to
     * the level of the current first in the party.
     * @return boolean for success or failure.
     */
    public boolean encounterLevelUp() {
        if (getLevel() == MAX_LEVEL) {
            return false;
        }
        
        setLevel(getLevel() + 1);
        
        setHealth((int)(getHealth() + (getHealth() * .15)));
        
        setCurrentHealth(getHealth());
        
        Random rand = new Random();
        int random;
        
        random = rand.nextInt(5 + getLevel()) + 1;
        setAttack(getAttack() + random);
        random = rand.nextInt(3 + getLevel()) + 1;
        setDefense(getDefense() + random);

        return true;
        
    }
    
    /**
     * This is the factory that figures out 
     * what type of startup is trying to evolve
     * so it can be decorated.
     * Satisfies requirement 11.
     * @return Decorated Startup.
     */
    public Startup evolve() {
        
        Startup s = this;
        
        if (s instanceof Bing) {
            return new EvolvedBing(this);
        } else if (s instanceof Facebook) {
            return new EvolvedFacebook(this);
        } else if (s instanceof Google) {
            return new EvolvedGoogle(this);
        } else if (s instanceof Instagram) {
            return new EvolvedInstagram(this);
        } else if (s instanceof Reddit) {
            return new EvolvedReddit(this);
        } else if (s instanceof Snapchat) {
            return new EvolvedSnapchat(this);
        } else if (s instanceof TikTok) {
            return new EvolvedTikTok(this);
        } else if (s instanceof Twitter) {
            return new EvolvedTwitter(this);
        } else if (s instanceof Vimeo) {
            return new EvolvedVimeo(this);
        } else if (s instanceof YouTube) {
            return new EvolvedYouTube(this);
        } else {
            System.out.println("I'M NOT SURE HOW YOU MANAGED TO GET HERE.");
            return this;
        }
        
    }

}

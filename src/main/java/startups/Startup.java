package main.java.startups;

import java.util.Random;

public class Startup {

    private static final int MAX_LEVEL = 10;
    
    private int health;
    private int currentHealth;
    private int attack;
    private int defense;
    private boolean isEvolved;
    private int level;
    private String name;
    private String type;
    
    // private List moves;
    // private Type type;

    /*
    private enum Type{
        SOCIAL_MEDIA,
        VIDEO_SHARING,
        IMAGE_SHARING
    }
    */

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
    
    public int randomDamage() {
        Random rand = new Random();
        int random = rand.nextInt(attack * 3) + level;
        return random;
    }
    
    public boolean levelUp() {
        if (getLevel() == MAX_LEVEL) {
            System.out.println("Max Startup level already reached!");
            return false;
        }
        
        Random rand = new Random();
        int random;
        
        System.out.println(this.getName() + " has gained a rank!");
        
        setLevel(getLevel() + 1);
        System.out.println("Rank: " + getLevel());
        
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
    
    public boolean encounterLevelUp() {
        if (getLevel() == MAX_LEVEL) {
            return false;
        }
        Random rand = new Random();
        int random;
        
        setLevel(getLevel() + 1);
        
        setHealth((int)(getHealth() + (getHealth() * .15)));
        
        setCurrentHealth(getHealth());
        
        random = rand.nextInt(5 + getLevel()) + 1;
        setAttack(getAttack() + random);
        random = rand.nextInt(3 + getLevel()) + 1;
        setDefense(getDefense() + random);

        return true;
        
    }
    
    public Startup evolve() {
        
        Startup s = this;
        
        if (s instanceof Bing) {
            return s = new EvolvedBing(s);
        } else if (s instanceof Facebook) {
            return s = new EvolvedFacebook(s);
        } else if (s instanceof Google) {
            return s = new EvolvedGoogle(s);
        } else if (s instanceof Instagram) {
            return s = new EvolvedInstagram(s);
        } else if (s instanceof Reddit) {
            return s = new EvolvedReddit(s);
        } else if (s instanceof Snapchat) {
            return s = new EvolvedSnapchat(s);
        } else if (s instanceof TikTok) {
            return s = new EvolvedTikTok(s);
        } else if (s instanceof Twitter) {
            return s = new EvolvedTwitter(s);
        } else if (s instanceof Vimeo) {
            return s = new EvolvedVimeo(s);
        } else if (s instanceof YouTube) {
            return s = new EvolvedYouTube(s);
        } else {
            System.out.println("I'M NOT SURE HOW YOU MANAGED TO GET HERE.");
            return null;
        }
        
    }
    
    /*
    public List getMoves() {
        return moves;
    }
    */

}

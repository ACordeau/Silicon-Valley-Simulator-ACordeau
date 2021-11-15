package main.java.svalley;

import java.util.List;
import java.util.Random;

public class Startup {

    private int health;
    private int currentHealth;
    private int attack;
    private int defense;
    private int exp;
    private int level;
    private String name;
    private String type;
    private final int MAX_LEVEL = 15;
    // private List moves;
    // private Type type;

//    private enum Type{
//        SOCIAL_MEDIA,
//        VIDEO_SHARING,
//        IMAGE_SHARING
//    }

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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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
    
    

//    public List getMoves() {
//        return moves;
//    }

}

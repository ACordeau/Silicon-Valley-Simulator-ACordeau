package main.java.svalley;

import java.util.List;
import java.util.Random;

public class Startup {
    
    private int health;
    private int currentHealth;
    private int attack;
    private int defense;
    private String type;
    //private List moves;
    //private Type type;
    
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

//    public List getMoves() {
//        return moves;
//    }

}

package main.java.items;

public class StimulusBoost {
    
    private int cost;
    private int heal;
    
    StimulusBoost(){
        setCost(50);
        setHeal(50);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
    
}

package main.java.startups;

public class Twitter extends Startup {

    Twitter() {
        setHealth(50);
        setCurrentHealth(this.getHealth());
        setAttack(2);
        setDefense(1);
        setType("SOCIAL MEDIA");
        setIsEvolved(false);
        setName("Twitter");
        setLevel(1);
    }

}

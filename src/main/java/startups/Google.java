package main.java.startups;

public class Google extends Startup {

    Google() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("BROWSER");
        setIsEvolved(false);
        setName("Google");
        setLevel(1);
    }

}

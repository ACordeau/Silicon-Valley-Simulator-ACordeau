package main.java.startups;

public class Facebook extends Startup {

    protected Facebook() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("SOCIAL MEDIA");
        setIsEvolved(false);
        setName("Facebook");
        setLevel(1);
    }

}

/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Snapchat extends Startup {

    protected Snapchat() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("IMAGE SHARING");
        setIsEvolved(false);
        setName("Snapchat");
        setLevel(1);
    }

}

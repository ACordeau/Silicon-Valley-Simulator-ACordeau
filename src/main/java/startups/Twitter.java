/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Twitter extends Startup {

    protected Twitter() {
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

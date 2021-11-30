/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class YouTube extends Startup {

    protected YouTube() {
        setHealth(50);
        setCurrentHealth(this.getHealth());
        setAttack(2);
        setDefense(1);
        setType("VIDEO SHARING");
        setIsEvolved(false);
        setName("YouTube");
        setLevel(1);
    }

}

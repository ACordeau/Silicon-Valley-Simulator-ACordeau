/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Instagram extends Startup {

    protected Instagram() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("IMAGE SHARING");
        setIsEvolved(false);
        setName("Instagram");
        setLevel(1);
    }

}

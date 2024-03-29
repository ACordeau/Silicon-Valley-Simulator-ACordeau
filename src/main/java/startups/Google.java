/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Google extends Startup {

    protected Google() {
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

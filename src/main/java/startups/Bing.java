/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Bing extends Startup {

    protected Bing() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("BROWSER");
        setIsEvolved(false);
        setName("Bing");
        setLevel(1);
    }

}

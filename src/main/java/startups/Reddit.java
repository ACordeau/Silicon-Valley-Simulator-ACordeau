/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Reddit extends Startup {

    protected Reddit() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("SOCIAL MEDIA");
        setIsEvolved(false);
        setName("Reddit");
        setLevel(1);
    }

}

/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class TikTok extends Startup {

    protected TikTok() {
        setHealth(50);
        setCurrentHealth(getHealth());
        setAttack(2);
        setDefense(1);
        setType("VIDEO SHARING");
        setIsEvolved(false);
        setName("TikTok");
        setLevel(1);
    }

}

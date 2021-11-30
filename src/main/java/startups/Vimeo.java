/**
 * This file creates a specific Startup type.
 * It satisfies requirements 1, 7, 9, 10.
 */

package main.java.startups;

public class Vimeo extends Startup {

    protected Vimeo() {
        setHealth(50);
        setCurrentHealth(this.getHealth());
        setAttack(2);
        setDefense(1);
        setType("VIDEO SHARING");
        setIsEvolved(false);
        setName("Vimeo");
        setLevel(1);
    }

}

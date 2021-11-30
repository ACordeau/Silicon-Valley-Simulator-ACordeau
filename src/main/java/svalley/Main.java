/**
 * Entry point of the program that creates
 * the gameplay object that begins all the
 * execution.
 */

package main.java.svalley;

import main.java.gameplay.Gameplay;

public class Main {

    /**
     * Entry point of program.
     * 
     * @param args arguments.
     */
    public static void main(String[] args) {
        Gameplay obj = new Gameplay();
        obj.start();
    }

}

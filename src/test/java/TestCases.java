package test.java;

import static org.junit.Assert.assertTrue;

import main.java.gameplay.Gameplay;
import main.java.svalley.Main;

import org.junit.Before;
import org.junit.Test;

public class TestCases {

    @Before
    public void setUp() throws Exception {
    }
    
    Gameplay game;
    
    /**
     * Tests the flow of gameplay.
     */
    @Test
    public void gameStartTest() {
        
        game = new Gameplay();
        
        assertTrue(game.start());
        
    }

}

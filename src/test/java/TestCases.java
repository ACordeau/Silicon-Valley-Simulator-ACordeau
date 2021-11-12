package test.java;

import main.java.svalley.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCases {
    
    Main main;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void mainTest() {

        assertTrue(Main.start());
        
    }
    
    @Test
    public void mainMethodTest() {
        
        assertNotNull(main = new Main());
        
    }

}

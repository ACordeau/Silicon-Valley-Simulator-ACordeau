package test.java;

import main.java.svalley.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCases {
    
    Main main;
    StartupFactory startupFactory;
    Startup startup;
    
    @Before
    public void setUp() throws Exception {
    }
    
    /**
     * This tests to ensure the startup factory works.
     */
    @Test
    public void startupFactoryTest() {

        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(1);
        
        assertTrue(startup instanceof Twitter);
        
    }
    
    /**
     * This tests to ensure null is returned if the random 
     * number generator somehow gives a number outside
     * of the given values.
     */
    @Test
    public void mainMethodTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(100);
        
        assertNull(startup);
        
    }

}

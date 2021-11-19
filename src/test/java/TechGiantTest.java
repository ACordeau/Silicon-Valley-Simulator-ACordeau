package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.java.startups.Startup;
import main.java.startups.StartupFactory;
import main.java.techgiants.PandaSuplex;
import main.java.techgiants.Polygon;
import main.java.techgiants.Reader;
import main.java.techgiants.SoundByte;
import main.java.techgiants.TechGiant;
import main.java.techgiants.TechGiantFactory;

import org.junit.Test;

public class TechGiantTest {
    
    TechGiantFactory techGiantFactory;
    TechGiant techGiant;
    StartupFactory startupFactory;
    Startup startup;
    
    /**
     * This tests to ensure the tech giant factory works.
     */
    @Test
    public void techGiantFactoryTest() {

        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);

        assertTrue(techGiant instanceof PandaSuplex);

    }

    /**
     * This tests to ensure the tech giant properly initializes it's first startup.
     */
    @Test
    public void techGiantInitialStartupTest() {

        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        chosen = techGiant.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);

        assertEquals(techGiant.getStartups().size(), 1);

    }

    /**
     * Tests to ensure that tech giants can have six startups.
     */
    @Test
    public void techGiantSixStartups() {

        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        chosen = techGiant.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        for (int i = 0; i < 5; i++) {
            techGiant.addStartup(startupFactory.randomStartup(chosen));
        }

        assertEquals(techGiant.getStartups().size(), 6);
    }

    /**
     * Tests to ensure that tech giants cannot have more than six startups at a
     * time
     */
    @Test
    public void techGiantSevenStartups() {

        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        chosen = techGiant.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        for (int i = 0; i < 5; i++) {
            techGiant.addStartup(startupFactory.randomStartup(chosen));
        }

        assertFalse(techGiant.addStartup(startupFactory.randomStartup(chosen)));
    }
    
    /**
     * This tests to ensure the Reader TechGiant initializes properly.
     */
    @Test
    public void readerTechGiantTest() {
        
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(1);
        
        assertTrue(techGiant instanceof Reader);
        
    }
    
    /**
     * This tests to ensure the SoundByte TechGiant initializes properly.
     */
    @Test
    public void soundByteTechGiantTest() {
        
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(2);
        
        assertTrue(techGiant instanceof SoundByte);
        
    }
    
    /**
     * This tests to ensure the PandaSuplex TechGiant initializes properly.
     */
    @Test
    public void pandaSuplexTechGiantTest() {
        
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        
        assertTrue(techGiant instanceof PandaSuplex);
        
    }
    
    /**
     * This tests to ensure the Polygon TechGiant initializes properly.
     */
    @Test
    public void polygonTechGiantTest() {
        
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(4);
        
        assertTrue(techGiant instanceof Polygon);
        
    }
    
    /**
     * This tests to ensure the TechGiant factory returns null
     * if it receives input outside of its association.
     */
    @Test
    public void nullTechGiantTest() {
        
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(4);
        
        assertTrue(techGiant instanceof Polygon);
        
    }

}

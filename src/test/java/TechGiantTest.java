package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import main.java.gameplay.Gameplay;
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
    TechGiant techGiant2;
    StartupFactory startupFactory;
    Startup startup;
    Gameplay game;
    
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
     * time.
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
    
    /**
     * Tests to make sure takeover works properly.
     */
    @Test
    public void takeoverTestGiantOne() {
        
        game = new Gameplay();
        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        techGiant2 = techGiantFactory.randomTechGiant(4);
        chosen = techGiant.initialStartup();
        chosen = techGiant2.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        
        techGiant2.getStartups().get(0).setCurrentHealth(0);
        
        Startup tester = techGiant2.getStartups().get(0);
        
        assertEquals(game.takeover(techGiant, techGiant2), tester);
        
    }
    
    /**
     * Tests to make sure takeover works properly.
     */
    @Test
    public void takeoverTestGiantTwo() {

        game = new Gameplay();
        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        techGiant2 = techGiantFactory.randomTechGiant(4);
        chosen = techGiant.initialStartup();
        chosen = techGiant2.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        
        techGiant.getStartups().get(0).setCurrentHealth(0);
        
        Startup tester = techGiant.getStartups().get(0);
        
        assertEquals(game.takeover(techGiant, techGiant2), tester);
        
    }
    
    /**
     * Tests to make sure game over works properly.
     */
    @Test
    public void gameoverTestGiantOne() {
        
        game = new Gameplay();
        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        techGiant2 = techGiantFactory.randomTechGiant(4);
        chosen = techGiant.initialStartup();
        chosen = techGiant2.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        
        techGiant2.getStartups().get(0).setCurrentHealth(0);
        game.takeover(techGiant2, techGiant);
        
        assertTrue(Gameplay.gameOver(techGiant2, techGiant));
        
    }
    
    /**
     * Tests to make sure game over works properly.
     */
    @Test
    public void gameoverTestGiantTwp() {
        
        game = new Gameplay();
        int chosen;
        techGiantFactory = new TechGiantFactory();
        techGiant = techGiantFactory.randomTechGiant(3);
        techGiant2 = techGiantFactory.randomTechGiant(4);
        chosen = techGiant.initialStartup();
        chosen = techGiant2.initialStartup();
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(chosen);
        
        techGiant.getStartups().get(0).setCurrentHealth(0);
        game.takeover(techGiant2, techGiant);
        
        assertTrue(Gameplay.gameOver(techGiant2, techGiant));
        
    }

}

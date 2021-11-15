package test.java;

import main.java.svalley.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCases {

    Main main;
    StartupFactory startupFactory;
    Startup startup;
    TechGiantFactory techGiantFactory;
    TechGiant techGiant;

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
     * This tests to ensure null is returned if the random number generator somehow
     * gives a number outside of the given values.
     */
    @Test
    public void nullFactory() {

        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(100);

        assertNull(startup);

    }

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

}

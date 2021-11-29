package test.java;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import main.java.evolutions.EvolvedBing;
import main.java.evolutions.EvolvedFacebook;
import main.java.evolutions.EvolvedGoogle;
import main.java.evolutions.EvolvedInstagram;
import main.java.evolutions.EvolvedReddit;
import main.java.evolutions.EvolvedSnapchat;
import main.java.evolutions.EvolvedTikTok;
import main.java.evolutions.EvolvedTwitter;
import main.java.evolutions.EvolvedVimeo;
import main.java.evolutions.EvolvedYouTube;
import main.java.gameplay.Gameplay;
import main.java.startups.Startup;
import main.java.startups.StartupFactory;

public class StartupEvolutionTest {

    Gameplay game;
    StartupFactory startupFactory;
    Startup startup;
    
    /**
     * This tests to ensure the Twitter startup evolves properly.
     */
    @Test
    public void twitterEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(1);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedTwitter);
        
    }
    
    /**
     * This tests to ensure the YouTube startup evolves properly.
     */
    @Test
    public void youTubeEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(2);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedYouTube);
        
    }
    
    /**
     * This tests to ensure the Vimeo startup evolves properly.
     */
    @Test
    public void vimeoEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(3);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedVimeo);
        
    }
    
    /**
     * This tests to ensure the TikTok startup evolves properly.
     */
    @Test
    public void tikTokEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(4);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedTikTok);
        
    }
    
    /**
     * This tests to ensure the Instagram startup evolves properly.
     */
    @Test
    public void instagramEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(5);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedInstagram);
        
    }
    
    /**
     * This tests to ensure the Snapchat startup evolves properly.
     */
    @Test
    public void snapchatEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(6);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedSnapchat);
        
    }
    
    /**
     * This tests to ensure the Reddit startup evolves properly.
     */
    @Test
    public void redditEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(7);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedReddit);
        
    }
    
    /**
     * This tests to ensure the Google startup evolves properly.
     */
    @Test
    public void googleEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(8);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedGoogle);
        
    }
    
    /**
     * This tests to ensure the Bing startup evolves properly.
     */
    @Test
    public void bingEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(9);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedBing);
        
    }
    
    /**
     * This tests to ensure the Facebook startup evolves properly.
     */
    @Test
    public void facebookEvolveTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(10);
        
        for (int i = 0; i < 6; i++) {
            startup.levelUp();
        }
        
        startup = startup.evolve();
        
        assertTrue(startup instanceof EvolvedFacebook);
        
    }
    
}

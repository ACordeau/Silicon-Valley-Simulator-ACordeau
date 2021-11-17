package test.java;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.Startups.Bing;
import main.java.Startups.Facebook;
import main.java.Startups.Google;
import main.java.Startups.Instagram;
import main.java.Startups.Reddit;
import main.java.Startups.Snapchat;
import main.java.Startups.Startup;
import main.java.Startups.StartupFactory;
import main.java.Startups.TikTok;
import main.java.Startups.Twitter;
import main.java.Startups.Vimeo;
import main.java.Startups.YouTube;

public class StartupTest {

    StartupFactory startupFactory;
    Startup startup;

    @Before
    public void setUp() throws Exception {
    }

    /**
     * This tests to ensure the startup factory works.
     */
    @Test
    public void startupRandomFactoryTest() {

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
     * This tests to ensure the Twitter startup initializes properly.
     */
    @Test
    public void twitterStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(1);
        
        assertTrue(startup instanceof Twitter);
        
    }
    
    /**
     * This tests to ensure the Bing startup initializes properly.
     */
    @Test
    public void youTubeStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(2);
        
        assertTrue(startup instanceof YouTube);
        
    }
    
    /**
     * This tests to ensure the Vimeo startup initializes properly.
     */
    @Test
    public void vimeoStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(3);
        
        assertTrue(startup instanceof Vimeo);
        
    }
    
    /**
     * This tests to ensure the TikTok startup initializes properly.
     */
    @Test
    public void tikTokStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(4);
        
        assertTrue(startup instanceof TikTok);
        
    }
    
    /**
     * This tests to ensure the Instagram startup initializes properly.
     */
    @Test
    public void instagramStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(5);
        
        assertTrue(startup instanceof Instagram);
        
    }
    
    /**
     * This tests to ensure the Snapchat startup initializes properly.
     */
    @Test
    public void snapchatStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(6);
        
        assertTrue(startup instanceof Snapchat);
        
    }
    
    /**
     * This tests to ensure the Reddit startup initializes properly.
     */
    @Test
    public void redditStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(7);
        
        assertTrue(startup instanceof Reddit);
        
    }
    
    /**
     * This tests to ensure the Google startup initializes properly.
     */
    @Test
    public void googleStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(8);
        
        assertTrue(startup instanceof Google);
        
    }
    
    /**
     * This tests to ensure the Bing startup initializes properly.
     */
    @Test
    public void bingStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(9);
        
        assertTrue(startup instanceof Bing);
        
    }
    
    /**
     * This tests to ensure the Facebook startup initializes properly.
     */
    @Test
    public void facebookStartupTest() {
        
        startupFactory = new StartupFactory();
        startup = startupFactory.randomStartup(10);
        
        assertTrue(startup instanceof Facebook);
        
    }

}

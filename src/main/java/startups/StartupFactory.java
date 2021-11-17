package main.java.startups;

public class StartupFactory {

    /**
     * Factory designed to choose startup
     * at runtime.
     * @param random int for choosing startup.
     * @return Startup type.
     */
    public Startup randomStartup(int random) {

        if (random == 1) {
            return new Twitter();
        } else if (random == 2) {
            return new YouTube();
        } else if (random == 3) {
            return new Vimeo();
        } else if (random == 4) {
            return new TikTok();
        } else if (random == 5) {
            return new Instagram();
        } else if (random == 6) {
            return new Snapchat();
        } else if (random == 7) {
            return new Reddit();
        } else if (random == 8) {
            return new Google();
        } else if (random == 9) {
            return new Bing();
        } else if (random == 10) {
            return new Facebook();
        } else {
            return null;
        }

    }

}

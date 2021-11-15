package main.java.svalley;

public class TechGiantFactory {

    public TechGiant randomTechGiant(int random) {

        if (random == 1) {
            return new Reader();
        } else if (random == 2) {
            return new SoundByte();
        } else if (random == 3) {
            return new PandaSuplex();
        } else if (random == 4) {
            return new Polygon();
        } else {
            return null;
        }

    }

}

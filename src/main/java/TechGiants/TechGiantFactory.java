package main.java.TechGiants;

public class TechGiantFactory {

    /**
     * Factory designed to determine tech giant type
     * at runtime.
     * @param random int to determine tech giant.
     * @return TechGiant type.
     */
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

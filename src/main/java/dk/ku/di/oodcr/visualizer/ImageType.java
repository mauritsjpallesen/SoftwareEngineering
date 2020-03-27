package dk.ku.di.oodcr.visualizer;

/***
 * @summary Defines the set of image types the DCRGraphVis can produce.
 */
public enum ImageType {
    PNG ("png"),
    JPG ("jpg");

    private final String name;

    ImageType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

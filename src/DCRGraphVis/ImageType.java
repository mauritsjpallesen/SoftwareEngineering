package DCRGraphVis;

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

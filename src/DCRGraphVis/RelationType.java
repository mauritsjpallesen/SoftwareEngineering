package DCRGraphVis;

public enum RelationType {
    Condition ("\u23FA"),
    Response ("\u23FA"),
    Milestone ("\u25C7"),
    Includes ("+"),
    Excludes ("%");

    private final String name;

    RelationType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

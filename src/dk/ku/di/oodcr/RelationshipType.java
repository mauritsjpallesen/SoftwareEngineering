package dk.ku.di.oodcr;

public enum RelationshipType {
    CONDITIONS("\u23FA"),
    RESPONSES("\u23FA"),
    MILESTONES ("\u25C7"),
    INCLUDES ("+"),
    EXCLUDES("%");

    private final String name;

    RelationshipType(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

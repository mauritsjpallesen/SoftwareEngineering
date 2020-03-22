package dk.ku.di.oodcr.graph;

public enum RelationshipType {
    CONDITIONS("\u23FA"),
    RESPONSES("\u23FA"),
    MILESTONES ("\u25C7"),
    INCLUDES ("\uFF0B"),
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

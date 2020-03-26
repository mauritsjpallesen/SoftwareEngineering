package dk.ku.di.oodcr.graph;

/**
 * Supported relationship types between two events (may be the same instance of event as well).
 */
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

    /**
     * Graphical unicode representation of the relationship type.
     * @return graphical unicode representation of the relationship type.
     */
    @Override
    public String toString() {
        return this.name;
    }
}

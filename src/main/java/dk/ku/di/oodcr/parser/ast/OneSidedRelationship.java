package dk.ku.di.oodcr.parser.ast;

import dk.ku.di.oodcr.graph.RelationshipType;

import java.util.List;

/**
 * Abstract syntactic tree structure containing parse of relationship between event which has not yet been resolved
 * and one or more events which are already known by names.
 * Only one side of relationship is known when the object is created. Whether source or target was resolved is indicated
 * by {@link VertexType}.
 */
public class OneSidedRelationship {
    private final RelationshipType relationshipType;
    private final VertexType type;
    private final List<String> vertexNames;

    public OneSidedRelationship(RelationshipType relationshipType, VertexType type, List<String> vertexNames){
        this.type = type;
        this.vertexNames = vertexNames;
        this.relationshipType = relationshipType;
    }

    public VertexType getVertexType() {
        return type;
    }

    public List<String> getVertexNames() {
        return vertexNames;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}

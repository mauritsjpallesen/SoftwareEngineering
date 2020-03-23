package dk.ku.di.oodcr.parser.ast;

import dk.ku.di.oodcr.graph.RelationshipType;

import java.util.List;

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

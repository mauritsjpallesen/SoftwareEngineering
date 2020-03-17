package Parser;

import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;
import dk.ku.di.oodcr.RelationshipType;

public class InputFileParser {
    public DCRGraph parse(String fileName) {
        return getDummyDcrGraph();
    }

    private DCRGraph getDummyDcrGraph() {
        var g = new DCRGraph();

        var e1 = new Event("e1 name", "e1 label");
        var e2 = new Event("e2 name", "e2 label");
        var e3 = new Event("e3 name", "e3 label");
        var e4 = new Event("e4 name", "e4 label");
        var e5 = new Event("e5 name", "e5 label");
        var e6 = new Event("e6 name", "e6 label");
        var e7 = new Event("e7 name", "e7 label");

        e2.marking.included = false;
        e2.marking.pending = true;
        e4.marking.executed = true;

        e1.addRelationship(RelationshipType.INCLUDES, e2);
        e2.addRelationship(RelationshipType.MILESTONES, e3);
        e3.addRelationship(RelationshipType.EXCLUDES, e4);
        e3.addRelationship(RelationshipType.EXCLUDES, e5);
        e4.addRelationship(RelationshipType.RESPONSES, e5);
        e5.addRelationship(RelationshipType.INCLUDES, e6);
        e6.addRelationship(RelationshipType.MILESTONES, e7);
        e7.addRelationship(RelationshipType.EXCLUDES, e1);

        g.events.put(e1.name, e1);
        g.events.put(e2.name, e2);
        g.events.put(e3.name, e3);
        g.events.put(e4.name, e4);
        g.events.put(e5.name, e5);
        g.events.put(e6.name, e6);
        g.events.put(e7.name, e7);

        return g;
    }
}

package dk.ku.di.oodcr;

import java.util.HashMap;

public class DCRGraph {
    public HashMap<String, Event> events = new HashMap<String, Event>();

    public DCRGraph() {
    }

    public Event addEvent(String n) {
        return addEvent(n, n);
    }

    public Event addEvent(String n, String l) {
        Event e = new Event(n, l);
        events.put(n, e);
        return e;
    }

    public void addEvent(Event e) {
        events.put(e.name, e);
    }

    public void addRelationship(String src, String trg, RelationshipType relationshipType) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(relationshipType, events.get(trg));
    }

    // These methods are here for backward compatibility, TODO refactor

    // src -->* trg
    public void addCondition(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.CONDITIONS, events.get(trg));
    }

    // src --><> trg
    public void addMilestone(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.MILESTONES, events.get(trg));
    }


    // src *--> trg
    public void addResponse(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.RESPONSES, events.get(trg));
    }


    // src -->+ trg
    public void addInclude(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.INCLUDES, events.get(trg));
    }


    // src -->% trg
    public void addExclude(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.EXCLUDES, events.get(trg));
    }


    public void execute(String e) {
        if (!events.containsKey(e))
            return;
        events.get(e).execute();
    }

    public Boolean isAccepting() {
        for (Event e : events.values())
            if (!e.isAccepting())
                return false;

        return true;
    }
}

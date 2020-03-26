package dk.ku.di.oodcr.graph;

import java.util.HashMap;

/**
 * DCR Graph encapsulates events and relationships between them
 */
public class DCRGraph {
    public HashMap<String, Event> events = new HashMap<>();

    public DCRGraph() {
    }

    /**
     * Adds event with name as its label.
     * @param n name of the event.
     * @return created event.
     */
    public Event addEvent(String n) {
        return addEvent(n, n);
    }

    /**
     * Adds event with name and a label.
     * @param n name of the event.
     * @param l label of the event.
     * @return created event.
     */
    public Event addEvent(String n, String l) {
        Event e = new Event(n, l);
        events.put(n, e);
        return e;
    }

    /**
     * Adds event to the graph.
     * @param e event to be added.
     */
    public void addEvent(Event e) {
        events.put(e.name, e);
    }

    /**
     * Creates relationship between two events already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     * @param relationshipType type of the relationship.
     */
    public void addRelationship(String src, String trg, RelationshipType relationshipType) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        if (relationshipType == RelationshipType.CONDITIONS || relationshipType == RelationshipType.MILESTONES)
            events.get(trg).addRelationship(relationshipType, events.get(src));
        else
            events.get(src).addRelationship(relationshipType, events.get(trg));
    }

    // src -->* trg
    /**
     * Adds condition relationship between source and target events which are already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     */
    public void addCondition(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(trg).addRelationship(RelationshipType.CONDITIONS, events.get(src));
    }

    // src --><> trg
    /**
     * Adds condition milestone between source and target events which are already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     */
    public void addMilestone(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(trg).addRelationship(RelationshipType.MILESTONES, events.get(src));
    }


    // src *--> trg
    /**
     * Adds condition response between source and target events which are already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     */
    public void addResponse(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.RESPONSES, events.get(trg));
    }


    // src -->+ trg
    /**
     * Adds condition include between source and target events which are already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     */
    public void addInclude(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.INCLUDES, events.get(trg));
    }


    // src -->% trg
    /**
     * Adds condition exclude between source and target events which are already contained in the graph.
     * @param src name of the source event.
     * @param trg name of the target event.
     */
    public void addExclude(String src, String trg) {
        if (!events.containsKey(src))
            return;

        if (!events.containsKey(trg))
            return;

        events.get(src).addRelationship(RelationshipType.EXCLUDES, events.get(trg));
    }


    /**
     * Executes event with given name if such is present in the graph, otherwise does nothing.
     * @param e name of the event to be executed.
     */
    public void execute(String e) {
        if (!events.containsKey(e))
            return;
        events.get(e).execute();
    }

    /**
     * Determines if the DCR graph is in accepting state.
     * @return {@code true} if every event in the graph is accepting, {@code false} otherwise.
     */
    public Boolean isAccepting() {
        for (Event e : events.values())
            if (!e.isAccepting())
                return false;

        return true;
    }
}

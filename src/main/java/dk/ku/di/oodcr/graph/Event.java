package dk.ku.di.oodcr.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Event {

	public UUID id;
	public String name;
	public String label;
	
	public Marking marking = new Marking(false, true, false);

	private HashMap<RelationshipType,HashSet<Event>> relationships;

	public Event(String n, String l)
	{
		id = UUID.randomUUID();
		name = n;
		label = l;
		relationships = new HashMap<>();
	}
	
	public Event(String n)
	{
		this(n, n);
	}

	public HashMap<RelationshipType, HashSet<Event>> getRelationships() {
		return relationships;
	}

	/**
	 * Adds new relationship with the event as target and {@code event} being source.
	 * @param relationshipType type of the newly created relationship.
	 * @param event target event.
	 */
	public void addRelationship(RelationshipType relationshipType, Event event) {
		relationships.putIfAbsent(relationshipType, new HashSet<>());

		relationships.get(relationshipType).add(event);
	}

	/**
	 * Determines if the event is enabled.
	 * @return {@code true} if event is enabled, {@code false} otherwise.
	 */
	public Boolean enabled()
	{
		if (!marking.included)
			return false;
		
		for (Event e : relationships.get(RelationshipType.CONDITIONS))
			if (e.marking.included && !e.marking.executed)
				return false;
		
		for (Event e : relationships.get(RelationshipType.MILESTONES))
			if (e.marking.included && e.marking.pending)
				return false;
		
		return true;
	}

	/**
	 * Executes the event and modify state of every dependent event.
	 */
	public void execute()
	{
		if(!enabled())
			return;
		
		marking.executed = true;
		marking.pending = false;
		
		for (Event e: relationships.get(RelationshipType.RESPONSES))
			e.marking.pending = true;
		
		for (Event e: relationships.get(RelationshipType.EXCLUDES))
			e.marking.included = false;

		for (Event e: relationships.get(RelationshipType.INCLUDES))
			e.marking.included = true;

	}

	/**
	 * Determines if the event is in accepting state.
	 * @return {@code true} if event is accepting, {@code false} otherwise.
	 */
	public boolean isAccepting()
	{
		return (!(marking.pending && marking.included));		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Event event = (Event) o;
		return Objects.equals(id, event.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

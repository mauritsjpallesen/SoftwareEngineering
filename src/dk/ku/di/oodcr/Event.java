package dk.ku.di.oodcr;

import java.util.HashMap;
import java.util.HashSet;

public class Event {
	
	
	public String name;
	public String label;
	
	public Marking marking = new Marking(false, true, false);

	private HashMap<RelationshipType,HashSet<Event>> relationships;

	public Event(String n, String l)
	{
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

	public void addRelationship(RelationshipType relationshipType, Event event) {
		relationships.putIfAbsent(relationshipType, new HashSet<>());

		relationships.get(relationshipType).add(event);
	}
	
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
		
		return;		
	}

	public boolean isAccepting()
	{
		return (!(marking.pending && marking.included));		
	}
}

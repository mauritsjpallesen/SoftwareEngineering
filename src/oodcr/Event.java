package oodcr;

import java.util.HashSet;
import java.util.UUID;

public class Event {
	
	public UUID id;
	public String name;
	public String label;
	
	public Marking marking = new Marking(false, true, false);
	
	public HashSet<Event> conditions = new HashSet<>();
	public HashSet<Event> responses = new HashSet<>();
	public HashSet<Event> milestones = new HashSet<>();
	public HashSet<Event> includes = new HashSet<>();
	public HashSet<Event> excludes = new HashSet<>();

	public Event(String n, String l)
	{
		id = UUID.randomUUID();
		name = n;
		label = l;
	}
	
	public Event(String n)
	{
		this(n, n);
	}	
	
	public Boolean enabled()
	{
		if (!marking.included)
			return false;
		
		for (Event e : conditions)
			if (e.marking.included && !e.marking.executed)
				return false;
		
		for (Event e : milestones)
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
		
		for (Event e: responses)
			e.marking.pending = true;
		
		for (Event e: excludes)
			e.marking.included = false;

		for (Event e: includes)
			e.marking.included = true;
		
		return;		
	}
	
	
	public boolean isAccepting()
	{
		return (!(marking.pending && marking.included));		
	}
	
	
}

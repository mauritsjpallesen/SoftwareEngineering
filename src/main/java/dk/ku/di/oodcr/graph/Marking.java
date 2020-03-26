package dk.ku.di.oodcr.graph;

/**
 * Markings of an event.
 * Event is at every moment in exactly one of possible 8 states - (not)executed/(not)included/(not)pending.
 */
public class Marking {
	
	public Boolean executed;
	public Boolean included;
	public Boolean pending;	

	public Marking(boolean ex, boolean in, boolean pe) {
		executed = ex;
		included = in;
		pending = pe;
	}
}

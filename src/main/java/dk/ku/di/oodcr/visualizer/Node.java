package dk.ku.di.oodcr.visualizer;

import dk.ku.di.oodcr.graph.Event;

import java.util.Objects;

/***
 * @summary This class is a simple extension of the event class used to draw the actual events.
 */
public class Node {

    public static final int Width = 100;
    public static final int Height = 130;
    public int X;
    public int Y;
    public Event Event;

    public Node(int x, int y, Event event) {
        if (event == null)
            throw new NullPointerException("Missing event");

        X = x;
        Y = y;
        Event = event;
    }

    /***
     * @summary Equals returns true if the reference of the node is the same or if the reference of the event it
     *          holds is the same reference as the other object (if the other object is also a Node)
     * @param The object to compare to.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() == o.getClass()) return ((Node)o).Event == Event;
        if (o.getClass() == dk.ku.di.oodcr.graph.Event.class) return o == Event;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, Event);
    }
}

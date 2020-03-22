package dk.ku.di.oodcr.visualizer;

import dk.ku.di.oodcr.graph.Event;

import java.util.Objects;

public class Node {

    public static final int Width = 70;
    public static final int Height = 70;
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

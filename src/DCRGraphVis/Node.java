package DCRGraphVis;

import dk.ku.di.oodcr.Event;

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
        if (this.getClass() == o.getClass()) return ((Node)o).Event.id == Event.id;
        if (o.getClass() == dk.ku.di.oodcr.Event.class) return ((Event)o).id == Event.id;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, Event);
    }
}

package DCRGraphVis;

import oodcr.Event;
import org.jgrapht.alg.drawing.model.Box2D;
import org.jgrapht.alg.drawing.model.LayoutModel2D;
import org.jgrapht.alg.drawing.model.Point2D;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LayoutModel implements LayoutModel2D<Event> {
    private Box2D drawingArea;
    private HashMap<Event, Point2D> os = new HashMap<Event, Point2D>();

    public LayoutModel(int numberOfEvents) {
        drawingArea = new Box2D(numberOfEvents * 100, numberOfEvents * 100);
    }

    @Override
    public Box2D getDrawableArea() {
        return drawingArea;
    }

    @Override
    public void setDrawableArea(Box2D box2D) {
        drawingArea = box2D;
    }

    @Override
    public Point2D get(Event o) {
        if (os.containsKey(o))
            return os.get(o);

        return null;
    }

    @Override
    public Point2D put(Event o, Point2D point2D) {
        if (os.containsKey(o)) {
            var prevPos = os.get(o);
            os.put(o, point2D);
            return prevPos;
        }

        os.put(o, point2D);
        return null;
    }

    @Override
    public void setFixed(Event o, boolean b) {

    }

    @Override
    public boolean isFixed(Event o) {
        return false;
    }

    @Override
    public Iterator<Map.Entry<Event, Point2D>> iterator() {
        return os.entrySet().iterator();
    }
}

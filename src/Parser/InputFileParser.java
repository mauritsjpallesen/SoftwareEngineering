package Parser;

import oodcr.DCRGraph;
import oodcr.Event;

public class InputFileParser {
    public DCRGraph parse(String fileName) {
        return getDummyDcrGraph();
    }

    private DCRGraph getDummyDcrGraph() {
        var g = new DCRGraph();

        var e1 = new Event("e1 name", "e1 label");
        var e2 = new Event("e2 name", "e2 label");
        var e3 = new Event("e3 name", "e3 label");
        var e4 = new Event("e4 name", "e4 label");

        e2.marking.included = false;
        e2.marking.pending = true;
        e4.marking.executed = true;

        e1.includes.add(e2);
        e2.milestones.add(e4);
        e3.excludes.add(e4);
        e3.excludes.add(e1);
        e4.responses.add(e1);

        g.events.put(e1.name, e1);
        g.events.put(e2.name, e2);
        g.events.put(e3.name, e3);
        g.events.put(e4.name, e4);

        return g;
    }
}

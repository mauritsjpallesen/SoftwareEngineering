package dk.ku.di.oodcr.parser;

import Parser.DCRGraphGrammarLexer;
import Parser.DCRGraphGrammarParser;
import Parser.OneSidedRelationship;
import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;
import dk.ku.di.oodcr.RelationshipType;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

class DCRGraphGrammarParserTest {

    private DCRGraphGrammarParser setupParser(String inputString) {

        InputStream stream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));

        DCRGraphGrammarLexer lexer = null;
        try {
            lexer = new DCRGraphGrammarLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DCRGraphGrammarParser parser = new DCRGraphGrammarParser(tokens);

        parser.setInputStream(new CommonTokenStream(lexer));

        return parser;
    }

    @Test
    void oneSimpleEventGraphTest() {
        DCRGraphGrammarParser parser = setupParser("e(1,1,0)");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(1, graph.events.size());
    }

    @Test
    void oneGraphTest() {
        DCRGraphGrammarParser parser = setupParser("e(1,1,0)");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(1, graph.events.size());
    }

    @Test
    void graphTest() {
        DCRGraphGrammarParser parser = setupParser("e1(0,1,0),\n" +
                "e2<A>(1,1,0),\n" +
                "e3(0,1,0){\n" +
                "  *--> e3\n" +
                "  -->+ e2\n" +
                "},\n" +
                "e4<B>(0,0,1){\n" +
                "  e1 -->* \n" +
                "  -->% (e4,e2)\n" +
                "  -->+ e1\n" +
                "}");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(4, graph.events.size());

        // TODO test the relationships
    }

    @Test
    void eventLabelTest() {
        DCRGraphGrammarParser parser = setupParser("e2<A>(0,0,0)");

        Event event = parser.event().value;

        Assertions.assertEquals("e2",event.name);
        Assertions.assertEquals("A",event.label);

        Assertions.assertEquals(false,event.marking.pending);
        Assertions.assertEquals(false,event.marking.included);
        Assertions.assertEquals(false,event.marking.executed);

    }

    @Test
    void relationshipsTest() {
        DCRGraphGrammarParser parser = setupParser(
                "*-->e3\n" +
                "-->+e2\n" +
                "e1-->*\n" +
                "-->%(e4,e2)\n" +
                "-->+e1\n"
                );


        List<OneSidedRelationship> rels = parser.relationships().value;

        Assertions.assertEquals(5,rels.size());
    }

    /* TESTING GRAPH SIZES */
    @Test
    void emptyGraphTest() {
        DCRGraphGrammarParser parser = setupParser("");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(0, graph.events.size());
    }

    @Test
    void sizeOneGraphTest() {
        DCRGraphGrammarParser parser = setupParser("e(1,1,0)");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(1, graph.events.size());
    }

    @Test
    void sizeFiveGraphTest() {
        DCRGraphGrammarParser parser = setupParser(
                "e1(1,1,0),\n" +
                "e2(1,1,0),\n" +
                "e3(1,1,0),\n" +
                "e4(1,1,0),\n" +
                "e5(1,1,0)\n"
                );

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(5, graph.events.size());
    }

    @Test
    void sizeTenGraphTest() {
        DCRGraphGrammarParser parser = setupParser(
                "e1(1,1,0),\n" +
                "e2(1,1,0),\n" +
                "e3(1,1,0),\n" +
                "e4(1,1,0),\n" +
                "e5(1,1,0),\n" +
                "e6(1,1,0),\n" +
                "e7(1,1,0),\n" +
                "e8(1,1,0),\n" +
                "e9(1,1,0),\n" +
                "e10(1,1,0)\n"
                );

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(10, graph.events.size());
    }

    /* TESTING EVENT MARKINGS */
    @Test
    void eventMarkingsTest000() {
        DCRGraphGrammarParser parser = setupParser("e(0,0,0)");

        Event event = parser.event().value;

        Assertions.assertEquals(false,event.marking.executed);
        Assertions.assertEquals(false,event.marking.included);
        Assertions.assertEquals(false,event.marking.pending);
    }

    @Test
    void eventMarkingsTest001() {
        DCRGraphGrammarParser parser = setupParser("e(0,0,1)");

        Event event = parser.event().value;

        Assertions.assertEquals(false,event.marking.executed);
        Assertions.assertEquals(false,event.marking.included);
        Assertions.assertEquals(true,event.marking.pending);
    }

    @Test
    void eventMarkingsTest011() {
        DCRGraphGrammarParser parser = setupParser("e(0,1,1)");

        Event event = parser.event().value;

        Assertions.assertEquals(false,event.marking.executed);
        Assertions.assertEquals(true,event.marking.included);
        Assertions.assertEquals(true,event.marking.pending);
    }

    @Test
    void eventMarkingsTest111() {
        DCRGraphGrammarParser parser = setupParser("e(1,1,1)");

        Event event = parser.event().value;

        Assertions.assertEquals(true,event.marking.executed);
        Assertions.assertEquals(true,event.marking.included);
        Assertions.assertEquals(true,event.marking.pending);
    }

    @Test
    void eventMarkingsTest010() {
        DCRGraphGrammarParser parser = setupParser("e(0,1,0)");

        Event event = parser.event().value;

        Assertions.assertEquals(false,event.marking.executed);
        Assertions.assertEquals(true,event.marking.included);
        Assertions.assertEquals(false,event.marking.pending);
    }

    @Test
    void eventMarkingsTest110() {
        DCRGraphGrammarParser parser = setupParser("e(1,1,0)");

        Event event = parser.event().value;

        Assertions.assertEquals(true,event.marking.executed);
        Assertions.assertEquals(true,event.marking.included);
        Assertions.assertEquals(false,event.marking.pending);
    }

    @Test
    void eventMarkingsTest100() {
        DCRGraphGrammarParser parser = setupParser("e(1,0,0)");

        Event event = parser.event().value;

        Assertions.assertEquals(true,event.marking.executed);
        Assertions.assertEquals(false,event.marking.included);
        Assertions.assertEquals(false,event.marking.pending);
    }

    @Test
    void eventMarkingsTest101() {
        DCRGraphGrammarParser parser = setupParser("e(1,0,1)");

        Event event = parser.event().value;

        Assertions.assertEquals(true,event.marking.executed);
        Assertions.assertEquals(false,event.marking.included);
        Assertions.assertEquals(true,event.marking.pending);
    }

    /* TESTING RELATIONS */

    @Test
    void conditions() {
        DCRGraphGrammarParser parser = setupParser(
                "-->*e3\n"
                 );
        OneSidedRelationship rel = parser.relationship().value;

        Assertions.assertEquals(RelationshipType.CONDITIONS, rel.getRelationshipType());
    }

    @Test
    void milestones() {
        DCRGraphGrammarParser parser = setupParser(
                "--><>e3\n"
        );
        OneSidedRelationship rel = parser.relationship().value;

        Assertions.assertEquals(RelationshipType.MILESTONES, rel.getRelationshipType());
    }

    @Test
    void responses() {
        DCRGraphGrammarParser parser = setupParser(
                "*-->e3\n"
        );
        OneSidedRelationship rel = parser.relationship().value;

        Assertions.assertEquals(RelationshipType.RESPONSES, rel.getRelationshipType());
    }

    @Test
    void includes() {
        DCRGraphGrammarParser parser = setupParser(
                "-->+e3\n"
        );
        OneSidedRelationship rel = parser.relationship().value;

        Assertions.assertEquals(RelationshipType.INCLUDES, rel.getRelationshipType());
    }

    @Test
    void excludes() {
        DCRGraphGrammarParser parser = setupParser(
                "-->%e3\n"
        );
        OneSidedRelationship rel = parser.relationship().value;

        Assertions.assertEquals(RelationshipType.EXCLUDES, rel.getRelationshipType());
    }

    /*
    @Test
    void relationship() {
    }

    @Test
    void eventLabel() {
    }

    @Test
    void idOneOrMore() {
    }

    @Test
    void idSeq() {
    }*/
}
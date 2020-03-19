package dk.ku.di.oodcr.parser;

import dk.ku.di.oodcr.DCRGraph;
import dk.ku.di.oodcr.Event;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void emptyGraphTest() {
        DCRGraphGrammarParser parser = setupParser("");

        DCRGraph graph = parser.graph().value;

        Assertions.assertEquals(0, graph.events.size());
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

    /*
    @Test
    void relationship() {
    }

    @Test
    void conditions() {
    }

    @Test
    void milestones() {
    }

    @Test
    void responses() {
    }

    @Test
    void includes() {
    }

    @Test
    void excludes() {
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
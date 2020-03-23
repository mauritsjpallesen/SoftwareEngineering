grammar DCRGraphGrammar;

@header{
import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
}


@members {
    HashMap<String,List<SimpleEntry<RelationshipType,String>>> srcToTrgts = new HashMap<>();
    HashMap<String, Event> allEvents = new HashMap<String, Event>();
}

graph returns [DCRGraph value]
@init {
    $value = new DCRGraph();
}
    : WS* e=event es=eventz {
            $value.addEvent($e.value);
            $es.value.forEach(e -> $value.addEvent(e));


            for (Entry<String, List<SimpleEntry<RelationshipType,String>>> srcTrgtsPair : srcToTrgts.entrySet()) {
                Event sourceEvent = allEvents.get(srcTrgtsPair.getKey());
                for (SimpleEntry<RelationshipType,String> relToTrgt  : srcTrgtsPair.getValue()) {
                    RelationshipType relationshipType = relToTrgt.getKey();
                    Event targetEvent = allEvents.get(relToTrgt.getValue());
                    sourceEvent.addRelationship(relationshipType, targetEvent);
                }
            }
        }
    | EOF
    ;

eventz returns [List<Event> value]
@init {
    $value = new ArrayList<Event>();
}
    : ',' WS* NEWLINE WS*  e=event ez=eventz {
            $value.add($e.value);
            $value.addAll($ez.value);
        }
    | EOF
    ;




event returns [Event value]
    : ID WS* el=eventLabel? '(' WS* ex=ONEorZERO WS* ',' WS* in=ONEorZERO WS* ',' WS* pen=ONEorZERO WS* ')' WS*
        ('{'NEWLINE WS* rs=relationships '}' WS* )?
        {

            $value = (_localctx.el == null) ? new Event($ID.text) : new Event($ID.text, $el.value);

            $value.marking.executed = Integer.parseInt($ex.text) == 1;
            $value.marking.included = Integer.parseInt($in.text) == 1;
            $value.marking.pending = Integer.parseInt($pen.text) == 1;

            allEvents.put($value.name, $value);

            if (_localctx.rs != null) {
                for (OneSidedRelationship rel : $rs.value) {
                    if (rel.getVertexType() == VertexType.TARGET) { // $value is source then
                        srcToTrgts.putIfAbsent($value.name, new ArrayList<SimpleEntry<RelationshipType,String>>());

                        RelationshipType relType = rel.getRelationshipType();

                        for (String target : rel.getVertexNames()) {
                            srcToTrgts.get($value.name).add(new SimpleEntry<RelationshipType,String>(relType, target));
                        }

                    } else { // $value is target then
                        RelationshipType relType = rel.getRelationshipType();

                        for (String source : rel.getVertexNames()) {
                            srcToTrgts.putIfAbsent(source, new ArrayList<SimpleEntry<RelationshipType,String>>());

                            srcToTrgts.get(source).add(new SimpleEntry<RelationshipType,String>(relType, $value.name));
                        }
                    }
                }
            }
        }
    ;

relationships returns [List<OneSidedRelationship> value]
@init {
    $value = new ArrayList<OneSidedRelationship>();
}
    : r=relationship NEWLINE WS* rs=relationships { $value.add($r.value); $value.addAll($rs.value); }
    | WS* // Epsilon
    ;

relationship returns [OneSidedRelationship value]
    : c=conditions { $value = $c.value; }
    | m=milestones { $value = $m.value; }
    | r=responses { $value = $r.value; }
    | i=includes { $value = $i.value; }
    | e=excludes { $value = $e.value; }
    ;

conditions returns [OneSidedRelationship value]
    : ids=idOneOrMore '-->*' WS* { $value = new OneSidedRelationship(RelationshipType.CONDITIONS, VertexType.SOURCE, $ids.value); }
    | '-->*' WS* ids=idOneOrMore { $value = new OneSidedRelationship(RelationshipType.CONDITIONS, VertexType.TARGET, $ids.value); }
    ;

milestones returns [OneSidedRelationship value]
    : ids=idOneOrMore '--><>' WS* { $value = new OneSidedRelationship(RelationshipType.MILESTONES, VertexType.SOURCE, $ids.value); }
    | '--><>' WS* ids=idOneOrMore { $value = new OneSidedRelationship(RelationshipType.MILESTONES, VertexType.TARGET, $ids.value); }
    ;

responses returns [OneSidedRelationship value]
    : ids=idOneOrMore '*-->' WS* { $value = new OneSidedRelationship(RelationshipType.RESPONSES, VertexType.SOURCE, $ids.value); }
    | '*-->' WS* ids=idOneOrMore { $value = new OneSidedRelationship(RelationshipType.RESPONSES, VertexType.TARGET, $ids.value); }
    ;


includes returns [OneSidedRelationship value]
    : ids=idOneOrMore '-->+' WS* { $value = new OneSidedRelationship(RelationshipType.INCLUDES, VertexType.SOURCE, $ids.value); }
    | '-->+' WS* ids=idOneOrMore { $value = new OneSidedRelationship(RelationshipType.INCLUDES, VertexType.TARGET, $ids.value); }
    ;


excludes returns [OneSidedRelationship value]
    : ids=idOneOrMore '-->%' WS* { $value = new OneSidedRelationship(RelationshipType.EXCLUDES, VertexType.SOURCE, $ids.value); }
    | '-->%' WS* ids=idOneOrMore { $value = new OneSidedRelationship(RelationshipType.EXCLUDES, VertexType.TARGET, $ids.value); }
    ;

eventLabel returns [String value]
    : '<' WS* ID WS* '>' WS* { $value = $ID.text; }
    ;

idOneOrMore returns [List<String> value]
@init {
    $value = new ArrayList<String>();
}
    : ID WS* { $value.add($ID.text); }
    | '(' WS* ID WS* i=idSeq ')' WS* { $value.add($ID.text); $value.addAll($i.value); }
    ;

idSeq returns [List<String> value]
@init {
    $value = new ArrayList<String>();
}
    : ',' WS* ID WS* is=idSeq { $value.add($ID.text); $value.addAll($is.value); }
    | WS* // Epsilon
    ;


ONEorZERO: '0' | '1' ;
ID: (CHAR|INT)+ ;
CHAR:  ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t') ;
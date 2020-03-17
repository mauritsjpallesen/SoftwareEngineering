grammar DCRGraphGrammar;

@header{
package dk.ku.di.oodcr.parser;
import dk.ku.di.oodcr.*;
import java.util.HashMap;
}


@members {
// TODO store all events so that they can be referenced

HashMap<RelationshipType,HashSet<Event>> relationships = new HashMap<>();

}

graph returns [DCRGraph value]
    : event ',' graph { $value = $graph; $value.add($event); }
    |  event { $value = new ArrayList<DCRGraph>(); $value.addEvent($event); }
    ;

event returns [Event value]
    : ID eventLabel? '(' ONEorZERO','ONEorZERO','ONEorZERO')' relationships*
        {$value = new Event($ID.text, $eventLabel); //TODO if no event label
         $v}
    ;

relationships returns [Event ]
    : '{' relationship+ '}'
    ;

relationship returns
    : conditions | milestones | responses | includes | excludes
    ;

conditions: ID '-->*' { }
    | '-->*' ID
    ;

milestones: ID '--><>'
    | '--><>' ID
    ;

responses: ID '*-->'
    | '*-->' ID
    ;


includes: ID '-->+'
    | '-->+' ID
    ;


excludes: ID '-->%'
    | '-->%' ID
    ;

eventLabel returns [String value]
    : '<' ID '>' { $value = $ID.text; }
    ;

ONEorZERO: '0' | '1'
    ;

ID:   ('a'..'z'|'A'..'Z')+
    ;
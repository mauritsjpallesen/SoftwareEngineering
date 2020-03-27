package dk.ku.di.oodcr.visualizer;

/***
 * @summary Slightly poor name. This indicates where on a relationship arrow something should be drawn.
 *          Useful because the response relation requires the relationship symbol to be drawn at the
 *          start of the arrow, while all others requires that it be drawn at the end.
 *          This class increases readability in other code.
 */
public enum RelativePosition {
    Start,
    End
}

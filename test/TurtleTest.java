import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turtle.Directions;
import turtle.Turtle;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {
    private Turtle turtle;

    @BeforeEach
    public void setUp(){

        turtle = new Turtle();
    }

    @Test
    void testThatPenIsUp(){
        assertTrue(turtle.penIsUp());
    }
    @Test
    void testTurtleCanMovePenDown(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        assertFalse(turtle.penIsUp());
    }

    @Test
    void testPensCurrentHasDirection(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        assertFalse(turtle.penIsUp());
        turtle.setCurrentDirection(Directions.EAST);
        assertSame(Directions.EAST, turtle.getCurrentDirection());
    }

    @Test
    void testPenCanTurnLeftToTheNorth(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        turtle.setCurrentDirection(Directions.EAST);
        assertSame(Directions.EAST, turtle.getCurrentDirection());
        turtle.turnLeft(Directions.EAST);
        assertSame(Directions.NORTH, turtle.getCurrentDirection());

    }

    @Test
    void testPenCanTurnLeftToTheWest(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        assertSame(Directions.EAST, turtle.getCurrentDirection());
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(Directions.WEST, turtle.getCurrentDirection());

    }

    @Test
    void testPenCanTurnLeftToTheSouth(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        assertSame(Directions.EAST, turtle.getCurrentDirection());
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(Directions.WEST, turtle.getCurrentDirection());

    }

    @Test
    void testPenCanTurnLeftToTheEast(){
        assertTrue(turtle.penIsUp());
        turtle.penIsDown();
        assertSame(Directions.EAST, turtle.getCurrentDirection());
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(Directions.WEST, turtle.getCurrentDirection());

    }
}

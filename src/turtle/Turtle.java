package turtle;

public class Turtle {
    private Directions currentDirection;
    private boolean isPenUp = true;

    public boolean penIsUp() {
        return isPenUp;
    }

    public void penIsDown() {
         isPenUp = false;
    }

    public Directions getCurrentDirection() {
        return currentDirection;
    }

    public void turnLeft(Directions currentDirection) {
      Directions.setDirections(Directions.EAST, TurnDirection.LEFT);
    }

    public void setCurrentDirection(Directions sample){
        this.currentDirection = sample;

    }
}

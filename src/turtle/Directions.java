package turtle;

public enum Directions{
    EAST("NORTH", "SOUTH"),
    NORTH("EAST", "WEST"),
    WEST ("NORTH", "SOUTH"),
    SOUTH("EAST", "WEST");
    private final String left;
    private final String right;
    Directions(String left, String right){
        this.left = left;
        this.right = right;

    }

    public static Directions setDirections(Directions currentDirection, TurnDirection turnDirection) {
        return switch (currentDirection) {
            case EAST -> turnDirection == TurnDirection.LEFT ? Directions.NORTH : Directions.SOUTH;
            case NORTH -> turnDirection == TurnDirection.LEFT ? Directions.WEST : Directions.EAST;
            case WEST -> turnDirection == TurnDirection.LEFT ? Directions.SOUTH : Directions.NORTH;
            case SOUTH -> turnDirection == TurnDirection.LEFT ? Directions.EAST : Directions.WEST;
            default -> throw new IllegalArgumentException(STR."Invalid direction: \{currentDirection}");
        };
    }

}

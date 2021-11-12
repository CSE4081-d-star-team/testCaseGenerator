package src.setup;

public class CharSet {
    public static char ROBOT = 'R';
    public static char GOAL = 'G';
    public static char OBSTACLE = 'X';
    public static char EMPTY_CELL = ' ';
    public static char WALL = 'W';

    public static boolean isRobot (char comp) {
        return comp == ROBOT ? true : false;
    }

    public static boolean isGoal (char comp) {
        return comp == GOAL ? true : false;
    }

    public static boolean isObstacle (char comp) {
        return comp == OBSTACLE ? true : false;
    }

    public static boolean isEmptyCell (char comp) {
        return comp == EMPTY_CELL ? true : false;
    }

    public static boolean isWall (char comp) {
        return comp == WALL ? true : false;
    }
}

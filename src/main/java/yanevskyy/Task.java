package yanevskyy;

/**
 * Реализует действие над принимаемой доской заявок.
 */
public interface Task {
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu;
}

package yanevskyy;


/**
 * Запускаемый файл.
 */
public class Tracker {

    public static void main(String[] args) {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        boolean run = true;
        consoleMenu.hello();
        while (run){
            try {
                consoleMenu.startProgram();
            } catch (CloseProgram closeProgram) {
                run = false;
            }
        }
    }
}

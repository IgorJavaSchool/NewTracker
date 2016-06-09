package yanevskyy;

import yanevskyy.performance.*;

import java.io.*;

/**
 * Принимает и отправляет запросы в консоль
 */
public class ConsoleMenu extends ReadWrite{

    /**
     * Доска запрсов
     */
    BoardItems boardItems;
    Actions actions;
    Task[] tasks;

    /**
     * Создаёт доску запросов для дальнейшей передачи.
     */
    public ConsoleMenu() {
        boardItems = new BoardItems();
        tasks = new Task[]{new Create(),new Edit(), new Delete(), new AllItems(),
        new FilterItems(), new AddComment()};
    }



    /**
     * Приветствует пользователя
     */
    public void hello() {
        try {
            readFile("Hello.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отображает главное меню пользователя
     * @throws CloseProgram Вызывает механизм закрытия программы
     */
    public void startProgram() throws CloseProgram {
        boolean stopMenu;
        do {
            stopMenu = true;
            try {
                readFile("Select.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                trySelectProcessor();
            } catch (InMenu inMenu) {
                writeMessage("Операция прервана");
                stopMenu = true;
            }
        } while (!stopMenu);
    }

    /**
     * Принимает выбор операции пользователя, проверяет на валидность,
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    public void trySelectProcessor() throws CloseProgram, InMenu {
        boolean valid = false;
        do {
            try {
                actions = Actions.selectionsAction(readMessage());
                valid = true;
            } catch (IncorrectData e) {
                writeMessage("Не корректные данные. Попробуйте снова");
            }
        } while (!valid);
        selectProcessor(actions);
    }

    /**
     * Создаёт процесс в зависимости от выбранной пользователем операции.
     * @param actions Выбранная операция.
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    private void selectProcessor(Actions actions) throws CloseProgram, InMenu {
        switch (actions){
            case CREATE:      tasks[0].performance(boardItems);
                break;
            case EDIT:        tasks[1].performance(boardItems);
                break;
            case DELETE:       tasks[2].performance(boardItems);
                break;
            case ALL:         tasks[3].performance(boardItems);
                break;
            case FILTER:      tasks[4].performance(boardItems);
                break;
            case ADD_COMMENT: tasks[5].performance(boardItems);
                break;
            case EXIT: throw new CloseProgram();
        }

    }

}

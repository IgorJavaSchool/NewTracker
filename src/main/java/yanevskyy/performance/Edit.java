package yanevskyy.performance;

import yanevskyy.*;

/**
 * Изменяет выбранную по ID заявку.
 */
public class Edit extends ReadWrite implements Task {

    /**
     * Запрашивает ID заявки, предлагает на выбор изменить
     * имя или описание выбранной заявки.
     * @param boardItems Принимаемая доска заявок
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    @Override
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu {
        if (!boardItems.checkLengthItems())
            return;

        int itemNum = new FilterItems().findItemId(boardItems);
        writeMessage("Изменение заявки №" + boardItems.items[itemNum].getID() + " Сделайте выбор:");
        writeMessage("1 - Изменить имя заявки. 2 - Изменить описание");
        switch (readMessage()){
            case "1": boardItems.items[itemNum].setName(new Create().createName());
                break;
            case "2": boardItems.items[itemNum].setDiscription(new Create().createDescription());
                break;
            default: break;
        }

    }
}

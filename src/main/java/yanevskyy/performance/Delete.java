package yanevskyy.performance;

import yanevskyy.*;

/**
 * Удаляет заявку по указанному ID
 */
public class Delete extends ReadWrite implements Task {

    /**
     * Удаляет выбраную по ID заявку из массива,
     * приходится извращатся т.к. Пётр не разрешил использовать ArrayList.
     * @param boardItems
     * @throws CloseProgram
     * @throws InMenu
     */
    @Override
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu {
        if (!boardItems.checkLengthItems())
            return;

        int lengthItems = 0;
        int itemNum = new FilterItems().findItemId(boardItems);
        Item[] itemsNew = new Item[boardItems.items.length - 1];
        for (int i = 0; i < boardItems.items.length; i++) {
            if (i != itemNum) {
                itemsNew[lengthItems] = boardItems.items[i];
                lengthItems++;
            }
        }
        boardItems.setItems(itemsNew);
        writeMessage("Заявка ID" + (itemNum + 1) + " с именем "
                + boardItems.items[itemNum].getName() + " - УДАЛЕНА");
    }

}

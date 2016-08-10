package yanevskyy.performance;

import yanevskyy.*;

/**
 * Добавляет от одной до нескольких комментариев к одной заявке
 */
public class AddComment extends ReadWrite implements Task {

    /**
     * Проверяеи наличие заявки, добавляет комментарий к заявке
     * @param boardItems Принимаемая доска заявок
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    @Override
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu {
        if (!boardItems.checkLengthItems())
            return;

        FilterItems filterItems = new FilterItems();
        int itemId;
        String comment;
        writeMessage("К одной заявке можно добавить несколько комментариев");
        itemId = filterItems.findItemId(boardItems);
        do {
            writeMessage("Укажите свой комментарий");
            comment = readMessage();
            addComments(boardItems.items[itemId], comment);
        } while (askAddComment());
    }

    /**
     * Запрвшивает о необходимости добавления ещё одного комментария к текущей заявке.
     * @return Возвращает ответ пользователя
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    private boolean askAddComment() throws CloseProgram, InMenu {
        while (true){
            writeMessage("Хотите добавить ещё комментарий? 0 - ДА. 1 - НЕТ");
            switch (Integer.parseInt(readMessage())){
                case 0 : return true;
                case 1 : return false;
                default:
            }
        }
    }

    /**
     * Добавляет новый комментарий в передаваемую заявку,
     * изменяет список комментариев переданной заявки.
     * @param item передаваемая заявка
     * @param comment комментарий для добавления
     */
    public void addComments(Item item, String comment){
        Comment[] comentsNew = new Comment[item.getListComment().length + 1];
        for (int i = 0; i < item.getListComment().length; i++) {
            comentsNew[i] = new Comment(item.getListComment()[i].getCommentMessage());
        }
        comentsNew[item.getListComment().length] = new Comment(comment);
        item.setListComment(comentsNew);
    }
}

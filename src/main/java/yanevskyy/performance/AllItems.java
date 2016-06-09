package yanevskyy.performance;

import yanevskyy.*;

/**
 * Отображает полный список заявок в формате ID - дата - имя - описание -
 * список комментариев если присутствует.
 */
public class AllItems extends ReadWrite implements Task {

    /**
     * Отображает полный список заявок.
     * @param boardItems Принимаемая доска заявок
     */
    @Override
    public void performance(BoardItems boardItems) {
        if (!boardItems.checkLengthItems())
            return;
        topTable();
        for (Item item : boardItems.items) {
            displayItem(item);
        }
        footerTable();
    }

    /**
     * Отображает заголовок таблицы
     */
    public void topTable(){
        writeMessage("-----------------------------------------------------" +
                "-----------------------------------------------------");
        writeMessage(String.format("%-15s%-3s%-6s%-3s%-50s%-3s%-50s","Дата создания", "|", "ID", "|", "Имя заявки", "|", "Описание заявки"));
        writeMessage("-----------------------------------------------------" +
                "-----------------------------------------------------");
    }

    /**
     * Отображает футер таблицы
     */
    public void footerTable(){
        writeMessage("-----------------------------------------------------" +
                "-----------------------------------------------------");
    }

    /**
     * Отображает информацию принимаемой заявки,
     * проверяет наличие комментакиев.
     * @param item принимаемая заявка.
     */
    public void displayItem(Item item){
        writeMessage(String.format("%-15s%-3s%-6s%-3s%-50s%-3s%-50s",item.getDateCreation(),"|", item.getID(),
                "|", item.getName(), "|", item.getDiscription()));
        if (item.getListComment().length > 0) {
            checkComment(item);
        }
    }

    /**
     * Отображает все найденные комментарии.
     * @param item принимаемая заявка.
     */
    public void checkComment(Item item){
            writeMessage(String.format("%-15s%-1s%-6s%-24s%-3s%-6s"," ", "|", " ", "Комментарии к заявке ID ", item.getID(), ":"));
            for (Comment comment : item.getListComment()) {
                writeMessage(String.format("%-15s%-1s%-6s%-1s%-50s"," ", "|", " ", "+", comment.getCommentMessage()));
        }
    }
}

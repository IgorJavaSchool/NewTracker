package yanevskyy;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Заявка, основной объект программы.
 */
public class Item extends ReadWrite {

    /**
     * ID, имя, описание, дата создания и список всех коментариев заявки.
     */
    private final int ID;
    private String name;
    private String discription;
    private GregorianCalendar dateCreation;
    private Comment[] listComment;

    /**
     * Генерирует дату создания заявки
     * @param ID уникальный идентификатор заявки
     * @param name имя заявки содержит только буквы и пробелы.
     * @param discription содержание заявки.
     */
    public Item(int ID, String name, String discription) {
        this.ID = ID;
        this.name = name;
        this.discription = discription;
        dateCreation = new GregorianCalendar();
        listComment = new Comment[0];
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * Генерирует дату
     * @return возвращает в указаном формате.
     */
    public String getDateCreation() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        return formatDate.format(dateCreation.getTime());
    }

    public Comment[] getListComment() {
        return listComment;
    }

    /**
     * Добавляет новый комментарий в передаваемую заявку,
     * изменяет список комментариев переданной заявки.
     * @param item передаваемая заявка
     * @param comment комментарий для добавления
     */
    public void addComments(Item item, String comment){
        Comment[] comentsNew = new Comment[item.listComment.length + 1];
        for (int i = 0; i < item.listComment.length; i++) {
            comentsNew[i] = new Comment(item.listComment[i].getCommentMessage());
        }
        comentsNew[item.listComment.length] = new Comment(comment);
        item.listComment = comentsNew;
    }
}

package yanevskyy;

/**
 * Хранит все заявки на протяжении работы программы.
 */
public class BoardItems extends ReadWrite {

    /**
     * Заявка, уникальный ID, список всех заявок
     */
    public Item item;
    public int id;
    public Item[] items;

    /**
     * Создаёт стартовые данные
     */
    public BoardItems() {
        this.id = 0;
        this.items = new Item[0];
    }

    /**
     * Присваевает списку заявок новые данные
     * @param items принимаемый список заявок.
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * Проверяет наличие заявок в общем списке
     * @return результат истинны.
     */
    public boolean checkLengthItems(){
        if (items.length < 1){
            writeMessage("Список заявок пуст");
            return false;
        } else return true;
    }
}

package yanevskyy.performance;
import yanevskyy.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Создаёт новую заявку
 */
public class Create extends ReadWrite implements Task {

    /**
     * Создаёт новую заявку и генерирует её ID
     * @param boardItems Принимаемая доска заявок
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    @Override
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu {
        String nameItem = createName();
        String descriptionItem = createDescription();
        boardItems.id++;
        boardItems.item = new Item(boardItems.id, nameItem, descriptionItem);
        boardItems.items = createItemArray(boardItems.items, boardItems.item);
        writeMessage("Добавлена заявка ID" + boardItems.id);
    }

    /**
     * Запрашивает у пользователя, проверяет валидность и создаёт
     * новое имя принимаемой заявки
     * @return возвращает созданное имя.
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    protected String createName() throws CloseProgram, InMenu {
        String name;
        Pattern regexpName = Pattern.compile("([A-Za-zА-Яа-я\\s])*");
        Matcher math;
        do {
            writeMessage("Напишите название заявки (Используйте только буквы)");
            name = readMessage();
            math = regexpName.matcher(name);
        } while (!math.matches());
        return name;
    }

    /**
     * Запрашивает у пользователя, создаёт описание.
     * @return возвращает строку описания.
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    protected String createDescription() throws CloseProgram, InMenu {
        writeMessage("Укажите описание в произвольной форме");
        return readMessage();
    }

    /**
     * Корректирует размер массива заявок, добавляет в переданные массив
     * новосозданную заявку.
     * @param array массив заявок.
     * @param it созданная заявка
     * @return возвращает массив с учётом изиенений
     */
    protected Item[] createItemArray(Item[] array, Item it){
        Item[] newArray = new Item[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = it;
        return newArray;
    }
}

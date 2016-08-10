package yanevskyy.performance;

import yanevskyy.*;

/**
 * Находит заявки по ID или фрагменту фразы из имени или описания, отображает найденные
 *
 */
public class FilterItems extends ReadWrite implements Task {

    /**
     * Находит и отображает заявки по фрагменту фразы из имени или описания
     * @param boardItems Принимаемая доска заявок
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    @Override
    public void performance(BoardItems boardItems) throws CloseProgram, InMenu {
        if (!boardItems.checkLengthItems())
            return;

        writeMessage("Напишите слово или фразу для отбора");
        String filter = readMessage();
        AllItems allItems = new AllItems();
        int countF = 0;
        for (Item item : boardItems.items) {
            if (item.getName().contains(filter) || item.getDiscription().contains(filter)) {
                countF++;
                if (countF == 1) {
                    allItems.topTable();
                }
                allItems.displayItem(item);
            }
        }
        if (countF > 0) {
            writeMessage("По фильтру "+ endNumber(countF));
            allItems.footerTable();
        } else {
            writeMessage("По данному фрагменту ничего не найдено");
        }
    }

    /**
     * Осуществляет поиск заявок по ID, проверяет наличие
     * @param boardItems Принимаемая доска заявок
     * @return ID заявки
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    public int findItemId(BoardItems boardItems) throws CloseProgram, InMenu {
        int idItem = 0;
        int idFilter = -1;
        boolean contains = false;
        do {
            idFilter = enterId(idFilter);
            for (int i = 0; i < boardItems.items.length; i++) {
                if (idFilter == boardItems.items[i].getID()) {
                    contains = true;
                    idItem = i;
                    break;
                }
            }
            if (!contains)
                writeMessage("Заявки с таким ID не существует. Попроьуйте снова");
        } while (!contains);
        return idItem;
    }

    /**
     * Просит ввести данные ID, проверяет валидность
     * @param searchId ID для проверки на валидность.
     * @return ID
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    public int enterId(int searchId) throws CloseProgram, InMenu {
        boolean trying = false;
        while (!trying) {
            writeMessage("Введите ID Вашей заявки");
            try {
                searchId = Integer.parseInt(readMessage());
                trying = true;
            } catch (NumberFormatException e) {
                writeMessage("Не корректные данные");
            }
        }
        return searchId;
    }

    /**
     * Склоняет отображаемую итоговую фразу в зависимости от последней цифры.
     * @param countF кол-во найденых заявок.
     * @return сформированная строка
     */
    public String endNumber(int countF) {
        char[] endNum = Character.toChars(countF);
        switch (endNum[endNum.length - 1]) {
            case 1:
                return "найдена " + countF + " заявка";
            case 2:
            case 3:
            case 4:
                return "найдены " + countF + " заявки";
            default:
                return "найдено " + countF + " заявок";
        }
    }
}

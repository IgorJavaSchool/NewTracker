package yanevskyy;

/**
 * Хранит и проверяет все основные действия в программе
 */
public enum Actions {
    CREATE,
    EDIT,
    DELETE,
    ALL,
    FILTER,
    ADD_COMMENT,
    EXIT;

    /**
     * Возвращает действие выбранное пользователем по предложеным цыфрам.
     * Единственные стат метод во всей программе, знаю, что нельзя,
     * но думаю что если в енуме то не страшно.
     * @param number Введённая пользователем строка выбора.
     * @return выбранное действие.
     * @throws IncorrectData вызывается если нанные не валидны
     */
    public static Actions selectionsAction(String number) throws IncorrectData {
        switch (number){
            case "1": return CREATE;
            case "2": return EDIT;
            case "3": return DELETE;
            case "4": return ALL;
            case "5": return FILTER;
            case "6": return ADD_COMMENT;
            case "0": return EXIT;
            default: throw new IncorrectData();
        }
    }
}

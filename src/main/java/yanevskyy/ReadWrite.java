package yanevskyy;

import java.io.*;

/**
 * Необходим для вывода в консоль и чтения с консоли информации всеми наследниками.
 */
public abstract class ReadWrite  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String str = "";

    /**
     * Выводит в консоль информацию, ипользуется наследниками.
     * @param message принимый текст для вывода в консоль.
     */
    public void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Используется наследниками для чтения с консоли.
     * Проверяет вводные данные для выхода из программы или
     * для выхода в главное меню.
     * @return Возвращает прочитанную строку.
     * @throws CloseProgram Вызывает механизм закрытия программы
     * @throws InMenu Вызывает основное меню
     */
    public String readMessage() throws CloseProgram, InMenu {
        try {
            str = reader.readLine();

            /** Фрагмент используется только для тестирования*/
            writeMessage("");
            writeMessage("\033[34mПользователь написал " + str);
            writeMessage("\033[37m");
            /** Фрагмент используется только для тестирования*/


        } catch (IOException e) {
            e.printStackTrace();
        }

        if (str.equalsIgnoreCase("exit")) {
            writeMessage("Досвидания!!!");
            throw new CloseProgram();
        }
        else if (str.equalsIgnoreCase("menu"))
            throw new InMenu();
        return str;
    }

    /**
     * Считывет строки из указанного файла. Файл в пакете программы.
     * @param nameFile Имя требуемого файла
     * @throws IOException
     */
    public void readFile(String nameFile) throws IOException {
        try (BufferedReader readerSelect = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(nameFile)))))
        {
            while (readerSelect.ready()) {
                writeMessage(readerSelect.readLine());
            }
        }
    }
}

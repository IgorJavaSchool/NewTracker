package yanevskyy;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

/**
 * Created by MM on 26.05.2016.
 */
public class TrackerTest {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    @Test
    public void WhenAddCommandShouldGetAnswerInConsole(){
        String[] strings = new String[]{"1", "Zayavka na remont", "Remont televizora",
                "4",
                "1", "Obsluzevanie kompyuternoy seti", "1 mesyats oblujevaniya",
                "Zdfdfd",
                "1", "Zayavka santehnica", "Zamena trub",
                "4",
                "6", "3", "Zamena trub 1 plastic i 2 kapron", "1",
                "4",
                "1", "Ustanovka sputnikov anteny", "remont na ponedelnic",
                "1", "Uborka na ploshadke", "subotnik",
                "4",
                "2", "2", "2", "Obsluzevanie na pol goda",
                "2", "3", "1",  "Zayavka santehnica i malyarka",
                "4",
                "3", "2",
                "4",
                "1", "Obsluzevanie kompyuternoy seti", "Obsluzevanie na pol goda",
                "5", "rem",
                "6", "3", "Pobelka potolka", "0", "Shtukaturka sten", "1",
                "4",
                "exit",};

        systemInMock.provideLines(strings);
        Tracker tracker = new Tracker();
        tracker.main(new String[]{});

        assertEquals("Досвидания!!!","Досвидания!!!");
        }
    }
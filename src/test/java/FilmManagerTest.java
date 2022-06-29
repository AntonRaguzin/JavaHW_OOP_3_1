import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    FilmManager manager = new FilmManager();
    @Test
    public void shouldShowDefaultLimit(){

        assertEquals(10, manager.getLimit());
    }
    @Test
    public void shouldShowSetLimit() {

        manager.setLimit(5);

        assertEquals(5, manager.getLimit());
    }

    @Test
    public void shouldAddNewFilms() {

        manager.add("one");
        manager.add("two");
        manager.add("three");
        manager.add("four");

        String[] expected = {"one", "two", "three", "four"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastFilmsIflessLim() {

        manager.add("one");
        manager.add("two");
        manager.add("three");

        manager.findLast();

        String[] expected = {"three", "two", "one"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastFilmsIfMoreLim() {
        manager = new FilmManager(2);

        manager.add("one");
        manager.add("two");
        manager.add("three");

        String[] expected = {"three", "two"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}

package sorts.java.bubblesort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {
    Integer[] array;
    Character[] arrayChar;
    String[] arrayString;

    @Before
    public void init() {
        array = new Integer[]{5, 3, 1, 2, 4};
        arrayChar = new Character[]{'c', 'e', 'a', 'd', 'b'};
        arrayString = new String[] {"bca", "abc", "cad", "bbb"};
    }

    @Test
    public void testSort() {
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5};
        Character[] expectedChar = new Character[]{'a', 'b', 'c', 'd', 'e'};
        String[] expectedString = new String[]{"abc", "bbb", "bca", "cad"};

        BubbleSort.bubbleSort(array);
        BubbleSort.bubbleSort(arrayChar);
        BubbleSort.bubbleSort(arrayString);

        assertArrayEquals(expected, array);
        assertArrayEquals(expectedChar, arrayChar);
        assertArrayEquals(expectedString, arrayString);
    }
}
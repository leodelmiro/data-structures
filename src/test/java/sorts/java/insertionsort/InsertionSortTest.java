package sorts.java.insertionsort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {
    Integer[] array;
    Character[] arrayChar;

    @Before
    public void init() {
        array = new Integer[]{5, 3, 1, 2, 4};
        arrayChar = new Character[]{'c', 'e', 'a', 'd', 'b'};
    }

    @Test
    public void testSort() {
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5};
        Character[] expectedChar = new Character[]{'a', 'b', 'c', 'd', 'e'};
        InsertionSort.insertionSort(array);
        InsertionSort.insertionSort(arrayChar);
        assertArrayEquals(expected, array);
        assertArrayEquals(expectedChar, arrayChar);
    }
}

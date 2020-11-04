package sorts.java.quicksort;

import org.junit.Before;
import org.junit.Test;
import sorts.java.mergesort.MergeSort;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
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
        assertArrayEquals(expected, QuickSort.quickSort(array, 0 , array.length-1));
        assertArrayEquals(expectedChar, QuickSort.quickSort(arrayChar, 0 , array.length-1));
    }
}

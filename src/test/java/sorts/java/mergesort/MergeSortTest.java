package sorts.java.mergesort;

import org.junit.Before;
import org.junit.Test;
import sorts.java.selectionsort.SelectionSort;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
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
        assertArrayEquals(expected, MergeSort.mergeSort(array));
        assertArrayEquals(expectedChar, MergeSort.mergeSort(arrayChar));
    }
}

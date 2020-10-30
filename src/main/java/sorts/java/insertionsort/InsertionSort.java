package sorts.java.insertionsort;

public class InsertionSort {

    //InsertionSort Complexity - O(n²)
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T elementSelected = array[i];
            while (j >= 0 && array[j].compareTo(elementSelected) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = elementSelected;
        }
    }
}

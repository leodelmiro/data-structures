package sorts.java.bubblesort;

public class BubbleSort {

    //BubbleSort Complexity - O(n²)
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}
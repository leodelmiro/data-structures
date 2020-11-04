package sorts.java.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static <T extends Comparable<T>> T[] quickSort(T[] array, int left, int right){

        if(left < right) {
            int pivot = right;
            int partitionIndex = partition(array, pivot, left, right);

            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }

        return array;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int pivot, int left, int right) {
        T pivotValue = array[pivot];
        int partitionIndex = left;

        for (int i = left; i < right; i++){
            if (array[i].compareTo(pivotValue) < 0) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    private static <T> void swap (T[] array, int firstIndex, int secondIndex ) {
        T aux = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = aux;
    }
}

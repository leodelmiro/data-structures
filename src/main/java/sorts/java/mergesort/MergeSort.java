package sorts.java.mergesort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static <T extends Comparable<T>> T[] mergeSort(T[] array){
        if (array.length <= 1) {
            return array;
        }

        int middle = array.length/2;
        T[] left = Arrays.copyOfRange(array, 0, middle);

        T[] right = Arrays.copyOfRange(array, middle, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static <T extends Comparable<T>> T[] merge(T[] left, T[] right) {
        T[] arraySorted = (T[]) new Comparable[left.length + right.length];

        int leftIndex = 0, rightIndex = 0, currentIndex=0;

        while (leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex].compareTo(right[rightIndex]) > 0) {
                arraySorted[currentIndex++] = right[rightIndex++];
            } else {
                arraySorted[currentIndex++] = left[leftIndex++];
            }
        }

        while (leftIndex < left.length){
            arraySorted[currentIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length){
            arraySorted[currentIndex++] = right[rightIndex++];
        }

        return arraySorted;
    }
}

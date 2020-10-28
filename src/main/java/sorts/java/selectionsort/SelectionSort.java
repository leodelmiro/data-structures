package sorts.java.selectionsort;

public class SelectionSort {

    //SelectionSort Complexity - O(n²)
    public static <T extends Comparable<T>> void selectionSort(T[] array){
        for (int i =0; i<array.length; i++){
            int lowerValue = i;
            for (int j=i+1; j<array.length; j++){
                if (array[lowerValue].compareTo(array[j]) > 0){
                    lowerValue = j;
                }
            }
            if (lowerValue != i){
                T aux = array[i];
                array[i] = array[lowerValue];
                array[lowerValue] = aux;
            }
        }
    }
}

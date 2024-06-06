package sort.quicksort;

import java.util.List;

class Pair {
    int key;
    String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortRecursion(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> quickSortRecursion(List<Pair> pairs, int start, int end) {
        if (end - start <= 0) {
            return pairs;
        }

        Pair pivot = pairs.get(end);
        int positionPivot = start;

        for(int i = start; i <= end - 1; i++) {
            if(pivot.key > pairs.get(i).key) {
                Pair temp = pairs.get(positionPivot);
                pairs.set(positionPivot, pairs.get(i));
                pairs.set(i, temp);
                positionPivot++;
            }
        }

        pairs.set(end, pairs.get(positionPivot));
        pairs.set(positionPivot, pivot);

        quickSortRecursion(pairs, start, positionPivot - 1);
        quickSortRecursion(pairs, positionPivot + 1, end);

        return pairs;
    }
}

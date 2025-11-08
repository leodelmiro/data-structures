package sort.mergesort;

import java.util.ArrayList;
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
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end) {
        if (end - start <= 0) {
            return pairs;
        }

        int middle = (start + end) / 2;
        mergeSortHelper(pairs, start, middle);
        mergeSortHelper(pairs, middle + 1, end);

        return merge(pairs, start, middle, end);
    }

    public List<Pair> merge(List<Pair> pairs, int start, int middle, int end) {
        List<Pair> left = new ArrayList<>(pairs.subList(start, middle + 1));
        List<Pair> right = new ArrayList<>(pairs.subList(middle + 1, end + 1));

        int i = 0;
        int j = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).key <= right.get(j).key) {
                pairs.set(k, left.get(i));
                i++;
            } else {
                pairs.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            pairs.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            pairs.set(k, right.get(j));
            j++;
            k++;
        }
        return pairs;
    }
}
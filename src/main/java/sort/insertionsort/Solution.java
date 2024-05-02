package sort.insertionsort;

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

public class Solution {
    List<List<Pair>> history = new ArrayList<List<Pair>>();

    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        for(int i = 0; i <= pairs.size() - 1;i++) {
            int j = i - 1;
            while(j >= 0 && pairs.get(j).key > pairs.get(j+1).key) {
                Pair actualValue = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, actualValue);

                j--;
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            history.add(cloneList);
        }

        return history;
    }
}


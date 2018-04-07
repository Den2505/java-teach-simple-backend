package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private List<int[]> arrayList = new ArrayList<>();

    MatrixNonSimilarRows(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            arrayList.add(mas[i]);
        }
    }

    public Set<int[]> getNonSimilarRows() {

        Set<int[]> set2 = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Set<Integer> integerSet = new HashSet<>();
                Set<Integer> integerSet2 = new HashSet<>();
                for (int elem : o1) {
                    integerSet.add(elem);
                }
                for(int elem:o2){
                    integerSet2.add(elem);
                }
                if(integerSet.equals(integerSet2))
                    return 0;
                else if(integerSet.size() == integerSet2.size()) return 1;
                else
                    return integerSet.size() - integerSet2.size();
            }
        });
        set2.addAll(arrayList);
        return set2;
    }

}

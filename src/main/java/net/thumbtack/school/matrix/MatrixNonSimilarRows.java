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
        List<Integer[]> integersMas = new ArrayList<>();
        Set<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; arrayList.get(i).length > j; j++) {
                integerHashSet.add(arrayList.get(i)[j]);
            }
            integersMas.add(integerHashSet.toArray(new Integer[integerHashSet.size()]));
            integerHashSet.clear();
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < integersMas.size(); i++) {
            for (int j = i + 1; j < integersMas.size(); j++) {
                if (Arrays.equals(integersMas.get(i), integersMas.get(j))) {
                    indexList.add(j);
                }
            }
        }
        //integerHashSet.clear();
        List<int[]> removePattern = new ArrayList<>();
        for (int i : indexList) {
            removePattern.add(arrayList.get(i));
        }
        arrayList.removeAll(removePattern);
        return new HashSet<>(arrayList);
    }

}

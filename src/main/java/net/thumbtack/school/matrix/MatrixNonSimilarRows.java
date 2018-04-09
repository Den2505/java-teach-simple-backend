package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private List<int[]> arrayList = new ArrayList<>();

    MatrixNonSimilarRows(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            arrayList.add(mas[i]);
        }
    }

    private int setCompareTo(Set<Integer> integerSet, Set<Integer> integerSet2) {
        Iterator<Integer> iterator = integerSet.iterator();
        Iterator<Integer> iterator2 = integerSet2.iterator();
        int a, b;
        while (iterator.hasNext()) {
                a = iterator.next();
                b = iterator2.next();
                if (a != b) return Integer.compare(a, b);
            }
        return 0;
    }

    public Set<int[]> getNonSimilarRows() {
        Set<int[]> set2 = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Set<Integer> integerSet = new TreeSet<>();
                Set<Integer> integerSet2 = new TreeSet<>();
                for (int elem : o1) {
                    integerSet.add(elem);
                }
                for (int elem : o2) {
                    integerSet2.add(elem);
                }
                if (integerSet.equals(integerSet2))
                    return 0;
                else if (integerSet.size() == integerSet2.size()) return setCompareTo(integerSet, integerSet2);
                else
                    return integerSet.size() - integerSet2.size();
            }
        });
        set2.addAll(arrayList);
        return set2;
    }

}

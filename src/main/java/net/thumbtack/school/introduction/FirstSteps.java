package net.thumbtack.school.introduction;



public class FirstSteps {
    public int sum (int x, int y){
        return x+y;
    }
    public int mul (int x, int y){
        return x*y;
    }
    public int div (int x, int y){
        return x/y;
    }
    public int mod (int x, int y){
        return x%y;
    }
    public boolean isEqual (int x, int y){
        return x==y;
    }
    public boolean isGreater (int x, int y){
        return x > y;
    }
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y){
        return x >= xLeft & x <= xRight & y >= yTop & y <= yBottom;

    }
    public int sum(int[] array){
        if (array.length==0){return 0;}
        else {
            int sum = 0;
            for (int i : array) {
                sum += i;
            }
            return sum;
        }
    }
    public int mul(int[] array){
        if (array.length==0){return 0;}
        else {
            int mul = 1;
            for (int i : array) {
                mul *= i;
            }
            return mul;
        }
    }
    public int min(int[] array){
        int min = Integer.MAX_VALUE;
        if(array.length==0){return min;}
        else {
            for (int i : array) {
                if (min > i) {
                    min = i;
                }
            }
       return min; }
    }

    public int max(int[] array){
        int max = Integer.MIN_VALUE;
        if(array.length==0){return max;}
        else {


            for (int i : array) {
                if (max < i) {
                    max = i;
                }
            }

            return max; }
    }
    public double average(int[] array){
        if(array.length==0){return 0;}
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum/array.length;
    }
    public boolean isSortedDescendant(int[] array){
        if(array.length<2){return true;}
        else {
            for(int i=0;i<array.length-1;i++){
                if(array[i]<=array[i+1]){return false; }
            }
        }
        return true;
    }
    public void cube(int[]array){
        for (int i=0;i<array.length;i++){
            array[i]= array[i]*array[i]*array[i];

        }
    }
    public boolean find(int[]array, int value){
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public void reverse(int[]array){

            for(int i=0;i<(array.length/2);i++){
                int cash;
                cash=array[i];
                array[i]=array[array.length-1-i];
                array[array.length-1-i]=cash;
            }


    }
    public boolean isPalindrome(int[]array){
        if(array.length<2){return true;}

        for(int i =0;i<(array.length/2);i++){
            if(array[i]!=array[array.length-1-i]){return false;}
        }

        return true;
    }
    public int sum(int[][] matrix){
        int sum = 0;
        for (int[] matrixLine : matrix) {
            for (int matrixLineValue : matrixLine) {
                sum += matrixLineValue;
            }
        }
        return sum;
    }
    public int max(int[][] matrix){

        int max = Integer.MIN_VALUE;
        for (int[] matrixLine : matrix) {
            for (int matrixLineValue : matrixLine) {
                if (max < matrixLineValue) {
                    max = matrixLineValue;
                }
            }
        }
        return max;
    }
    public int diagonalMax(int[][] matrix){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            if(max<matrix[i][i]){max=matrix[i][i];}
        }
        return max;
    }
    public boolean isSortedDescendant(int[][] matrix){
        for (int[] i : matrix) {
            if (!isSortedDescendant(i)) {
                return false;
            }
        }
        return true;
    }

}

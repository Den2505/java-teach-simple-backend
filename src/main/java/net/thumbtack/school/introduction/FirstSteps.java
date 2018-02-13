package net.thumbtack.school.introduction;

import static java.lang.Math.pow;

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
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        }
    }
    public int mul(int[] array){
        if (array.length==0){return 0;}
        else {
            int mul = 1;
            for (int i = 0; i < array.length; i++) {
                mul *= array[i];
            }
            return mul;
        }
    }
    public int min(int[] array){
        int min = Integer.MAX_VALUE;
        if(array.length==0){return min;}
        else {
                for (int i = 0; i < array.length; i++) {
if(min>array[i]){min=array[i];}
                }
       return min; }
    }

    public int max(int[] array){
        int max = Integer.MIN_VALUE;
        if(array.length==0){return max;}
        else {


            for (int i = 0; i < array.length; i++) {
                if(max<array[i]){max=array[i];}
            }

            return max; }
    }
    public double average(int[] array){
        if(array.length==0){return 0;}
        double sum = 0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum/array.length;
    }
    public boolean isSortedDescendant(int[] array){
        if(array.length==0){return true;}
        if(array.length==1){return true;}
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
        for(int i=0;i<array.length;i++){
            if(array[i]==value){return true;}
        }
        return false;
    }
    public void reverse(int[]array){

            for(int i=0;i<(array.length/2);i++){
                int cash = 0;
                cash=array[i];
                array[i]=array[array.length-1-i];
                array[array.length-1-i]=cash;
            }


    }
    public boolean isPalindrome(int[]array){
        if(array.length==0){return true;}
        if(array.length==1){return true;}

        for(int i =0;i<(array.length/2);i++){
            if(array[i]!=array[array.length-1-i]){return false;}
        }

        return true;
    }
    public int sum(int[][] matrix){
        int sum = 0;
        for(int i = 0;i<matrix.length;i++){
            for (int j = 0; j<matrix[i].length;j++){
              sum+=matrix[i][j];
            }
        }
        return sum;
    }
    public int max(int[][] matrix){

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<matrix.length;i++){
            for (int j = 0; j<matrix[i].length;j++){
                if(max<matrix[i][j]){max=matrix[i][j];}
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
for(int i=0;i<matrix.length;i++){
   if(!isSortedDescendant(matrix[i])){return false;}
}
        return true;
    }

}

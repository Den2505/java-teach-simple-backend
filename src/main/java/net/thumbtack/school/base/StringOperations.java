package net.thumbtack.school.base;





public class StringOperations {
    //Спасибо:)

    public static int getSummaryLength(String[] strings){

        int length=0;
         for(String part: strings){
         length+=part.length();
         }
         return length;
    }

    public static String getFirstAndLastLetterString(String string){
        return String.valueOf(string.charAt(0))+String.valueOf(string.charAt(string.length()-1));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index){
        return string1.charAt(index)==string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        int posChar1 = string1.indexOf(character);
        int posChar2 = string2.indexOf(character);
        return posChar1 >= 0 && posChar2 >= 0 && posChar1 == posChar2;
    }
    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        int posChar1 = string1.lastIndexOf(character);
        int posChar2 = string2.lastIndexOf(character);
        return posChar1 >= 0 && posChar2 >= 0 && posChar1 == posChar2;
    }
    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        int posString1 = string1.indexOf(str);
        int posString2 = string2.indexOf(str);
        return posString1 >= 0 && posString2 >= 0 && posString1 == posString2;
    }
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        int posString1 = string1.lastIndexOf(str);
        int posString2 = string2.lastIndexOf(str);
        return posString1 >= 0 && posString2 >= 0 && posString1 == posString2;
    }
    public static boolean isEqual(String string1, String string2){
        return string1.equals(string2);
    }
    public static boolean isEqualIgnoreCase(String string1, String string2){
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2){
        return string1.compareTo(string2) < 0;
    }
    public static boolean isLessIgnoreCase(String string1, String string2){
        return string1.compareToIgnoreCase(string2) < 0;
    }
    public static String concat(String string1, String string2){
        return string1+string2;
    }
    public static boolean isSamePrefix(String string1, String string2, String prefix){

           return string1.startsWith(prefix) & string2.startsWith(prefix);
    }
    public static boolean isSameSuffix(String string1, String string2, String suffix){
        return string1.endsWith(suffix) & string2.endsWith(suffix);
    }
    public static String getCommonPrefix(String string1, String string2){
        int n = 0;
        for(int i =0; i<string1.length() & i<string2.length();i++){
            if(string1.substring(0,i).equals(string2.substring(0,i))){n=i;}
        }
        if(string1.substring(0,n+1).equals(string2.substring(0,n+1))){return string1.substring(0,n+1);}
        return string1.substring(0,n);


    }

    public static boolean isPalindrome(String string){
        StringBuilder sb = new StringBuilder();
        for(int i=string.length()-1;i>=0;i--){
            sb.append(string.charAt(i));
        }
        return sb.toString().equals(string);
    }
    public static boolean isPalindromeIgnoreCase(String string){
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        return sb.reverse().toString().equalsIgnoreCase(string);
    }
    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int length = 0;
        Integer number = null;
        for (int i = 0; i < strings.length; i++) {
            if (isPalindromeIgnoreCase(strings[i])) {
                if (length < strings[i].length()) {
                    length = strings[i].length();
                    number = i;
                }
            }
        }
        if(number==null){return "";}
        return strings[number];
    }
    public static boolean hasSameSubstring(String string1, String string2, int index, int length){
        if(string1.length()<index+length||string2.length()<index+length){return false;}
        return string1.regionMatches(index,string2,index,length);
    }

    public static boolean isEqualAfterReplaceCharacters
            (String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2){
        return string1.replace(replaceInStr1,replaceByInStr1).equals(string2.replace(replaceInStr2,replaceByInStr2));
    }
    public static boolean isEqualAfterReplaceStrings
            (String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2){
        return string1.replaceAll(replaceInStr1,replaceByInStr1).equals(string2.replaceAll(replaceInStr2,replaceByInStr2));

    }
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string){
        return isPalindromeIgnoreCase(string.replaceAll(" ",""));
    }
    public static boolean isEqualAfterTrimming(String string1, String string2){
        return string1.trim().equals(string2.trim());
    }
    public static String makeCsvStringFromInts(int[] array){


        return makeCsvStringBuilderFromInts(array).toString();

    }
    public static String makeCsvStringFromDoubles(double[] array){
        return makeCsvStringBuilderFromDoubles(array).toString();
        }
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array){
        StringBuilder builder = new StringBuilder();

        if (array.length==0) return builder;
        for(int value:array){
            builder.append(String.valueOf(value));
            builder.append(",");
        }
        builder.deleteCharAt((builder.length()-1));
        return builder;
    }
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array){
        StringBuilder builder = new StringBuilder();
        if (array.length==0) return builder;

        for(double value:array){
            builder.append(String.format("%.2f", value));
            builder.append(",");
        }
        builder.deleteCharAt((builder.length()-1));
        return builder;
    }
    public static StringBuilder removeCharacters(String string, int[] positions){
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        for(int i = 0;i<positions.length;i++){
            sb.deleteCharAt(positions[i]-i);


        }
        return sb;
    }
    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters){
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        for(int i = 0;i<positions.length;i++){
            sb.insert(positions[i]+i,characters[i]);
        }
return sb;
        }

}

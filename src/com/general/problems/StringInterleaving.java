package com.general.problems;

/**
 * DP Solution for String interleaving.
 * Note: Corner Case handling is missing.
 */
public class StringInterleaving {
    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }else if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        else if(s1.length() == 0){
            return s2.equalsIgnoreCase(s3);
        }else if(s2.length() == 0){
            return s1.equalsIgnoreCase(s3);
        }else if(s3.length() == 0){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] computeMatrix  = new boolean[m + 1 ][n + 1];
        computeMatrix[0][0] = true;

        //for first row.
        for(int i = 1; i < m + 1; i++){
            String character1 = String.valueOf(s1.charAt(i - 1));
            String character2 = String.valueOf(s3.charAt(i - 1));
            if(character1.equalsIgnoreCase(character2) && computeMatrix[0][i - 1]){
                    computeMatrix[0][i] = true;
            }
        }

        //for first column.
        for(int i = 1; i < n + 1 ; i++){
            String character1 = String.valueOf(s2.charAt( i - 1));
            String character2 = String.valueOf(s3.charAt(i - 1));
            if(character1.equalsIgnoreCase(character2) && computeMatrix[i - 1][0]){
                computeMatrix[i][0] = true;
            }
        }

        //for the remaining computeMatrix
        for(int i = 1 ; i < m + 1; i++){
            int s3Index = i;
            for(int j = 1; j < n + 1; j++){
                String targetCharacter = String.valueOf(s3.charAt(s3Index));
                String mCharacter = String.valueOf(s1.charAt(j - 1));
                String nCharacter = String.valueOf(s2.charAt(i - 1));
                if(targetCharacter.equalsIgnoreCase(mCharacter)){
                    computeMatrix[i][j] = computeMatrix[i][j - 1];
                }else if(targetCharacter.equalsIgnoreCase(nCharacter)){
                    computeMatrix[i][j] = computeMatrix[i - 1][j];
                }else{
                    computeMatrix[i][j] = false;
                }
                s3Index++;
            }
        }

        return computeMatrix[m][n];
    }
}

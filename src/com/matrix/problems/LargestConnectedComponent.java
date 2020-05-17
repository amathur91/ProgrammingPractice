package com.matrix.problems;

public class LargestConnectedComponent {
    final static int GREEN = 1;
    final static int BLUE = 2;
    final static int RED = 3;
    final static int NOCOLOR = 0;
    final static int colors = 3;

    public static void main(String args[]) {
        int[][] input = {{GREEN, GREEN, BLUE, RED},
                {GREEN, BLUE, RED, BLUE},
                {RED, BLUE, BLUE, BLUE}};

        int largestConnectedComponentSize = findLargestConnectedComponent(input);
        System.out.println("Size of largest Connected component : " + largestConnectedComponentSize);
    }

    private static int findLargestConnectedComponent(int[][] input) {
        int colorRecordKeeping[] = new int[colors];
        for (int rowIndex = 0; rowIndex < input.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < input[0].length; columnIndex++) {
                int color = input[rowIndex][columnIndex];
                if (input[rowIndex][columnIndex] != NOCOLOR) {
                    //we have not seen this cell
                    int result = findSimilarNeighbours(input, rowIndex, columnIndex, input[rowIndex][columnIndex]);
                    if(result >  colorRecordKeeping[color - 1] ) {
                        colorRecordKeeping[color - 1] = result;
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0 ; i  < colorRecordKeeping.length; i++){
            if(colorRecordKeeping[i] > result){
                result = colorRecordKeeping[i];
            }
        }

        return result;
    }

    private static int findSimilarNeighbours(int[][] input, int rowIndex, int columnIndex, int color) {
        //go towards the left
        //go towards the right
        //go towards top
        //go towards bottom
        if(isValidCoordinate(input, rowIndex, columnIndex) && color == input[rowIndex][columnIndex]){
            input[rowIndex][columnIndex] = NOCOLOR;
            int total =  1 + findSimilarNeighbours(input, rowIndex - 1, columnIndex, color) + //top
                    findSimilarNeighbours(input, rowIndex, columnIndex - 1, color) + //left
                    findSimilarNeighbours(input, rowIndex,  columnIndex + 1, color) + //right
                    findSimilarNeighbours(input, rowIndex + 1, columnIndex, color); // bottom
            //if we are here then we must mark current node as visited..
            return total;
        }
        return 0;
    }

    private static boolean isValidCoordinate(int[][] input, int rowIndex, int columnIndex) {
        return rowIndex >=0 && rowIndex < input.length &&
                columnIndex >=0 && columnIndex < input[0].length;
    }
}

package com.general.problems;

/**
 * Leetcode O(m * n) solution
 * for https://leetcode.com/problems/dungeon-game/
 * Level : Hard
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if(null == dungeon){
            return 0;
        }
        int[][] costMatrix = new int[dungeon.length][dungeon[0].length];
        buildCostMatrix(dungeon, costMatrix);

        //final result
        int result = costMatrix[0][0];
        if(result == 0){
            return 1;
        }
        return result;
    }

    private void buildCostMatrix(int[][] dungeon, int[][] costMatrix) {
        int rowIndex = dungeon.length - 1;
        int columnIndex = dungeon[0].length -1;

        while (rowIndex >=0 && columnIndex >= 0){
            fillLocationsUpwards(rowIndex, columnIndex, dungeon, costMatrix);
            fillLocationsLeftwards(rowIndex, columnIndex, dungeon, costMatrix);
            rowIndex--;
            columnIndex--;
        }
    }

    private void computeCost(int rowIndex, int columnIndex, int dungeonCost, int[][] costMatrix) {
        int rightMovementCost = findMovementCost(rowIndex, columnIndex + 1, costMatrix);
        int downMovementCost = findMovementCost(rowIndex + 1, columnIndex, costMatrix);
        int currentCost = dungeonCost;
        int requiredCurrentCost = 0;
        if(rightMovementCost == Integer.MAX_VALUE &&  downMovementCost == Integer.MAX_VALUE){
            rightMovementCost = 0;
            downMovementCost = 0;
        }
        int movementCost = Math.min(rightMovementCost, downMovementCost);
        if(currentCost <= 0){
            requiredCurrentCost = Math.abs(currentCost);
            if(movementCost == 0){
                movementCost = 1;
            }
            requiredCurrentCost = requiredCurrentCost + movementCost;
        }else if(currentCost < movementCost && currentCost > 0){
            requiredCurrentCost = movementCost - currentCost;
        }else if(currentCost > movementCost && currentCost > 0){
            requiredCurrentCost = 1;
        }
        costMatrix[rowIndex][columnIndex] =  requiredCurrentCost;
    }

    private int findMovementCost(int rowIndex, int columnIndex, int[][] costMatrix) {
        if(rowIndex < costMatrix.length && columnIndex < costMatrix[0].length){
            return costMatrix[rowIndex][columnIndex];
        }
        return Integer.MAX_VALUE;
    }

    private void fillLocationsLeftwards(int rowIndex, int columnIndex, int[][] dungeon, int[][] costMatrix) {
        while(columnIndex >= 0){
            computeCost(rowIndex, columnIndex, dungeon[rowIndex][columnIndex], costMatrix);
            columnIndex--;
        }
    }


    private void fillLocationsUpwards(int rowIndex, int columnIndex, int[][] dungeon, int[][] costMatrix) {
        while(rowIndex >= 0){
            computeCost(rowIndex, columnIndex, dungeon[rowIndex][columnIndex], costMatrix);
            rowIndex--;
        }
    }
}

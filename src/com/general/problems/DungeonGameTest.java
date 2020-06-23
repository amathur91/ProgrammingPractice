package com.general.problems;

import org.junit.Test;

public class DungeonGameTest {

    @Test
    public void test1(){
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        DungeonGame dungeonGame = new DungeonGame();
        int result = dungeonGame.calculateMinimumHP(dungeon);
        assert result == 7;
    }
}

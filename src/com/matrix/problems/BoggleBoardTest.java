package com.matrix.problems;

import org.junit.Test;

import java.util.List;

public class BoggleBoardTest {

    @Test
    public void test1(){
        char[][] board = {
                {'c', 'o', 'm'},
                {'r', 'p', 'l'},
                {'c', 'i', 't'},
                {'o', 'a', 'e'},
                {'f', 'o', 'd'},
                {'z', 'r', 'b'},
                {'g', 'i', 'a'},
                {'o', 'a', 'g'},
                {'f', 's', 'z'},
                {'t', 'e', 'i'},
                {'t', 'w', 'd'}
        };
        String[] words = {
                "commerce",
                "complicated",
                "twisted",
                "zigzag",
                "comma",
                "foobar",
                "baz",
                "there"
        };

        List<String> matchingString = BoggleBoard.boggleBoard(board, words);
        assert matchingString.size() == 7;
    }
}

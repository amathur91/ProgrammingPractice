package com.matrix.problems;

import org.junit.Test;

import java.util.List;

public class WordSearchTest {
    @Test
    public void test1(){
        char[][] input = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.findWords(input, words);
        assert result.size() == 2;
        result.get(0).equalsIgnoreCase("eat");
        result.get(1).equalsIgnoreCase("oauth");
    }

    @Test
    public void test2(){
        char[][] input = {{'a','a'}};
        String[] words = {"aaa"};
        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.findWords(input, words);
        assert result.size() == 0;
    }
}

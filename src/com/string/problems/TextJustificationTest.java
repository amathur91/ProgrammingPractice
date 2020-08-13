package com.string.problems;

import org.junit.Test;

import java.util.List;

public class TextJustificationTest {
    private TextJustification textJustification = new TextJustification();

    @Test
    public void test1(){
        List<String> result = textJustification.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        assert result != null;
    }

    @Test
    public void test2(){
        List<String> result = textJustification.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        assert result != null;
    }

    @Test
    public void test3(){
        List<String> result = textJustification.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}, 20);
        assert result != null;
    }

    @Test
    public void test4(){
        List<String> result = textJustification.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16);
        assert result != null;
    }
}

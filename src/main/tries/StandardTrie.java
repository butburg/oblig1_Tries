package main.tries;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class StandardTrie {
    char val;
    boolean isWordsFirstChar = false;
    boolean isRoot = false;
    Map<Character, StandardTrie> children = new TreeMap<>();

    StandardTrie(boolean isRoot, boolean isWordsFirstChar) {
        this.isWordsFirstChar = isWordsFirstChar;
        this.isRoot = isRoot;
    }

    StandardTrie() {
    }


    StandardTrie(char data, Map<Character, StandardTrie> child) {
        val = data;
        children = child;
    }

    StandardTrie(boolean isWordsFirstChar, char data, Map<Character, StandardTrie> child) {
        val = data;
        this.isWordsFirstChar = isWordsFirstChar;
        children = child;
    }

    public boolean isWordsFirstChar() {
        return isWordsFirstChar;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

}


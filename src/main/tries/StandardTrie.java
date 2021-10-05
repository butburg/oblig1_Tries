package main.tries;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class StandardTrie {
    char val;
    boolean isWordsLastChar = false;
    boolean isRoot = false;
    Map<Character, StandardTrie> children = new TreeMap<>();

    StandardTrie(boolean isRoot, boolean isWordsLastChar) {
        this.isWordsLastChar = isWordsLastChar;
        this.isRoot = isRoot;
    }

    StandardTrie() {
    }


    StandardTrie(char data, Map<Character, StandardTrie> child) {
        val = data;
        children = child;
    }

    StandardTrie(boolean isWordsLastChar, char data, Map<Character, StandardTrie> child) {
        val = data;
        this.isWordsLastChar = isWordsLastChar;
        children = child;
    }

    public boolean isWordsLastChar() {
        return isWordsLastChar;
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

    public void setWordsLastChar() {
        isWordsLastChar = true;
    }
}


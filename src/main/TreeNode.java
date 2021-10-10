package main;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class TreeNode {
    char val;
    boolean isWordsLastChar;
    boolean isRoot;
    Map<Character, TreeNode> children = new TreeMap<>();

    TreeNode(boolean isRoot, boolean isWordsLastChar) {
        this.isWordsLastChar = isWordsLastChar;
        this.isRoot = isRoot;
    }

    public void setWordsLastChar() {
        isWordsLastChar = true;
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
}


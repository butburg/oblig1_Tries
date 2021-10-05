package main.tries;

import java.util.*;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class StandardTrie {
    char val;
    boolean isRoot = false;
    Map<Character, StandardTrie> children = new TreeMap<>();

    StandardTrie(boolean isRoot){
        this.isRoot = isRoot;
    }

    StandardTrie(){
    }


    StandardTrie(char data, Map<Character, StandardTrie> child){
        val = data;
        children = child;
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


package main.tries;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class StandardTrie {
    char val;
    Map<Character, StandardTrie> children = new HashMap<>();

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    StandardTrie(Map<Character, StandardTrie> child){
        children = child;
    }

    StandardTrie(){
    }

    StandardTrie(char data, Map<Character, StandardTrie> child){
        val = data;
        children = child;
    }
}


package main.tries;

import java.util.LinkedList;
import java.util.List;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class StandardTrie {
    char val;
    List<StandardTrie> children = new LinkedList<>();

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    StandardTrie(char data){
        val = data;
    }

    StandardTrie(){
    }

    StandardTrie(char data, List<StandardTrie> child){
        val = data;
        children = child;
    }
}


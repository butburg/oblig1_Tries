package main.tries;

import java.util.Map;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class Trie {

    StandardTrie root = new StandardTrie(true);

    public Trie() {

    }

    public String insert(String newWord) {

        String ret = insertLoop(root, newWord);
        //get structurer
        return newWord + ": " + getBranch(root);
    }

    public String insertLoop(StandardTrie branch, String newWord) {
        Map<Character, StandardTrie> children = branch.children;
        if (children.containsKey(newWord.charAt(0))) { //if there is the same see if this child has a child = newWord[v=1]
            // do this [v++]
            if (newWord.length() > 1) {
                return newWord.charAt(0) + insertLoop(children.get(newWord.charAt(0)), newWord.substring(1));
            } else {
                return newWord; //until there is condition 1# but with index[v] or word at end
            }
        } else { //c1: if no char-child of root is equal newWord[v=0 add char by char
            return addChar(branch, newWord);
        }
    }

    public String addChar(StandardTrie branch, String wordToAdd) {
        char c = wordToAdd.charAt(0);
        StandardTrie st = new StandardTrie();
        branch.children.put(c, st);

        if (wordToAdd.length() > 1)
            return wordToAdd.charAt(0) + addChar(st, wordToAdd.substring(1));
        else return wordToAdd;
    }


    public String getBranch(StandardTrie branch) {
        String ret = "";
        for (Map.Entry<Character,
                StandardTrie> entry : branch.children.entrySet()) {
            String key = String.valueOf(entry.getKey());
            StandardTrie trie = entry.getValue();
            if (branch.children.size() > 1)
                ret = ret + "{" + key + getBranch(trie) + "}";
            else
                ret = ret + key + getBranch(trie);
        }
        return ret;
    }


    public String getLookup(String lookupWord) {
        return "looked up(" + lookupWord + ")";
    }

}

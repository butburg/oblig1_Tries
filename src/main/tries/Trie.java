package main.tries;

import java.util.Map;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class Trie {

    StandardTrie root = new StandardTrie(true, false);

    public Trie() {
    }

    public String insert(String newWord) {
        String ret = insertLoop(root, newWord, true);
        //get structurer
        return newWord + ": " + getBranch(root);
    }

    public String insertLoop(StandardTrie branch, String newWord, boolean first) {
        Map<Character, StandardTrie> children = branch.children;
        if (children.containsKey(newWord.charAt(0))) { //if there is the same see if this child has a child = newWord[v=1]
            // do this [v++]
            if (newWord.length() > 1) {
                return newWord.charAt(0) + insertLoop(children.get(newWord.charAt(0)), newWord.substring(1), false);
            } else {
                return newWord; //until there is condition 1# but with index[v] or word at end
            }
        } else { //c1: if no char-child of root is equal newWord[v=0 add char by char
            return addChar(branch, newWord, first);
        }
    }

    public String addChar(StandardTrie branch, String wordToAdd, boolean first) {
        char c = wordToAdd.charAt(0);
        StandardTrie st = new StandardTrie(false, first);
        branch.children.put(c, st);

        if (wordToAdd.length() > 1)
            return wordToAdd.charAt(0) + addChar(st, wordToAdd.substring(1),false);
        else return wordToAdd;
    }


    public String getBranch(StandardTrie branch) {
        StringBuilder ret = new StringBuilder();
        for (Map.Entry<Character,
                StandardTrie> entry : branch.children.entrySet()) {
            String key = String.valueOf(entry.getKey());
            StandardTrie trie = entry.getValue();
            if (branch.children.size() > 1 || branch.isRoot)
                ret.append("(").append(key).append(getBranch(trie)).append(")");
            else
                ret.append(key).append(getBranch(trie));
        }
        return ret.toString();
    }


    public String getLookup(String lookupWord) {
        StandardTrie branch = root.children.get(lookupWord.charAt(0));
        if(branch != null && branch.isWordsFirstChar()) {
            if (getLookup(root, lookupWord))
                return lookupWord + ": YES";
        }
        return lookupWord + ": NO";
    }

    private boolean getLookup(StandardTrie branch, String lookupWord) {
        if (lookupWord.equals("")) return true;
        else if (branch.children.containsKey(lookupWord.charAt(0)))
            return getLookup(branch.children.get(lookupWord.charAt(0)), lookupWord.substring(1));
        else return false;
    }


}

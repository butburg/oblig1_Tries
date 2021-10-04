package main.tries;

import java.util.List;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class Trie {

    StandardTrie root = new StandardTrie();

    public Trie() {

    }


    public String insert(String newWord) {
        return insertLoop(root, newWord);
    }

    public String insertLoop(StandardTrie branch, String newWord) {
        //c1: if no char-child of root is equal newWord[v=0]
        StandardTrie resultNode = null;
        boolean noChild = true;
        List<StandardTrie> children = branch.children;
        StandardTrie nextNode = null;
        int i = 0;
        while (i < children.size() && noChild) {
            if (children.get(i).val == newWord.charAt(0)) {
                resultNode = children.get(i);
                
                nextNode = children.get(i+1);
                noChild = false;
            }
            i++;
        }

        if (noChild) {
            // add char by char
            for (char c : newWord.toCharArray()) {
                root.children.add(new StandardTrie(c));
            }
            return "(" + newWord + ")";
        } else {
            //if there is the same
            // see if this child has a child = newWord[v=1]
            // do this [v++] until there is condition 1# but with index[v]
            if (newWord.length() > 1)
                return "(" + insertLoop(nextNode, newWord.substring(1)) + ")";
            else return "end";
        }
    }

    public String getLookup(String lookupWord) {
        return "looked up(" + lookupWord + ")";
    }

}

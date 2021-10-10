package main;

import java.util.Map;

/**
 * @author github.com/butburg (EW) on Okt 2021
 */
public class Trie {

    TreeNode root = new TreeNode(true, false);

    public Trie() {
    }

    public String insert(String wordToInsert) {
        String ret = insertRec(root, wordToInsert);
        //get structure
        return wordToInsert + ": " + getSubtrees(root);
    }

    private String insertRec(TreeNode branch, String pattern) {
        Map<Character, TreeNode> children = branch.children;
        if (children.containsKey(pattern.charAt(0))) { //if there is the same see if this child has a child = pattern[v=1]
            // do this [v++]
            if (pattern.length() == 1) branch.children.get(pattern.charAt(0)).setWordsLastChar();
            if (pattern.length() > 1) {
                return pattern.charAt(0) + insertRec(children.get(pattern.charAt(0)), pattern.substring(1));
            } else {
                return pattern; //until there is condition 1# but with index[v] or word at end
            }
        } else { //c1: if no char-child of root is equal pattern[v=0 add char by char
            return addChar(branch, pattern);
        }
    }

    private String addChar(TreeNode branch, String wordToAdd) {
        char c = wordToAdd.charAt(0);
        TreeNode st = new TreeNode(false, false);
        if (wordToAdd.length() == 1)
            st.setWordsLastChar();
        branch.children.put(c, st);

        if (wordToAdd.length() > 1)
            return wordToAdd.charAt(0) + addChar(st, wordToAdd.substring(1));
        else {
            return wordToAdd;
        }
    }

    private String getSubtrees(TreeNode branch) {
        StringBuilder ret = new StringBuilder();
        for (Map.Entry<Character,
                TreeNode> entry : branch.children.entrySet()) {
            String key = String.valueOf(entry.getKey());
            TreeNode trie = entry.getValue();
            if (branch.children.size() > 1 || branch.isRoot)
                ret.append("(").append(key).append(getSubtrees(trie)).append(")");
            else
                ret.append(key).append(getSubtrees(trie));
        }
        return ret.toString();
    }


    public String getLookup(String lookupWord) {
        if (getLookup(root, lookupWord))
            return lookupWord + ": YES";
        return lookupWord + ": NO";
    }

    private boolean getLookup(TreeNode branch, String lookupWord) {
        if (lookupWord.equals("")) {
            return branch.isWordsLastChar();
        } else if (branch.children.containsKey(lookupWord.charAt(0)))
            return getLookup(branch.children.get(lookupWord.charAt(0)), lookupWord.substring(1));
        else return false;
    }

}

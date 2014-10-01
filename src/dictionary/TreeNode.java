/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author NitroLuke
 */
class TreeNode {

    String word;
    String definition;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(String w, String d) {
        word = w;
        definition = d;
        parent = null;
        left = null;
        right = null;
    }

    public String getWord() {
        return word;
    }

    public void setParent(TreeNode n) {
        parent = n;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setLeft(TreeNode n) {
        left = n;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setRight(TreeNode n) {
        right = n;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode searchFrom(String value) {
        if (word.equals(value)) {
            return this;
        }
        if (value.compareToIgnoreCase(word) < 0) { // *** value should be less than data ***
            if (left == null) {
                return null;
            }
            return left.searchFrom(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.searchFrom(value);
        }
    }

//    public boolean searchForNode(TreeNode searchNode) {
//        if (this == searchNode) {
//            return true;
//        }
//        if (left != null && left.searchForNode(searchNode)) {
//            return true;
//        }
//        if (right != null && right.searchForNode(searchNode)) {
//            return true;
//        }
//        return false;
//    }
}

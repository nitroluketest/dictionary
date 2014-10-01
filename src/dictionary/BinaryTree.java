/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author NitroLuke
 */
class BinaryTree {
    Map<String,String> map = new TreeMap<String,String>();
    ArrayList<String> dictionary = new ArrayList<String>();
    Collection c = new ArrayList();
    TreeNode root = null;
    String word;
    String definition;

    public TreeNode search(String value) {
        if (root == null) {
            return null;
        }
        return root.searchFrom(value);
    }

    public void MakeTree() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/NitroLuke/Desktop/DictionaryWords.txt"));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
            Collections.shuffle(dictionary);
            for(int i = 0; i < dictionary.size(); i++) {
                String[] split = dictionary.get(i).split(" ", 2);
                word = split[0];
                definition = split[1];
                insert(new TreeNode(word, definition)); // always inserting left
                System.out.println("inserting: " + word + " " + definition);
            }
        } catch (IOException e) {
            System.out.println("Caught IOException " + e.getMessage());
        }
    }

    public void insert(TreeNode n) {
        if (root == null) {
            root = n;
            return;
        }
        TreeNode curNode = root; // root is not null
        while (true) {
            if (!n.getWord().equals(curNode.getWord())) {
                if (curNode.getLeft() == null) {
                    curNode.setLeft(n);
                    n.setParent(curNode);
                    System.out.println("sets left");
                    return;
                }
                curNode = curNode.getLeft();
            } else {
                if (curNode.getRight() == null) {
                    curNode.setRight(n);
                    n.setParent(curNode);
                    System.out.println("sets right");
                    return;
                }
                curNode = curNode.getRight();
            }
        }
    }
}

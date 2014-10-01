/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author NitroLuke
 */
public class Dictionary extends JFrame {

    public static Container contentPane;
    public static TreePanel searchPanel, insertPanel, deletePanel, buttonPanel;
    public static BinaryTree t = new BinaryTree();

    public static void main(String[] args) {
        JFrame frame = new Dictionary();
        frame.setVisible(true);
        t.MakeTree();
    }

    public Dictionary() {
        super("Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = getContentPane();
        setLayout(new GridLayout(3, 4));

        searchPanel = new TreePanel("What word do you want use? ", 10);

        contentPane.add(searchPanel);
        buttonPanel = new TreePanel();
        contentPane.add(buttonPanel);
        pack();
    }
}

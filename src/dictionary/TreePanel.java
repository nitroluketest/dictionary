package dictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luke.welna
 */
public class TreePanel extends JPanel {

    public static JButton search;
//    public static JButton delete, insert;
    public static JTextField textField;
    BinaryTree binaryTree;
    public TreeNode node;
    public Dictionary definition;

    public TreePanel(String fieldLabel, int fieldSize) {

        add(new JLabel(fieldLabel));
        textField = new JTextField(fieldSize);
        textField.addActionListener(new NewTextFieldValue());
        add(textField);

    }

    public TreePanel() {
        search = new JButton("Search");
//        insert = new JButton("Insert");
        this.add(search);
//        this.add(insert);
        search.addActionListener(new SearchPressed());
//        insert.addActionListener(new InsertPressed());
    }

    private class SearchPressed implements ActionListener {

        BinaryTree binaryTree = Dictionary.t;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                node = binaryTree.search(textField.getText());
                System.out.println("The Node that was found  = " + node + "\n");
            } catch (NumberFormatException ex) {
                System.out.println("You cannot search for nothing\n");
            }

        }
    }

//    private class InsertPressed implements ActionListener {
//        BinaryTree binaryTree = Dictionary.t;
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try{
//                node = new TreeNode(Integer.parseInt(textField.getText()));
//            binaryTree.insert(node);
//            }
//            catch(NumberFormatException ex){
//                System.out.println("You cannot insert nothing\n");
//            }
//        }
//        
//    }
    private class NewTextFieldValue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
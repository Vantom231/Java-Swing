package zad_1;

import javax.swing.*;

public class Main extends JFrame {
    private JPanel panel;
    private JList list1;
    private DefaultListModel list1Model = (DefaultListModel) list1.getModel();
    private JList list2;
    private DefaultListModel list2Model = (DefaultListModel) list2.getModel();
    private JButton toRightButton;
    private JButton allRightButton;
    private JButton toLeftButton;
    private JButton allLeftButton;

    public Main(){
        this.setContentPane(panel);
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        toRightButton.addActionListener(e -> toRight());
        allRightButton.addActionListener(e -> allRight());
        toLeftButton.addActionListener(e -> toLeft());
        allLeftButton.addActionListener(e -> allLeft());
    }

    public static void main(String[] args) {
        new Main();
    }
    private void toRight(){
        String temp = (String) list1.getSelectedValue();
        int index = list1.getSelectedIndex();
        list2Model.addElement(temp);
        list1Model.remove(index);
    }
    private void allRight(){
        int cap = list1Model.size();
        for (int i = 0; i < cap; i++) {
            list2Model.addElement(list1Model.getElementAt(0));
            list1Model.remove(0);
        }
    }
    private void toLeft(){
        String temp = (String) list2.getSelectedValue();
        int index = list2.getSelectedIndex();
        list1Model.addElement(temp);
        list2Model.remove(index);
    }
    private void allLeft(){
        int cap = list2Model.size();
        for (int i = 0; i < cap; i++) {
            list1Model.addElement(list2Model.getElementAt(0));
            list2Model.remove(0);
        }
    }
}

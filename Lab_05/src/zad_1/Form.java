package zad_1;

import datechooser.beans.DateChooserCombo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("ALL")
public class Form extends JFrame{
    private JPanel panel;
    private JTextField titleText;
    private JComboBox priorityBox;
    private JTextArea descriptionArea;
    private JButton doneButton;
    private JLabel titleTag;
    private DateChooserCombo expText;

    public Form(){
    }
        public void newTask(JList list,ArrayList<ArrayList<String>> arr) {
            setGui();
            this.setTitle("New Task");
            titleTag.setText("New Task");

            doneButton.addActionListener(e -> {
                if(titleText.getText().contentEquals("") || descriptionArea.getText().contentEquals("")){
                    JOptionPane.showMessageDialog(null,"Column Title and Description can't be null");
                }else {
                    addTask(list,arr);
                }

            });
        }
        public void editTask(JList list, ArrayList<ArrayList<String>> arr,int index){
            setGui();
            this.setTitle("Edit Task");
            titleText.setText(arr.get(index).get(0));
            priorityBox.setSelectedIndex(Integer.parseInt((arr.get(index).get(1))));
//            expText.setText(arr.get(index).get(2));
            Calendar cal = Calendar.getInstance();
           cal.set(Integer.parseInt(arr.get(index).get(2).substring(6)),Integer.parseInt(arr.get(index).get(2).substring(3,5))-1, Integer.parseInt(arr.get(index).get(2).substring(0,2)));

            expText.setSelectedDate(cal);
            descriptionArea.setText(arr.get(index).get(3));

            doneButton.addActionListener(e -> {
               if(titleText.getText().contentEquals(("")) || descriptionArea.getText().contentEquals("")){
                   JOptionPane.showMessageDialog(null,"Column Title and Description can't be null");
               }else {
                   insertTask(list,arr,index);
               }
            });

        }
        private void addTask(JList list,ArrayList<ArrayList<String>> ar){
            DefaultListModel dfm = (DefaultListModel) list.getModel();
            dfm.addElement(titleText.getText());
            ar.add(new ArrayList<String>());
            ar.get(ar.size()-1).add(titleText.getText());
            ar.get(ar.size()-1).add(String.valueOf(priorityBox.getSelectedIndex()));
            ar.get(ar.size()-1).add(expText.getText());
            ar.get(ar.size()-1).add(descriptionArea.getText());
            this.dispose();
        }
        private void insertTask(JList list, ArrayList<ArrayList<String>> arr, int index){
            DefaultListModel dfm = (DefaultListModel) list.getModel();
            dfm.add(index,titleText.getText());
            dfm.remove(index+1);
            arr.add(index,new ArrayList<String>());
            arr.remove(index+1);
            arr.get(index).add(titleText.getText());
            arr.get(index).add(String.valueOf(priorityBox.getSelectedIndex()));
            arr.get(index).add(expText.getText());
            arr.get(index).add(descriptionArea.getText());

            dispose();
        }
        private void setGui(){
            this.setContentPane(panel);
            this.setSize(600,400);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
        public JPanel getPanel(){
        return panel;
        }
}

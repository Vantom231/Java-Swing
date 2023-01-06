import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class Main extends JFrame {
    private JPanel panel;
    private JList list1;
    private DefaultListModel list1Model = (DefaultListModel) list1.getModel();
    private JTextField nameText;
    private JTextField emailText;
    private JTextField phoneText;
    private JTextField adrText;
    private JTextField dobText;
    private JButton saveButton;
    private JButton saveExistingButton;
    private JLabel ageLabel;
    private JLabel yearsLabel;
    private ArrayList<ArrayList<String>> arr = new ArrayList<>();
    private ArrayList<String> arrModel = new ArrayList<>();


    public Main(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        saveExistingButton.setEnabled(false);
        this.setVisible(true);

        arrFiller();
        list1Model.addAll(arrModel);


       list1.addListSelectionListener(e -> listClickHandler(list1.getSelectedIndex()));
        saveButton.addActionListener(e -> listAdd());
        saveExistingButton.addActionListener(e -> listAddNew(list1.getSelectedIndex()));
    }

    public static void main(String[] args) {
        new Main();
    }

    private void listClickHandler(int id){
        nameText.setText(arr.get(id).get(0));
        emailText.setText(arr.get(id).get(1));
        phoneText.setText(arr.get(id).get(2));
        adrText.setText(arr.get(id).get(3));
        dobText.setText(arr.get(id).get(4));
        saveExistingButton.setEnabled(true);
        int ln = arr.get(id).get(4).length();
        int yr = Integer.parseInt(arr.get(id).get(4).substring(ln - 4));
        yr = 2022 - yr;
        yearsLabel.setText(yr+" years");
    }
    private void listAdd(){
        arr.add(new ArrayList<>());
        int index = arr.size()-1;
        arr.get(index).add(nameText.getText());
        arr.get(index).add(emailText.getText());
        arr.get(index).add(phoneText.getText());
        arr.get(index).add(adrText.getText());
        arr.get(index).add(dobText.getText());
        list1Model.addElement(arr.get(index).get(0));
    }
    private void listAddNew(int index){
        arr.get(index).clear();
        arr.get(index).add(nameText.getText());
        arr.get(index).add(emailText.getText());
        arr.get(index).add(phoneText.getText());
        arr.get(index).add(adrText.getText());
        arr.get(index).add(dobText.getText());
        list1Model.add(index,arr.get(index).get(0));
        list1Model.remove(index+1);
    }
    private void arrFiller(){
        String [][] str = {
                {"Jan Kowalski","JKowalski@example.com","000111222","Exapmple street", "1.01.2001"},
                {"Marian Nowak","MNowak@example.com","111222333","Example2 Street","2.02.2002"},
                {"Janina Urban","JUrban@example.com","222333444","Example3 Street","3.03.2003"},
                {"Ewelina Nowak-Maciag","ENMaciag@example.com","333444555","Example4 Street","4.04.2004"}
        };
        for (int i = 0; i < 4; i++) {
            arr.add(new ArrayList<String>());
            arrModel.add(str[i][0]);
            for (int i1 = 0; i1 < 5; i1++) {
                arr.get(i).add(str[i][i1]);
            }
        }
    }
}

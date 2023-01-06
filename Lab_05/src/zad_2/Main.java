package zad_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private JPanel panel;
    private JTextField nameTxt;
    private JTextField eTxt;
    private JTextField pTxt;
    private JTextField aTxt;
    private JButton addButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JTable table1;
    final private DefaultTableModel tablemodel = (DefaultTableModel) table1.getModel();

    public Main(){
        setGui();
        tableMaker();
        tableFiller();
        listenersSetUp();
    }
    public static void main(String[] args) {
        new Main();
    }
    private void tableMaker(){
        tablemodel.addColumn("Name");
        tablemodel.addColumn("Email");
        tablemodel.addColumn("Phone");
        tablemodel.addColumn("Address");
    }
    private void tableFiller(){
        tablemodel.addRow(new Object[]{"Szymon","Szymon@example.com","123123123","Poland"});
        tablemodel.addRow(new Object[]{"Adam","adam@example.com","234234234","NotPoland"});
        tablemodel.addRow(new Object[]{"Mark","mark@example.com","345345345","AlmostPoland"});
    }
    private void cleanInput(){
        nameTxt.setText("");
        eTxt.setText("");
        aTxt.setText("");
        pTxt.setText("");
    }
    private void addRow(){
        if(!nameTxt.getText().contentEquals("") &&
            !eTxt.getText().contentEquals("") &&
            !pTxt.getText().contentEquals("") &&
            !aTxt.getText().contentEquals("")){
            tablemodel.addRow(new Object[]{nameTxt.getText(),eTxt.getText(),pTxt.getText(),aTxt.getText()});
        }else{
            JOptionPane.showMessageDialog(null,"can't add null value");
        }
    }
    private void setGui(){
        this.setSize(600,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setTitle("managing Records");
        this.setLocationByPlatform(true);
        this.setVisible(true);
    }
    private void listenersSetUp(){
        clearButton.addActionListener(e -> cleanInput());
        deleteButton.addActionListener(e -> tablemodel.removeRow(table1.getSelectedRow()));
        addButton.addActionListener(e -> addRow());
    }
}

package zad_1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import static zad_1.arrays.*;

public class Main extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel;


    // Lists & Models
    private JList list1;
    final private DefaultListModel list1Model = (DefaultListModel) list1.getModel();
    private JList list2;
    final private DefaultListModel list2Model = (DefaultListModel) list2.getModel();
    private JList list3;
    final private DefaultListModel list3Model = (DefaultListModel) list3.getModel();

    //popup Menu
    final private JPopupMenu popup = new JPopupMenu();
    final private JMenuItem pm11 = new JMenuItem("Edit");
    final private JMenuItem pm12 = new JMenuItem("Delete");
    final private JPopupMenu popup2 = new JPopupMenu();
    final private JMenuItem pm21 = new JMenuItem("Edit");
    final private JMenuItem pm22 = new JMenuItem("Delete");
    final private JPopupMenu popup3 = new JPopupMenu();
    final private JMenuItem pm31 = new JMenuItem("Edit");
    final private JMenuItem pm32 = new JMenuItem("Delete");

    // Buttons
    private JButton addNewTaskButton;
    private JButton backButton;
    private JButton closeButton;
    //    final private Form form = new Form();


    public Main(){
        setGUI();
        listFiller();
        listTransferPreparation();
        popupSetup();
        setUpListeners();
    }

    public static void main(String[] args) {
        new Main();
    }

    @SuppressWarnings("All")
    private void listFiller(){
        int j = 1;
        list1Model.clear();
        list2Model.clear();
        list3Model.clear();
        for (int i = 0; i < 3; i++) {
            list1Model.addElement("example " + j);
            ArrayList<String> temp = new ArrayList<>();
            temp.add("example " + j);
            temp.add("0");
            temp.add("0"+j+".01.2022");
            temp.add("example "+ j +" Description");
            arr1.add(temp);
            j++;
        }
        for (int i = 0; i < 3; i++) {
            list2Model.addElement("example " + j);
            ArrayList<String> temp = new ArrayList<>();
            temp.add("example " + j);
            temp.add("0");
            temp.add("0"+j+".01.2022");
            temp.add("example "+ j +" Description");
            arr2.add(temp);
            j++;
        }
        for (int i = 0; i < 3; i++) {
            list3Model.addElement("example " + j);
            ArrayList<String> temp = new ArrayList<>();
            temp.add("example " + j);
            temp.add("0");
            temp.add("0"+j+".01.2022");
            temp.add("example "+ j +" Description");
            arr3.add(temp);
            j++;
        }
    }
    private void listTransferPreparation(){

        //DnD Transfer JList Setup

        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setDragEnabled(true);
        list2.setDragEnabled(true);
        list3.setDragEnabled(true);
        list1.setDropMode(DropMode.INSERT);
        list2.setDropMode(DropMode.INSERT);
        list3.setDropMode(DropMode.INSERT);
        list1.setTransferHandler(new ListTransferHandler());
        list2.setTransferHandler(new ListTransferHandler());
        list3.setTransferHandler(new ListTransferHandler());
        list1.setName("0");
        list2.setName("1");
        list3.setName("2");

        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);

    }

    private void popupSetup(){
        //popups Listeners

        pm11.addActionListener(e -> new Form().editTask(list1,arr1,list1.getSelectedIndex()));
        pm21.addActionListener(e -> new Form().editTask(list2,arr2,list2.getSelectedIndex()));
        pm31.addActionListener(e -> new Form().editTask(list3,arr3,list3.getSelectedIndex()));

        pm12.addActionListener(e -> {
            arr1.remove(list1.getSelectedIndex());
            list1Model.remove(list1.getSelectedIndex());
        });
        pm22.addActionListener(e -> {
            arr2.remove(list2.getSelectedIndex());
            list2Model.remove(list2.getSelectedIndex());
        });
        pm32.addActionListener(e -> {
            arr3.remove(list3.getSelectedIndex());
            list3Model.remove(list3.getSelectedIndex());
        });

        //Popups SetUp

        popup.add(pm11);
        popup.add(pm12);
        popup2.add(pm21);
        popup2.add(pm22);
        popup3.add(pm31);
        popup3.add(pm32);

        //List Listeners

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    popup.show(e.getComponent(), list1.getX(), list1.getY() + (18 * (list1.getSelectedIndex()))-3);
                }
            }

        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    popup2.show(e.getComponent(), list2.getX(),list2.getY() + (18 * (list2.getSelectedIndex()))-3);
                }
            }

        });
        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getButton() == MouseEvent.BUTTON1) {
                    popup3.show(e.getComponent(), list3.getX(), list3.getY() + (18 * (list3.getSelectedIndex()))-3);
                }
            }

        });
    }
    private void setUpListeners(){
        backButton.addActionListener(e -> tabbedPane1.setSelectedIndex(0));
        closeButton.addActionListener(e -> this.dispose());
        addNewTaskButton.addActionListener(e -> new Form().newTask(list1, arr1));
    }
    private void setGUI(){
        this.setContentPane(panel);
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kanban");
        this.setLocationRelativeTo(null);
        panel.setBackground(Color.white);
        tabbedPane1.setBackground(Color.white);
        addNewTaskButton.setBackground(Color.white);
        UIManager.put("TabbedPane.selected", Color.lightGray);
        SwingUtilities.updateComponentTreeUI(tabbedPane1);
        this.setVisible(true);
    };

}

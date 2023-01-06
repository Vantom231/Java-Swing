package Temperatura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    JFrame frame;
    JPanel panel;
    JLabel label1,label2;
    JTextField tx1,tx2;
    JButton count;


    public Main(){
        frame = new JFrame();
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        label1 = new JLabel("Stopnie w C");
        label1.setBounds(10,20,100,25);

        label2 = new JLabel("Stopnie w F");
        label2.setBounds(200,20,100,25);

        tx1 = new JTextField();
        tx1.setBounds(10,45,150,25);

        tx2 = new JTextField();
        tx2.setBounds(200,45,150,25);
        tx2.setEditable(false);

        count = new JButton("Przelicz");
        count.setBounds(10 , 75 , 100,25);
        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a,b;

                a = Double.parseDouble(tx1.getText());
                b = (a * 9/5)+ 32;
                tx2.setText(String.valueOf(b));
            }});

        frame.add(panel);
        panel.add(label1);
        panel.add(label2);
        panel.add(tx1);
        panel.add(tx2);
        panel.add(count);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}
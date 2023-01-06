package Kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JFrame frame;
    JPanel panel;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    JButton wynik,dodac,odjac,mnozyc,dzielic,cls;
    static JTextField preview;
    static float previewNumber = 0, workingNumber = 0;
    static int lastChoose = 0,width = 60,heigth = 40;
    static String previewsign = " ";
    Main(){
        frame = new JFrame();
        frame.setSize(45 + (4*width),100+(heigth*4));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kalkulator - Szymon Pluta");

        panel = new JPanel();
        panel.setLayout(null);

        preview = new JTextField();
        preview.setBounds(10,10,15 + (4*width),25);
        preview.setEditable(false);



        //przyciski cyfr
        b1 = new JButton("1");
        b1.setBounds(10,40,width,heigth);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(1);
            }
        });

        b2 = new JButton("2");
        b2.setBounds(75,40,width,heigth);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(2);
            }
        });

        b3 = new JButton("3");
        b3.setBounds(140,40,width,heigth);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(3);
            }
        });
        b4 = new JButton("4");
        b4.setBounds(10,45+heigth,width,heigth);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(4);
            }
        });

        b5 = new JButton("5");
        b5.setBounds(75,45+heigth,width,heigth);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(5);
            }
        });

        b6 = new JButton("6");
        b6.setBounds(140,45+heigth,width,heigth);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(6);
            }
        });
        b7 = new JButton("7");
        b7.setBounds(10,50+(heigth*2),width,heigth);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(7);
            }
        });

        b8 = new JButton("8");
        b8.setBounds(75,50+(heigth*2),width,heigth);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(8);
            }
        });

        b9 = new JButton("9");
        b9.setBounds(140,50+(heigth*2),width,heigth);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(9);
            }
        });

        b0 = new JButton("0");
        b0.setBounds(10,55+(heigth*3),width,heigth);
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczby(0);
            }
        });


        //przyciski operacji matematycznych
        wynik = new JButton("=");
        wynik.setBounds(75,55+(heigth*3),width,heigth);
        wynik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dzialania(0);
            }
        });

        dodac = new JButton("+");
        dodac.setBounds(205,40,width,heigth);
        dodac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dzialania(1);
            }
        });

        odjac = new JButton("-");
        odjac.setBounds(205,45+heigth,width,heigth);
        odjac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dzialania(2);
            }
        });

        mnozyc = new JButton("*");
        mnozyc.setBounds(205,50+(heigth*2),width,heigth);
        mnozyc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dzialania(3);
            }
        });

        dzielic = new JButton("/");
        dzielic.setBounds(205,55+(heigth*3),width,heigth);
        dzielic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dzialania(4);
            }
        });

        cls = new JButton("cls");
        cls.setBounds(140,55+(heigth*3),width,heigth);
        cls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previewNumber = 0;
                workingNumber = 0;
                lastChoose = 0;
                previewsign = " ";
                updatePreview();
            }
        });


        frame.add(panel);
        panel.add(preview);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b0);
        panel.add(wynik);
        panel.add(dodac);
        panel.add(dzielic);
        panel.add(odjac);
        panel.add(mnozyc);
        panel.add(cls);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    //tworzenie liczby
    static void liczby(float liczba){
        if(workingNumber > 0){
            workingNumber = Math.round(workingNumber) * 9 + workingNumber + liczba;
        }else{
            workingNumber = liczba;
        }
        updatePreview();
    }

    //obsługa obliczeń pełnych liczb
    static void dzialania(int a){

        switch(lastChoose) {
            case 0:
                previewNumber = workingNumber;
                workingNumber = 0;
                break;
            case 1:
                previewNumber = previewNumber + workingNumber;
                workingNumber = 0;
                break;
            case 2:
                previewNumber = previewNumber - workingNumber;
                workingNumber = 0;
                break;
            case 3:
                previewNumber = previewNumber * workingNumber;
                workingNumber = 0;
                break;
            case 4:
                previewNumber = previewNumber / workingNumber;
                workingNumber = 0;
                break;
        }

        //0wynik,1dodac,2odjac,3mnozyc,4dzielic;
        switch(a){
            case 0:
                previewsign = " ";
                break;
            case 1:
                previewsign = " + ";
                break;
            case 2:
                previewsign = " - ";
                break;
            case 3:
                previewsign = " * ";
                break;
            case 4:
                previewsign = " / ";
                break;
        }
        lastChoose = a;
        updatePreview();
    }

    //uaktualniania wyniku
    static void updatePreview(){
        float a = previewNumber;

        float b = workingNumber;


        if( previewsign.contentEquals(" ") && b == 0) {
            preview.setText(String.valueOf(a));
        }else if( a == 0){
            preview.setText(String.valueOf(b));
        }else{
            preview.setText(a + previewsign + b);
        }
    }
}
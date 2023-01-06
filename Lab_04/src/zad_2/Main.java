package zad_2;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel panel;
    private JComboBox colors;
    private JButton bButton;
    private JButton zButton;
    private JButton iButton;
    private JButton pButton;
    private JTextArea textArea;


    Main(){
        this.setContentPane(panel);
        this.setSize(600,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        textArea.setBackground(Color.GRAY);
        colors.setSelectedIndex(1);
        colors.addItemListener(e -> selectColor());

        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));

        bButton.addActionListener(e -> boldText());
        iButton.addActionListener(e -> italicText());
        pButton.addActionListener(e -> fontUp());
        zButton.addActionListener(e -> fontDown());
    }

    public static void main(String[] args) {
        new Main();
    }

    private void selectColor(){
        switch(colors.getSelectedIndex()){
            case 0 -> { textArea.setForeground(Color.red);}
            case 1 -> { textArea.setForeground(Color.black);}
            case 2 -> { textArea.setForeground(Color.green);}
            case 3 -> { textArea.setForeground(Color.blue);}
            case 4 -> { textArea.setForeground(Color.yellow);}
            case 5 -> { textArea.setForeground(Color.GRAY);}
            case 6 -> { textArea.setForeground(Color.magenta);}
        }
    }
    private void boldText(){
            Font font = new Font(textArea.getFont().getFontName(), Font.BOLD, textArea.getFont().getSize());
            textArea.setFont(font);
    }
    private void italicText(){
            Font font = new Font(textArea.getFont().getFontName(), Font.ITALIC, textArea.getFont().getSize());
            textArea.setFont(font);
    }
    private void fontUp() {
            Font font = new Font(textArea.getFont().getFontName(),0,textArea.getFont().getSize()+1);
            textArea.setFont(font);
    }
    private void fontDown() {
        Font font = new Font(textArea.getFont().getFontName(),0,textArea.getFont().getSize()-1);
        textArea.setFont(font);
    }
}

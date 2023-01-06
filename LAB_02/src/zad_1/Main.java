package zad_1;

import javax.swing.*;

public class Main extends JFrame {
    private JPanel panel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton OKButton;

    public Main(){
        this.setContentPane(panel);
        this.setSize(400,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OKButton.addActionListener(e -> OkHandler());
    }

    public static void main(String[] args) {
        new Main();
    }

    public void OkHandler(){
        String pw1 = String.valueOf(passwordField1.getPassword());
        String pw2 = String.valueOf(passwordField2.getPassword());
        if(!pw1.contentEquals(pw2)){
            JOptionPane.showMessageDialog(this,"Passwords do not matched!","message",JOptionPane.INFORMATION_MESSAGE);
        } else if (pw1.contentEquals(pw2) && !pw1.contentEquals("codejava")) {
            JOptionPane.showMessageDialog(this,"Wrong password!","message",JOptionPane.INFORMATION_MESSAGE);
        }else if (pw1.contentEquals(pw2) && pw1.contentEquals("codejava")){
            JOptionPane.showMessageDialog(this,"Congratulations! you entered correct password.","message",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

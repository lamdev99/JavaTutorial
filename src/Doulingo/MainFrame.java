package Doulingo;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public int status;
    JPanel panelLogin,panelPratice;
    JLabel doulingo;
    public void setStatus(int status){
        this.status = status;
    }
    public MainFrame(){
        doulingo = new JLabel("Doulingo");
        doulingo.setFont(new Font("Arial", Font.BOLD, 50));
        doulingo.setBounds(400, 80, 300, 100);
        doulingo.setForeground(Color.WHITE);
        add(doulingo);
        panelLogin = new JPanel();
        panelLogin = new Login().getPanel();
        panelPratice = new JPanel();
        panelPratice = new ScreenPratice().getPanel();
        add(panelLogin);
        add(panelPratice);
        panelPratice.setVisible(false);

        setSize(1000,600);
        setTitle("Doulingo");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void addPraticePanel(){
        doulingo.setVisible(false);
        panelLogin.setVisible(false);
        panelPratice.setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}

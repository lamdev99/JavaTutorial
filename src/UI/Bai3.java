package UI;

import BaiCuoiKi.Jbutton;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Bai3 extends JFrame {
    JFrame f;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem login, exit;
    JTextArea area;
    public Bai3() {
        f = new JFrame();
        init();
        f.setJMenuBar(menuBar);

        f.setSize(500,500);
        area.setBounds(0,100,500,400);
        f.add(area);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(  null,"Do you want to close " +
                        "this app","Question",JOptionPane.YES_NO_OPTION);
                if(n==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                else{

                }
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name,email;
                name = new JTextField();
                email = new JTextField();
                JButton confirm = new JButton("Confirm");
                JCheckBox cbox = new JCheckBox("Show email");
                JDialog dialog = new JDialog(f,"Dialog");
                dialog.setLayout(new BorderLayout());
                JPanel panel = new JPanel(new GridLayout(2,2));
                panel.add(new JLabel("Name:"));
                panel.add(name);
                panel.add(new JLabel("Email:"));
                panel.add(email);
                dialog.add(panel,BorderLayout.CENTER);
                dialog.add(confirm,BorderLayout.EAST);
                dialog.add(cbox,BorderLayout.SOUTH);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);
                confirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameE = name.getText();
                        String emailE = email.getText();
                        area.append("Name: "+nameE+"\n"+"Email: "+emailE);
                        if(cbox.isSelected()){
                            email.setVisible(false);
                        }
                        else{
                            email.setVisible(true);
                        }
                        dialog.setVisible(false);
                    }
                });
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
    public void init(){
        menuBar = new JMenuBar();
        file = new JMenu("File");
        login = new JMenuItem("Login");
        login.setMnemonic(KeyEvent.VK_L);
        exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        file.add(login);file.add(exit);
        menuBar.add(file);
        area = new JTextArea();
    }
    public static void main(String[] args) {
        new Bai3();

    }
}

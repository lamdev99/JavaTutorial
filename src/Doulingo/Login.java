package Doulingo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JPanel panel,panel1,panelUP;
    JTextField user;
    JPasswordField pass;
    JLabel signUp,forgot;
    JButton login;
    public Login() {

    }

    public void init() {
        login = new JButton("Login");
        panel1 = new JPanel(new BorderLayout());
        panelUP = new JPanel(new GridLayout(3,2));
        user = new JTextField();
        pass = new JPasswordField();
        signUp = new JLabel("Sign Up");
        forgot = new JLabel("Forgot");
        panelUP.add(new JLabel("Username: "));
        panelUP.add(user);
        panelUP.add(new JLabel("Password: "));
        panelUP.add(pass);
        panelUP.add(forgot);
        panelUP.add(signUp);
        panelUP.setBackground(Color.WHITE);
        panel1.add(new JLabel("Login"),BorderLayout.NORTH);
        panel1.add(panelUP,BorderLayout.CENTER);
        panel1.add(login,BorderLayout.SOUTH);

        panel = new JPanel();
        panel.setLayout(null);
        ImageIcon image = new ImageIcon(getClass().getResource("bg92.jpg"));
        JLabel label = new JLabel(image);
        panel.setSize(1000,600);
        label.setBounds(0,0,1000,600);
        panel1.setBounds(600,200,300,150);
        panel1.setBackground(Color.WHITE);
        panel.add(panel1);
        panel.add(label);
        panel.setBackground(Color.WHITE);

    }
    public void addListener(){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.getText().equals("user")&&pass.getText().equals("pass")){
                    //System.out.println(1);
                    new MainFrame().addPraticePanel();
                }
            }
        });
    }
    public JPanel getPanel(){
        init();
        addListener();
        return panel;
    }
}


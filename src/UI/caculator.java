package UI;

import BaiCuoiKi.Jbutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class caculator extends JFrame implements ActionListener {
    JPanel panel;
    JTextArea result;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, cong, tru, nhan, chia, luy, can, bang;
    String pheptoan ="";
    String s1 = "0",s2 = "0";
    public caculator() {
        init();
        setLayout(new BorderLayout());
        panel =  new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        panel.add(b9);
        panel.add(b8);
        panel.add(b7);
        panel.add(cong);
        panel.add(b6);
        panel.add(b5);
        panel.add(b4);
        panel.add(tru);
        panel.add(b3);
        panel.add(b2);
        panel.add(b1);
        panel.add(nhan);
        panel.add(b0);
        panel.add(luy);
        panel.add(can);
        panel.add(chia);
        addAction();
        result = new JTextArea();
        result.setFont(new Font("Arial", Font.BOLD,20));

        add(result,BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        add(bang,BorderLayout.SOUTH);
        //setSize(300, 600);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void addAction(){
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        cong.addActionListener(this);
        tru.addActionListener(this);
        nhan.addActionListener(this);
        chia.addActionListener(this);
        luy.addActionListener(this);
        can.addActionListener(this);
        bang.addActionListener(this);
    }
    public void init() {
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        cong = new JButton("+");
        tru = new JButton("-");
        nhan = new JButton("x");
        chia = new JButton(":");
        luy = new JButton("^");
        can = new JButton("sqrt");
        bang = new JButton("=");
    }

    public static void main(String[] args) {
        new caculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cong){
            pheptoan = "+";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==tru){
            pheptoan = "-";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==nhan){
            pheptoan = "*";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==chia){
            pheptoan = ":";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==luy){
            pheptoan = "^";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==can){
            pheptoan = "sqrt";
            s1 = result.getText();
            result.setText("");
        }
        else if(e.getSource()==bang){
            s2 = result.getText();
            process();
        }
        else{
            result.append(e.getActionCommand());
        }

    }
    public void process(){
        if(pheptoan=="sqrt"){
            int n2 = Integer.parseInt(s2.toString());
            result.setText(String.valueOf(Math.sqrt(n2)));
            return;
        }
        int n2 = Integer.parseInt(s2.toString());
        int n1 = Integer.parseInt(s1.toString());
        System.out.println(n1+" "+n2);
        switch (pheptoan){
            case "+":{
                result.setText(String.valueOf(n1+n2));
                break;
            }
            case "-":{
                result.setText(String.valueOf(n1-n2));
                break;
            }
            case "*":{
                result.setText(String.valueOf(n1*n2));
                break;
            }
            case ":":{
                if(n2==0){
                    result.setText("Math error!");
                    break;
                }
                Double b = Double.valueOf(n1/n2);
                result.setText(String.valueOf(b));
                break;
            }
            case "^":{
                result.setText(String.valueOf(n1^n2));
                break;
            }
            case "sqrt":{
                result.setText(String.valueOf(Math.sqrt(n2)));
                break;
            }
            default: break;
        }
    }
}

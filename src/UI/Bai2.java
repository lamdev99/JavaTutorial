package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Bai2 extends JFrame {
    JFrame f;
    String textRe,textCh;
    JMenuBar menuBar;
    JTextArea text;
    JMenu menu;
    JMenuItem item;
    JTextField textT,textS;
    JCheckBox replaceAll;
    JButton replace;
    boolean reAll;
    public Bai2() {
        f = new JFrame();
        create();
        menuBar.add(menu);
        f.setJMenuBar(menuBar);
        f.add(menuBar);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(1);
                textT = new JTextField();
                textS = new JTextField();
                replaceAll = new JCheckBox("ReplaceAll");
                replace = new JButton("Replace");
                JDialog d = new JDialog(f,"Replace");
                d.setLayout(new GridLayout(3,2));
                d.add(new JLabel("Find what:"));
                d.add(textT);
                d.add(new JLabel("Replace with:"));
                d.add(textS);
                d.add(replaceAll);
                d.add(replace);


                replace.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reAll = replaceAll.isSelected();
                        textRe = textT.getText();
                        textCh = textS.getText();
                        String textNow = text.getText();
                        if(reAll) textNow = textNow.replaceAll(textRe,textCh);
                        else{
                            textNow = textNow.replaceFirst(textRe,textCh);
                        }
                        text.setText(textNow);
                        d.setVisible(false);
                    }
                });
                d.setLocationRelativeTo(null);
                d.setSize(300,300);
                d.pack();
                d.setVisible(true);
               // add(d);
            }
        });
        f.add(text);
        text.setBounds(0,100,500,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(500, 500);
    }
    public void create(){
        text = new JTextArea();
        menuBar = new JMenuBar();
        menu = new JMenu("Option");
        item = new JMenuItem("Replace");
        item.setMnemonic(KeyEvent.VK_H);
        menu.add(item);

    }
    public static void main(String[] args) {
        new Bai2();
    }
}

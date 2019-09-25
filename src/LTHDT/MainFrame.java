package LTHDT;

import InOutJava.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame jFrame;
    public MainFrame(){
        jFrame = new JFrame();
        PanelSach panelSach = new PanelSach();
        jFrame.add(panelSach.getPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

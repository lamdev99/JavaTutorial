package BaiCuoiKi;

import javax.swing.*;

class JTabbedPanee{
    JFrame jFrame;
    JTextArea jTextArea;
    JPanel panel1,panel2,panel3;
    JTabbedPane jTabbedPane;
    public void createFrame(){
        init();
        addToFrame();
    }
    public void init(){
        jFrame = new JFrame();
        jTextArea = new JTextArea(200,200);
        Table table = new Table();
        table.createTable();
        panel1 = table.returnPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        jTabbedPane = new JTabbedPane();
    }
    public void addToFrame(){
        jTabbedPane.setBounds(50,50,700,600);
        jTabbedPane.add(panel1,"School");
        jTabbedPane.add(panel2,"Sinh Vien");
        jTabbedPane.add(panel3,"Diem");
//        panel1.add(jTextArea);

        jFrame.add(jTabbedPane);
        jFrame.setSize(1000,1000);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

}

public class JtabbedPane {
    public static void main(String[] args) {
        new JTabbedPanee().createFrame();
    }
}

package TestCuoiKi;


import javax.swing.*;

class ShowFrame implements InterfaceDo{
    JFrame jFrame;
    JPanel panelSach,panelBD,panelQL;
    JTabbedPane jTabbedPane;

    public ShowFrame() {
        init();
        setBoundd();
        addToFrame();
    }

    @Override
    public JPanel getPanel() {
        return null;
    }

    @Override
    public JPanel createTable() {
        return null;
    }

    @Override
    public void init() {
        jFrame = new JFrame("De SO 1");
        panelSach = new PanelSach().createTable();
        panelBD = new JPanel();
        panelQL = new JPanel();
        jTabbedPane = new JTabbedPane();
    }

    @Override
    public void addToFrame() {
        jTabbedPane.add(panelSach,"Sach");
        jTabbedPane.add(panelBD,"Ban Doc");
        jTabbedPane.add(panelQL,"Quan Li");
        jFrame.add(jTabbedPane);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void setBoundd() {
        jTabbedPane.setBounds(50,50,700,700);
        jFrame.setSize(1000,1000);

    }

    @Override
    public void addEvent() {

    }
}

public class AllFrame {
    public static void main(String[] args) {
        new ShowFrame();
    }
}

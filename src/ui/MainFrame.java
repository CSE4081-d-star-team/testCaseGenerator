package src.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 0L;

    //Fixed frame size
	final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;
    static int SCREEN_CENTER_X;
    static int SCREEN_CENTER_Y;

    //global variable
    MenuBar menuBar; //This is discrete from java.awt.MenuBar;
    MainPanel mainPanel;

    public MainFrame () {
        //Name of the frame
        super("Matrix Generator");

        //Components initialization
    	setupFrame();
        addMenuBar();
        addMainPanel();
        this.addMouseListener(ml);
        validate();
    }

    public void setScreenLocation(JFrame frame,
                                         int windowWidth,
                                         int windowHight) {
        GraphicsEnvironment ge
        = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        SCREEN_CENTER_X = centerPoint.x - windowWidth / 2;
        SCREEN_CENTER_Y = centerPoint.y - windowHight / 2;
    }

	private void setupFrame() {
		//setIconImage();
        setResizable(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setScreenLocation(this, FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(SCREEN_CENTER_X,
                    SCREEN_CENTER_Y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        requestFocusInWindow();
    }

    private void addMenuBar() {
        menuBar = new MenuBar();
        this.setJMenuBar(menuBar);
    }

    public void addMainPanel() {
        mainPanel = new MainPanel();
        this.add(mainPanel);
    }

    ArrayList<Component> textFields = new ArrayList<Component>();

    private void listAllComponentsIn(Container parent) {
        for (Component c : parent.getComponents()) {
            if (c instanceof JTextField)
                textFields.add((JTextField)c);
            if (c instanceof Container)
                listAllComponentsIn((Container)c);
        }
    }

    MouseListener ml = new MouseListener() {
        public void mouseClicked(MouseEvent e) {
            listAllComponentsIn(mainPanel);
            for (int i = 0; i < textFields.size(); i++) {
                JTextField jtf = (JTextField)textFields.get(i);
                jtf.setBackground(Color.WHITE);
                String text = jtf.getText();
                if (text.equals("")) {
                    jtf.setText("Type integer");
                }
            }
        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
    };
}

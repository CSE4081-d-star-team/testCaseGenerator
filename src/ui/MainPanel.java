package src.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import src.map.Generator;

public class MainPanel extends JPanel implements ActionListener {
    JTextField seedTField, matrixSizeTField;
    JLabel fileLabel, seedLabel, matrixSizeLabel;
    JButton genButton, locateFileButton;
    JPanel emptyPanel, functionPanel, topPanel, middlePanel, bottomPanel;
    Font smallerFont = new Font("Dialog", Font.BOLD, 12);
    Font font = new Font("Dialog", Font.BOLD, 16);
    Border lineBrdr = BorderFactory.createLineBorder(ColorCodes.traitColor);
    Border bevelBrdr = BorderFactory.createBevelBorder(BevelBorder.RAISED);
    Border etchedBrdr = BorderFactory.createEtchedBorder();
    Border compBrdr = BorderFactory.createCompoundBorder();

    String filePath = "./data/output.txt";

    MainPanel() {
        setBackgroundPanels();
        activateListener();
    }

    private void setBackgroundPanels() {
        this.setLayout(new GridLayout(8, 1, 2, 2));
        emptyPanel = new JPanel();
        functionPanel = new JPanel();
        setFilePanel();
        topPanel = new JPanel();
        setTopPanel();
        middlePanel = new JPanel();
        setMiddlePanel();
        bottomPanel = new JPanel();
        setBottomPanel();
        this.add(emptyPanel);
        this.add(functionPanel);
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    private void addFileComponents() {
        locateFileButton = new JButton("Set Path");
        locateFileButton.setFont(smallerFont);
        locateFileButton.setVerticalAlignment(JLabel.CENTER);
        locateFileButton.setHorizontalAlignment(JLabel.CENTER);
        locateFileButton.setPreferredSize(new Dimension(100, 30));
        locateFileButton.setBorder(compBrdr);
        locateFileButton.setBackground(ColorCodes.menubarColor);
        fileLabel = new JLabel("./data/output.txt");
        fileLabel.setFont(smallerFont);
        fileLabel.setVerticalAlignment(JLabel.CENTER);
        fileLabel.setHorizontalAlignment(JLabel.CENTER);
        fileLabel.setPreferredSize(new Dimension(100, 30));

        functionPanel.add(fileLabel);
        functionPanel.add(locateFileButton);
    }

    private void setFilePanel() {
        functionPanel.setLayout(new FlowLayout());
        addFileComponents();
    }

    private void addLabels() {
        matrixSizeLabel = new JLabel();
        matrixSizeLabel.setVerticalAlignment(JLabel.CENTER);
        matrixSizeLabel.setHorizontalAlignment(JLabel.CENTER);
        matrixSizeLabel.setPreferredSize(new Dimension(100, 30));
        matrixSizeLabel.setBorder(compBrdr);
        matrixSizeLabel.setBackground(ColorCodes.menubarColor);
        //matrixSizeLabel.setForeground(Color.BLACK);
        matrixSizeLabel.setFont(font);
        matrixSizeLabel.setText("  Matrix Size  ");
        matrixSizeLabel.setOpaque(true);
        matrixSizeLabel.repaint();
        matrixSizeLabel.setVisible(true);
        seedLabel = new JLabel();
        seedLabel.setVerticalAlignment(JLabel.CENTER);
        seedLabel.setHorizontalAlignment(JLabel.CENTER);
        seedLabel.setPreferredSize(new Dimension(100, 30));
        seedLabel.setBorder(compBrdr);
        seedLabel.setBackground(ColorCodes.menubarColor);
        //seedLabel.setForeground(Color.BLACK);
        seedLabel.setFont(font);
        seedLabel.setText("  Seed  ");
        seedLabel.setOpaque(true);
        seedLabel.repaint();
        seedLabel.setVisible(true);

        topPanel.add(new JPanel());
        topPanel.add(matrixSizeLabel);
        topPanel.add(seedLabel);
        topPanel.add(new JPanel());
    }

    private void setTopPanel() {
        topPanel.setLayout(new FlowLayout());
        addLabels();
    }

    private void addTextFiels() {
        matrixSizeTField = new JTextField("Type integer");
        matrixSizeTField.setPreferredSize(new Dimension(100, 30));
        matrixSizeTField.setHorizontalAlignment(JLabel.CENTER);
        seedTField = new JTextField("Type integer");
        seedTField.setPreferredSize(new Dimension(100, 30));
        seedTField.setHorizontalAlignment(JLabel.CENTER);


        middlePanel.add(matrixSizeTField);
        middlePanel.add(seedTField);
    }

    private void setMiddlePanel() {
        middlePanel.setLayout(new FlowLayout());
        addTextFiels();
    }

    private void addButtons() {
        genButton = new JButton("Generate");
        genButton.setBackground(ColorCodes.traitColor);
        bottomPanel.add(genButton);
    }

    private void setBottomPanel() {
        bottomPanel.setLayout(new FlowLayout());
        addButtons();
    }

    MouseListener ml = new MouseListener() {
        Color tempColor;
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JTextField) {
                JTextField jtf= (JTextField)e.getSource();
                jtf.setBackground(Color.WHITE);
                jtf.setText("");
            }
        }
        public void mousePressed(MouseEvent e) {
            if (e.getSource() instanceof JTextField) {
                JTextField jtf= (JTextField)e.getSource();
                jtf.setBackground(Color.WHITE);
                jtf.setText("");
            }
        }
        public void mouseReleased(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {
            ((JComponent)e.getSource()).setBackground(tempColor);
            if (e.getSource() instanceof JTextField) {
                JTextField jtf= (JTextField)e.getSource();
                jtf.setBackground(Color.WHITE);
            }
        }
        public void mouseEntered(MouseEvent e) {
            tempColor = ((JComponent)e.getSource()).getBackground();
            ((JComponent)e.getSource()).setBackground(ColorCodes.backgroundColor);
        }
    };

    public void activateListener() {
        genButton.addActionListener(this);
        locateFileButton.addActionListener(this);
        genButton.setFocusable(false);

        genButton.addMouseListener(ml);
        seedTField.addMouseListener(ml);
        matrixSizeTField.addMouseListener(ml);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(genButton)) {
            int seed = Integer.parseInt(seedTField.getText());
            int matrixSize = Integer.parseInt(matrixSizeTField.getText());

            Generator generator = new Generator(matrixSize, seed);
            generator.exportToFile(filePath);
            
        } else if (obj.equals(locateFileButton)) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                filePath = selectedFile.getName();
                fileLabel.setText(filePath);
            }
        }
    }
}

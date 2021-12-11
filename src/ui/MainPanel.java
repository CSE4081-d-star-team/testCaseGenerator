package src.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusListener;
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

import src.file.ImportFile;
import src.map.Generator;

public class MainPanel extends JPanel implements ActionListener {
    JTextField seedTField, matrixSizeTField, obstacFieldNumTField;
    JLabel fileLabel, seedLabel, matrixSizeLabel, obstacFieldNumTLabel;
    JButton genButton, locateFileButton, editorButton;
    JPanel emptyPanel, functionPanel, topPanel, middlePanel, bottomPanel;
    Font smallerFont = new Font("Dialog", Font.BOLD, 12);
    Font font = new Font("Dialog", Font.BOLD, 16);
    Border lineBrdr = BorderFactory.createLineBorder(ColorCodes.traitColor);
    Border bevelBrdr = BorderFactory.createBevelBorder(BevelBorder.RAISED);
    Border etchedBrdr = BorderFactory.createEtchedBorder();
    Border compBrdr = BorderFactory.createCompoundBorder();

    static String filePath = "./data/output.txt";
    static File workingDirectory = new File(filePath);
    MainPanel() {
        setBackgroundPanels();
        activateListener();
    }

    private void setBackgroundPanels() {
        this.setLayout(new GridLayout(8, 1, 2, 2));
        emptyPanel = new JPanel();
        functionPanel = new JPanel();
        functionPanel.setPreferredSize(new Dimension(300, 30));
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
        locateFileButton.setPreferredSize(new Dimension(80, 30));
        locateFileButton.setBorder(compBrdr);
        locateFileButton.setBackground(ColorCodes.menubarColor);
        fileLabel = new JLabel("./data/output.txt");
        fileLabel.setFont(smallerFont);
        fileLabel.setVerticalAlignment(JLabel.CENTER);
        fileLabel.setHorizontalAlignment(JLabel.CENTER);
        fileLabel.setPreferredSize(new Dimension(220, 30));

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
        matrixSizeLabel.setPreferredSize(new Dimension(130, 30));
        matrixSizeLabel.setBorder(compBrdr);
        matrixSizeLabel.setBackground(ColorCodes.menubarColor);
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
        seedLabel.setFont(font);
        seedLabel.setText("  Seed  ");
        seedLabel.setOpaque(true);
        seedLabel.repaint();
        seedLabel.setVisible(true);

        obstacFieldNumTLabel = new JLabel();
        obstacFieldNumTLabel.setVerticalAlignment(JLabel.CENTER);
        obstacFieldNumTLabel.setHorizontalAlignment(JLabel.CENTER);
        obstacFieldNumTLabel.setPreferredSize(new Dimension(100, 30));
        obstacFieldNumTLabel.setBorder(compBrdr);
        obstacFieldNumTLabel.setBackground(ColorCodes.menubarColor);
        obstacFieldNumTLabel.setFont(font);
        obstacFieldNumTLabel.setText(" Obstacles ");
        obstacFieldNumTLabel.setOpaque(true);
        obstacFieldNumTLabel.repaint();
        obstacFieldNumTLabel.setVisible(true);

        topPanel.add(new JPanel());
        topPanel.add(matrixSizeLabel);
        topPanel.add(seedLabel);
        topPanel.add(obstacFieldNumTLabel);
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
        matrixSizeTField.setEditable(true);
        matrixSizeTField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (matrixSizeTField.getText().equals("Type integer")) {
                    matrixSizeTField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                if (matrixSizeTField.getText().equals("")) {
                    matrixSizeTField.setText("Type integer");
                }
            }
        });
        seedTField = new JTextField("Type integer");
        seedTField.setPreferredSize(new Dimension(100, 30));
        seedTField.setHorizontalAlignment(JLabel.CENTER);
        seedTField.setEditable(true);
        seedTField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (seedTField.getText().equals("Type integer")) {
                    seedTField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent arg0) {
                if (seedTField.getText().equals("")) {
                    seedTField.setText("Type integer");
                }
            }
        });

        obstacFieldNumTField = new JTextField("Type integer");
        obstacFieldNumTField.setPreferredSize(new Dimension(100, 30));
        obstacFieldNumTField.setHorizontalAlignment(JLabel.CENTER);
        obstacFieldNumTField.setEditable(true);
        obstacFieldNumTField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if (obstacFieldNumTField.getText().equals("Type integer")) {
                    obstacFieldNumTField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent arg0) {
                if (obstacFieldNumTField.getText().equals("")) {
                    obstacFieldNumTField.setText("Type integer");
                }
            }
        });

        middlePanel.add(matrixSizeTField);
        middlePanel.add(seedTField);
        middlePanel.add(obstacFieldNumTField);
    }

    private void setMiddlePanel() {
        middlePanel.setLayout(new FlowLayout());
        addTextFiels();
    }

    private void addButtons() {
        genButton = new JButton("Generate");
        genButton.setBackground(ColorCodes.traitColor);
        editorButton = new JButton("Editor");
        editorButton.setBackground(ColorCodes.traitColor);
        bottomPanel.add(genButton);
        bottomPanel.add(editorButton);
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
            }
        }
        public void mousePressed(MouseEvent e) {
            if (e.getSource() instanceof JTextField) {
                JTextField jtf= (JTextField)e.getSource();
                jtf.setBackground(Color.WHITE);
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
        editorButton.addActionListener(this);

        genButton.setFocusable(false);

        genButton.addMouseListener(ml);
        seedTField.addMouseListener(ml);
        matrixSizeTField.addMouseListener(ml);
        obstacFieldNumTField.addMouseListener(ml);
        editorButton.addMouseListener(ml);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(genButton)) {
            try {
                int seed = Integer.parseInt(seedTField.getText());
                int matrixSize = Integer.parseInt(matrixSizeTField.getText());
                int obstacleNum = Integer.parseInt(obstacFieldNumTField.getText());
                Generator generator = new Generator(matrixSize, seed, obstacleNum);
                generator.exportToFile(filePath);
            } catch (Exception ex) {
                System.out.println("Input numbers");
            }
        } else if (obj.equals(locateFileButton)) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setCurrentDirectory(workingDirectory);
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                //File selectedPath = fileChooser.getCurrentDirectory();
                File selectedFile = fileChooser.getSelectedFile();
                filePath = selectedFile.getAbsolutePath();
                fileLabel.setText(filePath);
            }
        } else if (obj.equals(editorButton)) {
            ImportFile importFile = new ImportFile();
            boolean exist = importFile.fileExist(filePath);
            if (exist) {
                System.out.println("File found");
                char[][] map = importFile.readFile(filePath);
                //Pop up map editor
                new MapEditor(map);
            } else {
                System.out.println("File not found");
                try {
                    int seed = Integer.parseInt(seedTField.getText());
                    int matrixSize = Integer.parseInt(matrixSizeTField.getText());
                    //Pop up map editor
                    new MapEditor(matrixSize, seed);
                } catch (Exception ex) {
                    System.out.println("Input numbers");
                }
            }
            
        }
    }
}

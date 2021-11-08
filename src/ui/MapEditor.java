package src.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import src.file.ExportFile;
import src.map.Generator;

public class MapEditor extends JFrame implements ActionListener {
    //make Frame relative to the size
    int FRAME_WIDTH = 30;
    int FRAME_HEIGHT = 30;
    int BLOCK_SIZE = 30;
    int SCREEN_CENTER_X = 0;
    int SCREEN_CENTER_Y = 0;

    GridPanel gridPanel;
    JPanel mainPanel;
    JButton saveButton, cancelButton;
    Font smallerFont = new Font("Dialog", Font.BOLD, 8);

    char[][] map;

    String filePath = MainPanel.filePath;
    String selected;

    public MapEditor (int gridSize, int seed) {
        //Name of the frame
        super("Matrix Generator");
        System.out.println("Making new editor");
        //Components initialization
        setFrameSize(gridSize);
    	setupFrame(gridSize);
        setMainPanel();

        Generator generator = new Generator(gridSize, seed);
        map = generator.getMap();

        //Make grid
        addGridPanel(gridSize);
        //save button - open up on save
        addButtonPanel();
        //setup listeners
        validate();
    }


    public MapEditor (char[][] map) {
        //Name of the frame
        super("Matrix Generator");
        System.out.println("Loaded editor");
        this.map = map;
        //Components initialization
        setFrameSize(map.length);
    	setupFrame(map.length);
        setMainPanel();
        //Make grid
        addGridPanel(map.length);

        //save button - open up on save
        addButtonPanel();

        //setup listeners
        validate();
    }

    private void setFrameSize(int gridSize) {
        FRAME_WIDTH = 40 + gridSize * FRAME_WIDTH;
        FRAME_HEIGHT = 60 + gridSize * FRAME_HEIGHT;
        GraphicsEnvironment ge
        = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        SCREEN_CENTER_X = centerPoint.x - FRAME_WIDTH / 2;
        SCREEN_CENTER_Y = centerPoint.y - FRAME_HEIGHT / 2;
    }
    
    private void setupFrame(int gridSize) {
        setResizable(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(SCREEN_CENTER_X, SCREEN_CENTER_Y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        this.setVisible(true);
        requestFocusInWindow();
    }

    private void setMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0) );
        mainPanel.setVisible(true);
        mainPanel.validate();
        add(mainPanel);
    }

    private void addGridPanel(int gridSize) {
        gridPanel = new GridPanel(gridSize, map);
        gridPanel.setPreferredSize(new Dimension(gridSize * BLOCK_SIZE,
         gridSize * BLOCK_SIZE));
        mainPanel.add(gridPanel);
    }

    private void addButtonPanel() {
        ButtonPanel buttonPanel = new ButtonPanel();
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        mainPanel.add(buttonPanel);
    }

    class GridPanel extends JPanel {
        
        GridPanel (int gridSize, char[][] map) {
            System.out.println(gridSize);
            setLayout(new GridLayout(gridSize, gridSize));
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if (map[i][j] == 'W') {
                        add(new JButton("W") {
                            @Override
                            public synchronized void addMouseListener(MouseListener l) {
                                super.setBackground(ColorCodes.backgroundColor);
                                super.addMouseListener(setMouseListener(this));
                            }
                            
                            @Override
                            public void setFont(Font arg0) {
                                super.setFont(smallerFont);
                            }

                            @Override
                            public void setMargin(Insets m) {
                                super.setMargin(new Insets(0, 0, 0, 0));
                            }

                            @Override
                            public void setBorder(Border border) {
                                super.setBorder(null);
                            }
                        });
                    } else if (map[i][j] == 'X') {
                        add(new JButton("X") {
                            @Override
                            public synchronized void addMouseListener(MouseListener l) {
                                super.setBackground(ColorCodes.backgroundColor);
                                super.addMouseListener(setMouseListener(this));
                            }
                            
                            @Override
                            public void setFont(Font arg0) {
                                super.setFont(smallerFont);
                            }
                            
                            @Override
                            public void setMargin(Insets m) {
                                super.setMargin(new Insets(0, 0, 0, 0));
                            }

                            @Override
                            public void setBorder(Border border) {
                                super.setBorder(null);
                            }
                        });
                    } else if (map[i][j] == ' ') {
                        add(new JButton(" ") {
                            @Override
                            public synchronized void addMouseListener(MouseListener l) {
                                super.setBackground(ColorCodes.backgroundColor);
                                super.addMouseListener(setMouseListener(this));
                            }

                            @Override
                            public void setFont(Font arg0) {
                                super.setFont(smallerFont);
                            }

                            @Override
                            public void setMargin(Insets m) {
                                super.setMargin(new Insets(0, 0, 0, 0));
                            }

                            @Override
                            public void setBorder(Border border) {
                                super.setBorder(null);
                            }
                        });
                    } else if (map[i][j] == 'G') {
                        add(new JButton("G") {
                            @Override
                            public synchronized void addMouseListener(MouseListener l) {
                                super.setBackground(ColorCodes.backgroundColor);
                                super.addMouseListener(setMouseListener(this));
                            }

                            @Override
                            public void setFont(Font arg0) {
                                super.setFont(smallerFont);
                            }

                            @Override
                            public void setMargin(Insets m) {
                                super.setMargin(new Insets(0, 0, 0, 0));
                            }

                            @Override
                            public void setBorder(Border border) {
                                super.setBorder(null);
                            }

                            @Override
                            public void setForeground(Color arg0) {
                                super.setForeground(Color.RED);
                            }

                        });
                    }  else if (map[i][j] == 'R') {
                        add(new JButton("R") {

                            @Override
                            public synchronized void addMouseListener(MouseListener l) {
                                super.setBackground(ColorCodes.backgroundColor);
                                super.addMouseListener(setMouseListener(this));
                            }
                            @Override
                            public void setFont(Font arg0) {
                                super.setFont(smallerFont);
                            }

                            @Override
                            public void setMargin(Insets m) {
                                super.setMargin(new Insets(0, 0, 0, 0));
                            }

                            @Override
                            public void setBorder(Border border) {
                                super.setBorder(null);
                            }

                            @Override
                            public void setForeground(Color arg0) {
                                super.setForeground(Color.RED);
                            }
                        });
                    } else {
                        System.out.println("Somthing wrong" + map[i][j]);
                    }
                }
            }
        }

        private MouseListener setMouseListener(JButton button) {
            MouseListener ml = new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }
                public void mousePressed(MouseEvent e) {
                    button.setBackground(ColorCodes.traitColor);
                    if (button.getText().equals(" ")) {
                        selected = " ";
                        button.setText("X");
                    } else if (button.getText().equals("X")) {
                        button.setText(" ");
                        selected = "X";
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    button.setOpaque(true);
                    button.setBackground(ColorCodes.backgroundColor);
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setOpaque(true);
                    button.setBackground(ColorCodes.backgroundColor);
                    button.repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setOpaque(true);
                    //if right click is pressed
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        button.setBackground(ColorCodes.traitColor);
                        if (button.getText().equals(" ") && selected.equals(" ")) {
                            button.setText("X");
                        } else if (button.getText().equals("X") && selected.equals("X")) {
                            button.setText(" ");
                        }
                    } else {
                        button.setBackground(Color.WHITE);
                    }
                    button.repaint();
                }
            };
            return ml;
        }
    }

    
    private String gridToString() {
        int gridSize = map.length;

        //collect JButtons
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for (Component c : gridPanel.getComponents()) {
            if (c instanceof JButton) {
                buttons.add((JButton)c);
            }
        }

        StringBuilder sb = new StringBuilder();

        //Percolate data
        for (int i = 0; i < buttons.size(); i ++) {
            if (i % (gridSize) == 0 && i > 0) {
                sb.append("\n");
            }
            JButton selectedButton = buttons.get(i);
            sb.append(selectedButton.getText());
            sb.append(" ");
        }
        System.out.println("Saved");
        return sb.toString();
    }

    private void exportFile() {
        String content = gridToString();
        ExportFile export = new ExportFile();
        export.writeToFile(content, filePath);
    }

    class ButtonPanel extends JPanel {
        ButtonPanel() {
            saveButton = new JButton("Save");
            cancelButton = new JButton("Cancel");
            add(saveButton);
            add(cancelButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(cancelButton)) {
            this.dispose();
        } else if (obj.equals(saveButton)) {
            exportFile();
            this.dispose();
        }
    }
}
package src.ui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

class MenuBar extends JMenuBar implements ActionListener,
                                          MenuKeyListener {
    
    //File Tab
    final int FILE_OPEN = 0, FILE_EXIT = 1;

    public static JMenu fileTab, editTab, searchTab, helpTab;
    public static JMenuItem open, exit,       //File tab components
                            help, version;    //Help tab components
    private Insets insets = new Insets(10, 5, 10, 5);

    public MenuBar() {
        setupMenuBar();
        activateMenuListener();
    }

    MouseListener ml = new MouseListener() {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {
            ((JMenu)e.getSource()).setBackground(ColorCodes.traitColor);
        }
        public void mouseEntered(MouseEvent e) {
            ((JMenu)e.getSource()).setBackground(ColorCodes.hoverColor);
        }
    };

    private void setupMenuBar() {
        this.setBorderPainted(true);
        this.setBackground(ColorCodes.menubarColor);
        this.setOpaque(true);
        this.setMargin(insets);

        addFileTab();
        addEditTab();
        addSearchTab();
        addHelpTab();
    }

    private void addFileTab() {
        fileTab = new JMenu("File");
        fileTab.setOpaque(true);
        fileTab.setBackground(ColorCodes.traitColor);
        addFileMenuItems();
        this.add(fileTab);
    }

    private void addFileMenuItems() {
        open = new JMenuItem("Open");
        fileTab.add(open);

        exit = new JMenuItem("Exit");
        fileTab.add(exit);
    }

    private void addEditTab() {
        editTab = new JMenu("Edit");
        editTab.setBackground(ColorCodes.traitColor);
        editTab.setOpaque(true);
        addEditMenuItems();
        this.add(editTab);
    }

    private void addEditMenuItems() {
        
    }

    private void addSearchTab() {
        searchTab = new JMenu("Search");
        searchTab.setBackground(ColorCodes.traitColor);
        searchTab.setOpaque(true);
        addSearchMenuItems();
        this.add(searchTab);
    }

    private void addSearchMenuItems() {
        // TODO menu items to be added
    }

    private void addHelpTab() {
        helpTab = new JMenu("Help");
        helpTab.setBackground(ColorCodes.traitColor);
        helpTab.setOpaque(true);
        addHelpMenuItems();
        this.add(helpTab);

    }

    private void addHelpMenuItems() {
        help = new JMenuItem("About Map Generator");
        helpTab.add(help);

        version = new JMenuItem("Program Version");
        helpTab.add(version);
    }

    public void activateMenuListener() {
        open.addActionListener(this);
        exit.addActionListener(this);
        help.addActionListener(this);
        version.addActionListener(this);

        open.addMenuKeyListener(this);
        exit.addMenuKeyListener(this);
        help.addMenuKeyListener(this);
        version.addMenuKeyListener(this);

        fileTab.addMouseListener(ml);
        editTab.addMouseListener(ml);
        searchTab.addMouseListener(ml);
        helpTab.addMouseListener(ml);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        //menu bar objects
        if (object.equals(fileTab.getItem(FILE_OPEN))) {

        } else if (object.equals(fileTab.getItem(FILE_EXIT))) {
            System.exit(0);
        }
    }

    @Override
    public void menuKeyTyped(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyPressed(MenuKeyEvent e) {

    }

    @Override
    public void menuKeyReleased(MenuKeyEvent e) {

    }
}
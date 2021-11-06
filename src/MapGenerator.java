package src;

import src.ui.MainFrame;

public class MapGenerator {

    private void runUI() {
        new MainFrame();
    }

    public static void main (String[] args) {
        MapGenerator mainInstatnce = new MapGenerator();
        mainInstatnce.runUI();
    }
}
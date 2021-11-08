package src.map;

import src.file.ExportFile;
import src.setup.CharSet;

import java.util.Random;

public class Generator {
    
    int MATRIX_SIZE = 0;
    int SEED = 1;
    char[][] map;
    public Generator(int matrixSize, int seed) {
        this.MATRIX_SIZE = matrixSize;
        this.map = new char[matrixSize + 2][matrixSize + 2];
        SEED = seed;
        createArray();
        generateObstacles();
    }

    private void createArray() {
        for (int i = 0; i < MATRIX_SIZE + 2; i++) {
            for (int j = 0; j < MATRIX_SIZE + 2; j++) {
                //starting location fixed
                if (i == 2 && j == 2) {
                    map[i][j] = CharSet.ROBOT;
                    continue;
                }

                //starting location fixed relative to the matrix size
                if (i == MATRIX_SIZE - 1 && j == MATRIX_SIZE - 1) {
                    map[i][j] = CharSet.GOAL;
                    continue;
                }

                if (i == 0) {
                    map[i][j] = CharSet.WALL;
                }

                else if (j == 0) {
                    map[i][j] = CharSet.WALL;
                }

                else if (i == MATRIX_SIZE + 1) {
                    map[i][j] = CharSet.WALL;
                }

                else if (j == MATRIX_SIZE + 1) {
                    map[i][j] = CharSet.WALL;
                }

                else {
                    map[i][j] = CharSet.EMPTY_CELL;
                }
            }
        }
    }

    private void generateObstacles() {
        int bound = 10 * SEED;
        Random rand = new Random(SEED);
        for (int i = 0; i < MATRIX_SIZE + 2; i++) {
            for (int j = 0; j < MATRIX_SIZE + 2; j++) {
                //Random seed
                int number = rand.nextInt(bound);
                if (number < bound / 3) {
                    if (CharSet.isEmptyCell(this.map[i][j])) {
                        this.map[i][j] = CharSet.OBSTACLE;
                    }
                }
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < MATRIX_SIZE + 2; i++) {
            for (int j = 0; j < MATRIX_SIZE + 2; j++) {
                str += this.map[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public String toString (char[][] map) {
        String str = "";
        for (int i = 0; i < MATRIX_SIZE + 2; i++) {
            for (int j = 0; j < MATRIX_SIZE + 2; j++) {
                str += map[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public char[][] getMap() {
        return this.map;
    }

    public void exportToFile(String filePath) {
        String content = toString();
        ExportFile wf = new ExportFile();
        wf.writeToFile(content, filePath);
    }

    public void exportToFile(String filePath, char[][] map) {
        String content = toString(map);
        ExportFile wf = new ExportFile();
        wf.writeToFile(content, filePath);
    }
}

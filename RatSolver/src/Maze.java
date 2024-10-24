import java.util.*;
import java.io.*;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Maze
{
    private static char TRIED = 'o';
    private static char PATH = 'C';
    private int numberRows, numberColumns = 0;
    private int startPointR;
    private int startPointC;
    private int endPointR;
    private int endPointC;
    private char[][] grid;
    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(filename));
        /*while(scan.hasNext()) {
            scan.next();
            numberColumns++;
        }
        scan.reset();
        scan = new Scanner(new File(filename));
        while(scan.hasNextLine()){
            scan.nextLine();
            numberRows++;
        }
        /*


        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            numberRows++;
            numberColumns = line.length();
        }
        scan.reset();
        scan = new Scanner(new File(filename));

        grid = new char[numberRows][numberColumns];
        int row = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            for (int col = 0; col < line.length();col++){
                grid[row][col] = line.charAt(col);
                if(line.charAt(col) == 'R') {
                    startPointRow = row;
                    startPointCol = col;
                }
                if(line.charAt(col) == 'C') {
                    endPointRow = row;
                    endPointCol = col;
                }
            }
            row++;
        }
        System.out.println(endPointRow);
        System.out.println(endPointCol);
    } */

        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];

        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                grid[i][j] = scan.next().charAt(0);

                if (grid[i][j] == 'R') {
                    startPointR = i;
                    startPointC = j;
                }
                if (grid[i][j] == 'C') {
                    endPointR = i;
                    endPointC = j;
                }
            }
        }
    }


    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col) {
        if (grid[row][col] != 'C') {
            grid[row][col] = TRIED;
        }
    }
    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows()
    {
        return grid.length;
    }
    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }
    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }

    public int getStartPointR(){
        return startPointR;
    }
    public int getStartPointC(){
        return startPointC;
    }
    public int getEndPointR(){
        return endPointR;
    }
    public int getEndPointC(){
        return endPointC;
    }
        public boolean validPosition(int row, int column) {
        boolean result = false;

        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) {
            if (grid[row][column] != '#' && grid[row][column] != 'o') {
                result = true;
            }
        }

        return result;
    }

    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
        public String toString() {
        StringBuilder result = new StringBuilder("\n");

        for (char[] row : grid) {
            for (char cell : row) {
                result.append(cell);
            }
            result.append("\n");
        }

        return result.toString();
    }
}

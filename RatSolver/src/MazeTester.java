import java.util.*;
import java.io.*;
/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester {
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the name of the file containing the maze: ");
            String filename = scan.nextLine();
            Maze labyrinth = new Maze(filename);
            System.out.println(labyrinth);
            MazeSolver solver = new MazeSolver(labyrinth);
            if (solver.traverse(labyrinth.getStartPointR(), labyrinth.getStartPointC())) {
                System.out.println("The maze was successfully traversed!\nTraverse was called " + solver.traverseCall + " times.");
            } else {
                System.out.println("There is no possible path.");
            }

            String labyrinthString = labyrinth.toString().replace('o', '.').replace('C', 'o');
            int crumbs = countCrumbs(labyrinthString);
            System.out.println("There are " + crumbs + " breadcrumbs.");
            System.out.println(labyrinthString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int countCrumbs(String labyrinthString) {
        int crumbs = 0;
        for (char c : labyrinthString.toCharArray()) {
            if (c == 'o') {
                crumbs++;
            }
        }
        return crumbs;
    }
}



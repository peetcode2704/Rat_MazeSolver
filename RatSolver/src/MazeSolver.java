class MazeSolver {
    private Maze maze;
    public int traverseCall = 0;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public boolean traverse(int row, int column) {
        traverseCall++;

        boolean done = false;

        if (maze.validPosition(row, column)) {
            maze.tryPosition(row, column);

            int endRow = maze.getEndPointR();
            int endColumn = maze.getEndPointR();

            if (row == endRow && column == endColumn)
                done = true;
            else {
                if (!done) done = traverse(row - 1, column); // north
                if (!done) done = traverse(row + 1, column); // south
                if (!done) done = traverse(row, column + 1); // east
                if (!done) done = traverse(row, column - 1); // west
            }
            System.out.println("Rat is at ("+ row + "," + column + ")" + "\n");

            if (done) maze.markPath(row, column);
        }

        return done;
    }
}
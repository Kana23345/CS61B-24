import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    // TODO: Add any necessary instance variables.
    private boolean[][] grid;
    private int openSites = 0;
    private WeightedQuickUnionUF mainUfSet;
    private WeightedQuickUnionUF helpUfSet;
    private int TVIndex;
    private int BVIndex;
    private int size;

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        grid = new boolean[N][N];
        size = N;
        mainUfSet = new WeightedQuickUnionUF(N * N + 2);
        helpUfSet = new WeightedQuickUnionUF(N * N + 1);
        TVIndex = N * N;
        BVIndex = N * N + 1;
    }

    private int xyTo1D(int row, int col) {
        return row * size + col;
    }

    private void bigUnion(int index, int other) {
        mainUfSet.union(index, other);
        helpUfSet.union(index, other);
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        if (!grid[row][col]) {
            openSites += 1;
            grid[row][col] = true;
        }
        int index = xyTo1D(row, col);
        if (row > 0 && isOpen(row - 1, col)) bigUnion(index, xyTo1D(row - 1, col));
        if (col > 0 && isOpen(row, col - 1)) bigUnion(index, xyTo1D(row, col - 1));
        if (row < size && isOpen(row + 1, col)) bigUnion(index, xyTo1D(row + 1, col));
        if (col < size && isOpen(row, col + 1)) bigUnion(index, xyTo1D(row, col + 1));
        if (row == 0) bigUnion(index, TVIndex);
        if (row == size - 1) mainUfSet.union(index, BVIndex);

    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        if (!(row < size && row >= 0)) return false;
        if (!(col < size && col >= 0)) return false;
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        return helpUfSet.connected(xyTo1D(row, col), TVIndex);
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return openSites;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return mainUfSet.connected(TVIndex, BVIndex);
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}

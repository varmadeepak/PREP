public class Spot {

    private Piece currentPiece;
    private int row;
    private int col;

    Spot(int row, int col, Piece piece) {
        this.currentPiece = piece;
        this.row = row;
        this.col = col;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
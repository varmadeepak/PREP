package DESIGN.Systems.Chess;
abstract class Piece {
    private boolean isAlive = true;
    private boolean isWhite = true;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public void killPiece() {
        isAlive = false;
    }
    public boolean isPieceAlive() {
        return isAlive;
    }
    public void setWhite() {
        isWhite = true;
    }
    public void setBlack() {
        isWhite = false;
    }

    public abstract boolean canMove(Board board,Spot start,Spot end);
    public abstract void move(Board board,Spot start,Spot end);
    public abstract String getPieceType();
}

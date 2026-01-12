public class Move {

    private Player player;
    private Spot startSpot;
    private Spot endSpot;
    private Piece pieceMoved;
    private Piece pieceKilled;

    // No-args constructor
    public Move() {
    }

    // All-args constructor
    public Move(Player player, Spot startSpot, Spot endSpot,
                Piece pieceMoved, Piece pieceKilled) {
        this.player = player;
        this.startSpot = startSpot;
        this.endSpot = endSpot;
        this.pieceMoved = pieceMoved;
        this.pieceKilled = pieceKilled;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getStartSpot() {
        return startSpot;
    }

    public void setStartSpot(Spot startSpot) {
        this.startSpot = startSpot;
    }

    public Spot getEndSpot() {
        return endSpot;
    }

    public void setEndSpot(Spot endSpot) {
        this.endSpot = endSpot;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}
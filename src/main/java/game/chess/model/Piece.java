package game.chess.model;

public class Piece {
    private boolean dead = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }
}

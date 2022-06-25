package game.chess.model;

public class Piece {
    private boolean dead = false;
    private boolean white = false;

    // for move validation we can use method overriding.
    // https://beginnersbook.com/2014/01/method-overriding-in-java-with-example/

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isDead() {
        return this.dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

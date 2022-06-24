package game.chess.model;

import java.util.List;

public class Pawn extends Piece {

    private boolean firstMove;

    public Pawn(boolean white) {
        super(white);
        firstMove = true;
    }


    // Given a position of a pawn and its position, return the coordinates of valid moves.
    /*
    public List<List<Integer>> validMoves() {
    // On firstMove, a pawn can move two spaces ahead.
    // otherwise, he can only move one space ahead.
    // he can only capture diagonally.
    // he can only capture peices that are not the same color as him.


    }
    */

}

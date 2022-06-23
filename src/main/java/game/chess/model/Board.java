package game.chess.model;

public class Board {

    private Tile[][] gameBoard = new Tile[8][8];


    /* Initialize an empty game board */
    public Board() {

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                gameBoard[i][j] = new Tile(i, j);
            }
        }
    }

    public void setupGameBoard() {
        // place pawns on row 1 and 6.
        for(int i = 0; i < 8; i++) {
            gameBoard[1][i].setPiece(new Pawn(false));

        }
    }
}

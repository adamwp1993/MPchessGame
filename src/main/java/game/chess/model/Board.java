package game.chess.model;

import javafx.scene.layout.GridPane;

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
    /* sets up the gameboard in standard chess format. */
    public void setupGameBoard() {
        // TODO: finish this
        // place pawns on row 1 and 6.
        for(int i = 0; i < 8; i++) {
            gameBoard[i][1].setPiece(new Pawn(false));

        }
        for(int j = 0; j < 8; j++) {
            gameBoard[j][6].setPiece(new Pawn(true));
        }
        // Rooks go in corners.
        gameBoard[0][0].setPiece(new Rook(false));
        gameBoard[7][0].setPiece(new Rook(false));
        gameBoard[0][7].setPiece(new Rook(true));
        gameBoard[7][7].setPiece(new Rook(true));
        // knights go next to rooks.
        gameBoard[1][0].setPiece(new Knight(false));
        gameBoard[6][0].setPiece(new Knight(false));
        gameBoard[1][7].setPiece(new Knight(true));
        gameBoard[6][7].setPiece(new Knight(true));
        // Bishops go next to knights.
        gameBoard[2][0].setPiece(new Bishop(false));
        gameBoard[5][0].setPiece(new Bishop(false));
        gameBoard[2][7].setPiece(new Bishop(true));
        gameBoard[5][7].setPiece(new Bishop(true));
        // Kings
        gameBoard[4][0].setPiece(new King(false));
        gameBoard[4][7].setPiece(new King(true));
        // Queens
        gameBoard[3][0].setPiece(new Queen(false));
        gameBoard[3][7].setPiece(new Queen(true));
    }

    /*
    * returns the gameBoard 2D array, the logical representation of the board currently.
    * Tiles hold the locations of pieces.
    */
    public Tile[][] getGameBoard() {
        return this.gameBoard;
    }
}

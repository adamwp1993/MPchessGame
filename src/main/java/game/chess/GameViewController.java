package game.chess;

import game.chess.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {

    private Pane[][] paneArray;
    private List<Pane> paneList;
    private Board chessBoard;
    // Load .png's of chess pieces
    private final Image whiteQueen = new Image(getClass().getResource("whiteQueen.png").toURI().toString());
    private final Image blackQueen = new Image(getClass().getResource("blackQueen.png").toURI().toString());
    private final Image whiteBishop = new Image(getClass().getResource("whiteBishop.png").toURI().toString());
    private final Image blackBishop = new Image(getClass().getResource("blackBishop.png").toURI().toString());
    private final Image whiteKnight = new Image(getClass().getResource("whiteKnight.png").toURI().toString());
    private final Image blackKnight = new Image(getClass().getResource("blackKnight.png").toURI().toString());
    private final Image whiteRook = new Image(getClass().getResource("whiteRook.png").toURI().toString());
    private final Image blackRook = new Image(getClass().getResource("blackRook.png").toURI().toString());
    private final Image whitePawn = new Image(getClass().getResource("whitePawn.png").toURI().toString());
    private final Image blackPawn = new Image(getClass().getResource("blackPawn.png").toURI().toString());
    private final Image whiteKing = new Image(getClass().getResource("whiteKing.png").toURI().toString());
    private final Image blackKing = new Image(getClass().getResource("blackKing.png").toURI().toString());

    @FXML
    public GridPane grid;

    @FXML
    private Button forfeitButton;

    @FXML
    private Button rotateButton;

    public GameViewController() throws URISyntaxException {
    }

    public void initialize(URL location, ResourceBundle resources) {
        // draw the board squares
        drawBoard();
        // create chessBoard Object which is the logical representation of the chess board.
        chessBoard = new Board();
        // initialize pieces
        chessBoard.setupGameBoard();
        // display pieces on screen.
        try {
            displayBoard();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        // TODO: create game engine - handles game flow
    }

    public void clickPiece() {
        //https://stackoverflow.com/questions/50012463/how-can-i-click-a-gridpane-cell-and-have-it-perform-an-action
        // handles the click of a peice on the board.
        // this needs to integrate with the gameEngine.
        // Step 1: handle clicking a piece. determine if it is the players turn.
        // Step 2: for said piece, validate moves. This will probably be built into the
        // Step 3: highlight valid cells
    }

    public void displayBoard() throws URISyntaxException {
        // retrieve current gameBoard from model
        // O(N) where N = number of squares on the board (64)
        // technically its O(1) because the number of squares will always be 64 =P

        Tile[][] tempBoard = chessBoard.getGameBoard();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                // if a piece is on the tile, we display the piece.
                if(tempBoard[i][j].getPiece() != null) {
                    // display the right .png for the piece
                    Piece curPiece = tempBoard[i][j].getPiece();
                    boolean isWhite = curPiece.isWhite();
                    // there's probably a much cleaner way to do this, but for now it will do

                    if(curPiece instanceof Pawn) {
                        if (isWhite) {
                            grid.add(new ImageView(whitePawn), i, j);
                        } else {
                            grid.add(new ImageView(blackPawn), i, j);
                        }
                    }
                    else if(curPiece instanceof Rook) {
                        if (isWhite) {
                            grid.add(new ImageView(whiteRook), i, j);
                        } else {
                            grid.add(new ImageView(blackRook), i, j);
                        }
                    }
                    else if(curPiece instanceof Bishop) {
                        if (isWhite) {
                            grid.add(new ImageView(whiteBishop), i, j);
                        } else {
                            grid.add(new ImageView(blackBishop), i, j);
                        }
                    }
                    else if(curPiece instanceof Knight) {
                        if (isWhite) {
                            grid.add(new ImageView(whiteKnight), i, j);
                        } else {
                            grid.add(new ImageView(blackKnight), i, j);
                        }
                    }
                    else if(curPiece instanceof Queen) {
                        if (isWhite) {
                            grid.add(new ImageView(whiteQueen), i, j);
                        } else {
                            grid.add(new ImageView(blackQueen), i, j);
                        }
                    }
                    else if(curPiece instanceof King) {
                        if (isWhite) {
                            grid.add(new ImageView(whiteKing), i, j);
                        } else {
                            grid.add(new ImageView(blackKing), i, j);
                        }
                    }


                }
            }
        }
    }

    // Draws the squares of the board in different colors.
    public void drawBoard() {
        paneList = new ArrayList<>();
        paneArray = new Pane[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pane pane = new Pane();
                paneList.add(pane);
                paneArray[i][j] = pane;

                String blackStyle = "-fx-background-color: grey;",
                        whiteSytle= "-fx-background-color: white;";

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        pane.setStyle(blackStyle);
                    } else {
                        pane.setStyle(whiteSytle);
                    }
                } else {
                    if (j % 2 != 0) {
                        pane.setStyle(blackStyle);
                    } else {
                        pane.setStyle(whiteSytle);
                    }
                }

                grid.add(pane, j, i);
            }
        }
    }

    public void switchScreen(ActionEvent event, String switchPath) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(switchPath));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}

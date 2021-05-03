package ui;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


//JPanel representing the playable chess board
public class ChessBoardPanel extends JPanel {

    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    public static final int QUEEN = 0;
    public static final int KING = 1;
    public static final int ROOK = 2;
    public static final int KNIGHT = 3;
    public static final int BISHOP = 4;
    public static final int PAWN = 5;
    public static final int[] STARTING_ROW = {
            ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    public static final int BLACK = 0;
    public static final int WHITE = 1;

    public ChessBoardPanel() {
        initialize();
    }

    //Modifies: this
    //Effects: Sets ups the interface of the Chess Board
    public void initialize() {
        createImages();

        this.setLayout(new GridLayout(8, 8));
        this.setPreferredSize(new Dimension(800, 800));

        this.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
        this.setBackground(Color.gray);

        createChessBoardSquares();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.add(chessBoardSquares[i][j]);
            }
        }
    }

    //Modifies: this
    //Effects: Creates the chess board
    private void createChessBoardSquares() {
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[i][j] = b;
            }
        }
    }

    //Modifies: this
    //Effects: creates the chess piece images
    public void createImages() {
        try {
            BufferedImage bi = ImageIO.read(new File("./data/ChessPieces.png"));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 6; j++) {
                    chessPieceImages[i][j] = bi.getSubimage(j * 64, i * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Modifies: this
    //Effects: sets up the pieces of the initial chess board
    public final void setupNewGame() {

        for (int j = 0; j < STARTING_ROW.length; j++) {
            chessBoardSquares[0][j].setIcon(new ImageIcon(chessPieceImages[BLACK][STARTING_ROW[j]]));
            chessBoardSquares[1][j].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
            chessBoardSquares[6][j].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
            chessBoardSquares[7][j].setIcon(new ImageIcon(chessPieceImages[WHITE][STARTING_ROW[j]]));
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardSquares[i][j].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
            }
        }
    }

    //Modifies: this
    //Effects: sets up the pieces of a loaded chess board
    public final void setupLoadedGame(Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String name = board.getBlocks()[i][j].getPiece().getName();
                int colour = board.getBlocks()[i][j].getPiece().colour ? WHITE : BLACK;
                loadedPiecesAssigner(i, j, name, colour);
            }
        }
    }

    //Modifies: this
    //Effects: assigns the pieces to their loaded spots
    private void loadedPiecesAssigner(int i, int j, String name, int colour) {
        switch (name) {
            case "Pawn":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][PAWN]));
                break;
            case "Knight":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][KNIGHT]));
                break;
            case "Rook":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][ROOK]));
                break;
            case "Bishop":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][BISHOP]));
                break;
            case "King":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][KING]));
                break;
            case "Queen":
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(chessPieceImages[colour][QUEEN]));
                break;
            default:
                chessBoardSquares[7 - i][j].setIcon(new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
        }
    }

    public JButton[][] getChessBoardSquares() {
        return chessBoardSquares;
    }

    //To test the panel
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("MoveHistoryPanel Test");
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        testFrame.add(chessBoardPanel);
        testFrame.pack();
        testFrame.setVisible(true);
    }
}

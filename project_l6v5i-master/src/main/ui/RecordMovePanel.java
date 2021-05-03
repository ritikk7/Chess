package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//JPanel representing the textboxes where the user enters their move
public class RecordMovePanel extends JPanel {

    private JTextField source;
    private JTextField destination;
    private JButton enter;
    ChessBoardPanel chessBoardPanel;
    MoveHistoryPanel moveHistoryPanel;
    KilledPiecesPanel killedPiecesPanel;
    private Player player;
    private Board board;
    private KilledPieces list;

    public RecordMovePanel() {
        initialize();
    }

    //Modifies: this
    //Effects: sets up the interface of the RecordMovePanel
    public void initialize() {
        this.setLayout(new FlowLayout());

        setSource();
        setDestination();
        setEnter();

        this.add(source);
        this.add(destination);
        this.add(enter);
        this.setPreferredSize(new Dimension(300, 60));
    }

    //Modifies: this
    //Effects: sets up the source textbox to accept the starting point of a move
    public void setSource() {
        source = new JTextField("From");
        source.setPreferredSize(new Dimension(90, 50));
        source.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                source.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (source.getText().equals("")) {
                    source.setText("From");
                }
            }
        });
    }

    //Modifies: this
    //Effects: sets up the destination textbox to accept the starting point of a move
    public void setDestination() {
        destination = new JTextField("To");
        destination.setPreferredSize(new Dimension(90, 50));
        destination.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                destination.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (destination.getText().equals("")) {
                    destination.setText("To");
                }
            }
        });
    }

    //Modifies: this
    //Effects: sets up the enter button to accept the chess move
    public void setEnter() {
        enter = new JButton("Enter");
        enter.setPreferredSize(new Dimension(90, 50));
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn(source.getText(), destination.getText(), player);
            }
        });
    }

    //Modifies: this
    //Effects: validates a player's turn and moves the chess piece
    public void turn(String start, String end, Player p) {
        int x1 = start.toUpperCase().charAt(0) - 65;
        int y1 = start.charAt(1) - 49;
        int x2 = end.toUpperCase().charAt(0) - 65;
        int y2 = end.charAt(1) - 49;
        Block startP = board.blocks[y1][x1];
        Block endP = board.blocks[y2][x2];

        if (startP.getPiece().isValidMove(board, startP, endP) && startP.getPiece().getColour() == p.getColour()) {
            ChessPiece killed = p.move(startP, endP, chessBoardPanel.getChessBoardSquares());
            p.setColour(!p.getColour());
            list.addKilledPieces(killed);
            moveHistoryPanel.printMove(colourDecider(
                    endP.getPiece().colour) + " " + endP.getPiece().getName() + " moves from " + start.toUpperCase(
            ) + " to " + end.toUpperCase());
            killedPiecesPanel.printMove(list);
            checkMate(killed, p);
        } else {
            moveHistoryPanel.printMove("Invalid Move. Try Again");
        }
    }

    //Modifies: this
    //Effects: kills the the opponent's king and ends the game
    public void checkMate(ChessPiece killed, Player p) {
        if (killed instanceof King && p.getColour() != killed.getColour()) {
            moveHistoryPanel.printMove("CheckMate!");
            moveHistoryPanel.printMove("Game End!");
            System.exit(0);
        }
    }

    public void setChessBoardPanel(ChessBoardPanel chessBoardPanel) {
        this.chessBoardPanel = chessBoardPanel;
    }

    public void setMoveHistoryPanel(MoveHistoryPanel moveHistoryPanel) {
        this.moveHistoryPanel = moveHistoryPanel;
    }

    public void setKilledPiecesPanel(KilledPiecesPanel killedPiecesPanel) {
        this.killedPiecesPanel = killedPiecesPanel;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setList(KilledPieces list) {
        this.list = list;
    }

    //Modifies:
    //Effects: decides the colour of the chess piece
    public String colourDecider(boolean colour) {
        if (colour) {
            return "White";
        } else {
            return "Black";
        }
    }

    // To test the panel
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("ControlPanel Test");
        RecordMovePanel recordMovePanel = new RecordMovePanel();
        testFrame.add(recordMovePanel);
        testFrame.pack();
        testFrame.setVisible(true);
    }
}
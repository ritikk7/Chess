package ui;

import model.KilledPieces;

import javax.swing.*;
import java.awt.*;

//JPanel representing the Pieces that are killed on the chess board
public class KilledPiecesPanel extends JPanel {

    private JScrollPane killedPiecesScrollPane;
    private JTextArea killedPiecesTextArea;
    private String killedPiecesContent;

    public KilledPiecesPanel() {
        initialize();
    }

    //Modifies: this
    //Effects: prints out the killed pieces
    public void printMove(KilledPieces list) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                killedPiecesTextArea.setText(list.toString());
            }
        });
    }

    //Modifies: this
    //Effects: sets up the interface for KilledPiecesPanel
    private void initialize() {
        killedPiecesContent = new String();
        killedPiecesTextArea = new JTextArea(killedPiecesContent);
        killedPiecesTextArea.setBackground(Color.GRAY);
        killedPiecesScrollPane = new JScrollPane(killedPiecesTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        killedPiecesScrollPane.setBorder(BorderFactory.createTitledBorder("Killed Pieces"));
        killedPiecesScrollPane.setViewportView(killedPiecesTextArea);
        killedPiecesScrollPane.setPreferredSize(new Dimension(300, 140));
        this.add(killedPiecesScrollPane);
    }

    //To test the panel
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("MoveHistoryPanel Test");
        KilledPiecesPanel testKilledPiecesPanel = new KilledPiecesPanel();
        testFrame.add(testKilledPiecesPanel);
        testFrame.pack();
        testFrame.setVisible(true);
    }
}

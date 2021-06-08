package ui;

import javax.swing.*;
import java.awt.*;

//JPanel representing the Move History of both players
public class MoveHistoryPanel extends JPanel {

    private JScrollPane moveHistoryScrollPane;
    private JTextArea moveHistoryTextArea;
    private String moveHistoryContent;

    public MoveHistoryPanel() {
        initialize();
    }

    //Modifies: this
    //Effects: prints the move made by the player
    public void printMove(String move) {
        moveHistoryContent += move + "\n";
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                moveHistoryTextArea.setText(moveHistoryContent);
            }
        });
    }

    //Modifies: this
    //Effects: sets up the interface of the MoveHistoryPanel
    private void initialize() {
        moveHistoryContent = "Game start!\n";
        moveHistoryTextArea = new JTextArea(moveHistoryContent);
        moveHistoryTextArea.setBackground(Color.GRAY);
        moveHistoryScrollPane = new JScrollPane(moveHistoryTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        moveHistoryScrollPane.setBorder(BorderFactory.createTitledBorder("Move History"));
        moveHistoryScrollPane.setViewportView(moveHistoryTextArea);
        moveHistoryScrollPane.setPreferredSize(new Dimension(300, 400));
        this.add(moveHistoryScrollPane);
    }

    //To test the panel
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("MoveHistoryPanel Test");
        MoveHistoryPanel testMoveHistoryPanel = new MoveHistoryPanel();
        testFrame.add(testMoveHistoryPanel);
        testFrame.pack();
        testFrame.setVisible(true);
    }
}

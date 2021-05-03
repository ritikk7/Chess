package ui;

import model.Board;
import model.KilledPieces;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;

//Main JFrame which combines all the panels and acts as a central point of access for all data transfer between panels
public class MainFrame extends JFrame {

    private static final String JSON_STORE = "./data/Chess.json";
    private ChessBoardPanel chessBoardPanel;
    private KilledPiecesPanel killedPiecesPanel;
    private ControlPanel controlPanel;
    private MoveHistoryPanel moveHistoryPanel;
    private RecordMovePanel recordMovePanel;
    private Board board;
    private Player player;
    private KilledPieces list;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public MainFrame() {
        this.board = new Board();
        this.player = new Player(true, "Player");
        this.list = new KilledPieces();
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);
        this.chessBoardPanel = new ChessBoardPanel();
        this.killedPiecesPanel = new KilledPiecesPanel();
        this.controlPanel = new ControlPanel();
        this.moveHistoryPanel = new MoveHistoryPanel();
        this.recordMovePanel = new RecordMovePanel();
        setControlPanel();
        setRecordMovePanel();
        loadInterface();
    }

    //Modifies: this
    //Effects: sets the required objects for the RecordMovePanel to function and play the game
    private void setRecordMovePanel() {
        this.recordMovePanel.setChessBoardPanel(this.chessBoardPanel);
        this.recordMovePanel.setMoveHistoryPanel(this.moveHistoryPanel);
        this.recordMovePanel.setKilledPiecesPanel(this.killedPiecesPanel);
        this.recordMovePanel.setBoard(this.board);
        this.recordMovePanel.setPlayer(this.player);
        this.recordMovePanel.setList(this.list);
    }

    //Modifies: this
    //Effects: sets the the required objects for the ControlPanel to function
    private void setControlPanel() {
        this.controlPanel.setChessBoardPanel(this.chessBoardPanel);
        this.controlPanel.setBoard(this.board);
        this.controlPanel.setPlayer(this.player);
        this.controlPanel.setJsonWriter(this.jsonWriter);
        this.controlPanel.setJsonReader(this.jsonReader);
    }

    //Modifies: this
    //Effects: Sets up up the interface for the JFrame
    private void loadInterface() {
        initializePanels();
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Modifies: this
    //Effects: Combines all the panels using a GridBagLayout
    public void initializePanels() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        // BoardPanel
        gridBagLayout.setConstraints(chessBoardPanel, assignConstraints(0, 0, 5, 5));
        this.add(chessBoardPanel);

        // RecordMovePanel
        gridBagLayout.setConstraints(recordMovePanel, assignConstraints(6, 0, 1, 1));
        this.add(recordMovePanel);

        // ControlPanel
        gridBagLayout.setConstraints(controlPanel, assignConstraints(6, 1, 1, 1));
        this.add(controlPanel);

        // KilledPiecesPanel
        gridBagLayout.setConstraints(killedPiecesPanel, assignConstraints(6, 2, 1, 1));
        this.add(killedPiecesPanel);

        // MoveHistoryPanel
        gridBagLayout.setConstraints(moveHistoryPanel, assignConstraints(6, 3, 1, 2));
        this.add(moveHistoryPanel);
    }

    //Effects: returns the GridBagConstraints for the various panels
    public GridBagConstraints assignConstraints(int x, int y, int w, int h) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.gridheight = h;
        return gridBagConstraints;
    }

    //To test the frame
    public static void main(String[] args) {
        MainFrame testFrame = new MainFrame();
        testFrame.pack();
        testFrame.setVisible(true);
    }
}

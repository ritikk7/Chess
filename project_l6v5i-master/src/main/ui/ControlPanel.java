package ui;

import model.Board;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


//JPanel representing the control buttons like Save, Load and New Game.
public class ControlPanel extends JPanel {

    private static final String JSON_STORE = "./data/Chess.json";
    private JButton newButton;
    private JButton saveButton;
    private JButton loadButton;
    private ChessBoardPanel chessBoardPanel;
    private Board board;
    private Player player;
    JsonWriter jsonWriter;
    JsonReader jsonReader;

    public ControlPanel() {
        initialize();
    }

    //Modifies: this
    //Effects: sets up the interface of the ControlPanel
    public void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(0, 1));

        setNewButton();
        setSaveButton();
        setLoadButton();

        this.add(newButton);
        this.add(saveButton);
        this.add(loadButton);
        this.setPreferredSize(new Dimension(300, 200));
    }

    //Modifies: this
    //Effects: sets up the load button to load a game
    private void setLoadButton() {
        loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadChessGame();
                chessBoardPanel.setupLoadedGame(board);
            }
        });
    }

    //Modifies: this
    //Effects: sets up the save button to save a game
    private void setSaveButton() {
        saveButton = new JButton("Save Game");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChessGame();
            }
        });
    }

    //Modifies: this
    //Effects: sets up the new button to set up the board for a new game
    private void setNewButton() {
        newButton = new JButton("New Game");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessBoardPanel.setupNewGame();
                board.setNewBoard();
            }
        });
    }

    public void setChessBoardPanel(ChessBoardPanel chessBoardPanel) {
        this.chessBoardPanel = chessBoardPanel;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setJsonWriter(JsonWriter jsonWriter) {
        this.jsonWriter = jsonWriter;
    }

    public void setJsonReader(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    /**
     * This method was adapted from a template for JSON Serialization as part of the course CPSC 210
     * at the University of British Columbia written by Dr. Paul Carter
     * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
     */

    // EFFECTS: saves chess board to file
    private void saveChessGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(board);
            jsonWriter.close();
            System.out.println("Saved Game Progress to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    /**
     * This method was adapted from a template for JSON Serialization as part of the course CPSC 210
     * at the University of British Columbia written by Dr. Paul Carter
     * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
     */

    // MODIFIES: this
    // EFFECTS: loads chess board from file
    private void loadChessGame() {
        try {
            board = jsonReader.read();
            System.out.println("Loaded Game Progress from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //To test the panel
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("ControlPanel Test");
        ControlPanel testControlPanel = new ControlPanel();
        testFrame.add(testControlPanel);
        testFrame.pack();
        testFrame.setVisible(true);
    }

}

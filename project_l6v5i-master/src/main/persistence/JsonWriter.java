package persistence;

import model.Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.*;

/**
 * This class was adapted from a template for JSON Serialization as part of the course CPSC 210
 * at the University of British Columbia written by Dr. Paul Carter
 * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
 */

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of chess board to file
    public void write(Board board) {
        JSONArray json = board.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

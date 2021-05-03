package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class was adapted from a template for JSON Serialization as part of the course CPSC 210
 * at the University of British Columbia written by Dr. Paul Carter
 * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
 */

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads chess board from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Board read() throws IOException {
        String jsonData = readFile(source);
        JSONArray jsonArray = new JSONArray(jsonData);
        return parseBoard(jsonArray);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses chess board from JSON array and returns it
    private Board parseBoard(JSONArray jsonArray) {
        Board board = new Board();
        addPieces(board, jsonArray);
        return board;
    }

    // MODIFIES: board
    // EFFECTS: parses chess pieces from JSON array and adds them to chess board
    private void addPieces(Board board, JSONArray jsonArray) {
        for (Object json : jsonArray) {
            JSONObject block = (JSONObject) json;
            int y = block.getInt("YPos");
            int x = block.getInt("XPos");
            String piece = block.getString("ChessPiece");
            boolean colour = block.getBoolean("PieceColour");

            switch (piece) {
                case "Pawn": board.getBlocks()[y][x].setPiece(new Pawn(colour));
                    break;
                case "Knight": board.getBlocks()[y][x].setPiece(new Knight(colour));
                    break;
                case "Rook": board.getBlocks()[y][x].setPiece(new Rook(colour));
                    break;
                case "Bishop": board.getBlocks()[y][x].setPiece(new Bishop(colour));
                    break;
                case "King": board.getBlocks()[y][x].setPiece(new King(colour));
                    break;
                case "Queen": board.getBlocks()[y][x].setPiece(new Queen(colour));
                    break;
                default: board.getBlocks()[y][x].setPiece(new EmptySpace(colour));
            }
        }
    }
}

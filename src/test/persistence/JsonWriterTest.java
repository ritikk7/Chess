package persistence;

import model.Board;
import model.EmptySpace;
import model.Pawn;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class was adapted from a template for JSON Serialization as part of the course CPSC 210
 * at the University of British Columbia written by Dr. Paul Carter
 * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
 */

class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Board board = new Board();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterDefaultChessBoard() {
        try {
            Board board = new Board();
            JsonWriter writer = new JsonWriter("./data/testWriterDefaultChessBoard.json");
            writer.open();
            writer.write(board);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterDefaultChessBoard.json");
            Board loadedBoard = reader.read();
            assertEquals(board.getBlocks()[0][3].getPiece().getName(), loadedBoard.getBlocks()[0][3].getPiece().getName());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralChessBoard() {
        try {
            Board board = new Board();
            board.changeBoard(2,3,new Pawn(true));
            board.changeBoard(1,3,new EmptySpace(true));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralChessBoard.json");
            writer.open();
            writer.write(board);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralChessBoard.json");
            Board loadedBoard = reader.read();
            assertEquals(board.getBlocks()[2][3].getPiece().getName(),loadedBoard.getBlocks()[2][3].getPiece().getName());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
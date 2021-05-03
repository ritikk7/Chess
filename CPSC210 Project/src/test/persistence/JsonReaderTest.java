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

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Board board = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderDefaultChessBoard() {
        JsonReader reader = new JsonReader("./data/testReaderDefaultChessBoard.json");
        try {
            Board board = new Board();
            Board loadedBoard = reader.read();
            assertEquals(board.getBlocks()[0][3].getPiece().getName(), loadedBoard.getBlocks()[0][3].getPiece().getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralChessBoard() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralChessRoom.json");
        try {
            Board board = new Board();
            board.changeBoard(2,3,new Pawn(true));
            board.changeBoard(1,3,new EmptySpace(true));
            Board loadedBoard = reader.read();
            assertEquals(board.getBlocks()[2][3].getPiece().getName(), loadedBoard.getBlocks()[2][3].getPiece().getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
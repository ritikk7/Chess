package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KilledPiecesTest {

    KilledPieces list;
    ChessPiece pawn;
    ChessPiece king;
    ChessPiece emptySpace;

    @BeforeEach
    void runBefore() {
        list = new KilledPieces();
        emptySpace = new EmptySpace(true);
        pawn = new Pawn(true);
        king = new King(false);
        list.addKilledPieces(pawn);
        list.addKilledPieces(king);
        list.addKilledPieces(emptySpace);
    }

    @Test
    void testAdding() {
        assertEquals(list.blackKilled.get(0),king);
        assertEquals(list.whiteKilled.get(0),pawn);
        assertEquals(list.toString(),"KilledPieces[White = Pawn, Black = King, ]");
    }
}

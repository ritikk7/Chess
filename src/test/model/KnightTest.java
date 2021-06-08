package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    Board board;
    EmptySpace emptySpace;
    Knight knight;
    Pawn pawn1;
    Pawn pawn2;
    Block startP1;
    Block endP1;
    Block endP2;
    Block endP3;
    Block endP4;
    Block endP5;

    @BeforeEach
    void runBefore() {
        board = new Board();
        emptySpace = new EmptySpace(true);
        knight = new Knight(true);
        pawn1 = new Pawn(false);
        pawn2 = new Pawn(true);
        startP1 = new Block(0, 1, knight);
        endP1 = new Block(2, 2, emptySpace);
        endP2 = new Block(2, 3, emptySpace);
        endP3 = new Block(2, 2, pawn1);
        endP4 = new Block(2, 2, pawn2);
        endP5 = new Block(2, 3, pawn1);
    }

    @Test
    public void testValidity() {
        assertEquals(knight.isValidMove(board,startP1,endP1),true);
        assertEquals(knight.isValidMove(board,startP1,endP2),false);
        assertEquals(knight.isValidMove(board,startP1,endP3),true);
        assertEquals(knight.isValidMove(board,startP1,endP4),false);
        assertEquals(knight.isValidMove(board,startP1,endP5),false);
        assertEquals(knight.getName(),"Knight");
    }
}

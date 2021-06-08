package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    Board board;
    EmptySpace emptySpace;
    Pawn pawn;
    Pawn pawn1;
    Pawn pawn2;
    Block startP1;
    Block endP1;
    Block endP2;
    Block endP3;
    Block endP4;
    Block endP5;
    Block endP6;
    Block endP7;
    Block endP8;
    Block endP9;

    @BeforeEach
    void runBefore() {
        board = new Board();
        emptySpace = new EmptySpace(true);
        pawn = new Pawn(true);
        pawn1 = new Pawn(false);
        pawn2 = new Pawn(true);
        startP1 = new Block(1, 1, pawn);
        endP1 = new Block(2, 1, emptySpace);
        endP2 = new Block(2, 2, emptySpace);
        endP3 = new Block(1, 2, emptySpace);
        endP4 = new Block(2, 1, pawn1);
        endP5 = new Block(2, 2, pawn1);
        endP6 = new Block(1, 2, pawn1);
        endP7 = new Block(2, 1, pawn2);
        endP8 = new Block(2, 2, pawn2);
        endP9 = new Block(1, 2, pawn2);
    }

    @Test
    public void testValidity() {
        assertEquals(pawn.isValidMove(board,startP1,endP1),true);
        assertEquals(pawn.isValidMove(board,startP1,endP2),false);
        assertEquals(pawn.isValidMove(board,startP1,endP3),false);
        assertEquals(pawn.isValidMove(board,startP1,endP4),false);
        assertEquals(pawn.isValidMove(board,startP1,endP5),true);
        assertEquals(pawn.isValidMove(board,startP1,endP6),false);
        assertEquals(pawn.isValidMove(board,startP1,endP7),false);
        assertEquals(pawn.isValidMove(board,startP1,endP8),false);
        assertEquals(pawn.isValidMove(board,startP1,endP9),false);
        assertEquals(pawn.getName(),"Pawn");
    }
}

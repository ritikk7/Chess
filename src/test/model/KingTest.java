package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {

    Board board;
    EmptySpace emptySpace;
    King king;
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
    Block endP10;
    Block endP11;
    Block endP12;
    Block endP13;
    Block endP14;
    Block endP15;
    Block endP16;
    Block endP17;
    Block endP18;

    @BeforeEach
    void runBefore() {
        board = new Board();
        emptySpace = new EmptySpace(true);
        king = new King(true);
        pawn1 = new Pawn(false);
        pawn2 = new Pawn(true);
        startP1 = new Block(0, 3, king);
        endP1 = new Block(0, 4, emptySpace);
        endP2 = new Block(0, 2, emptySpace);
        endP3 = new Block(1, 3, emptySpace);
        endP4 = new Block(1, 4, emptySpace);
        endP5 = new Block(1, 2, emptySpace);
        endP6 = new Block(2, 3, emptySpace);
        endP7 = new Block(0, 4, pawn1);
        endP8 = new Block(0, 2, pawn1);
        endP9 = new Block(1, 3, pawn1);
        endP10 = new Block(1, 4, pawn1);
        endP11 = new Block(1, 2, pawn1);
        endP12 = new Block(2, 3, pawn1);
        endP13 = new Block(0, 4, pawn2);
        endP14 = new Block(0, 2, pawn2);
        endP15 = new Block(1, 3, pawn2);
        endP16 = new Block(1, 4, pawn2);
        endP17 = new Block(1, 2, pawn2);
        endP18 = new Block(2, 3, pawn2);
    }

    @Test
    public void testValidity() {
        assertEquals(king.isValidMove(board,startP1,endP1),true);
        assertEquals(king.isValidMove(board,startP1,endP2),true);
        assertEquals(king.isValidMove(board,startP1,endP3),true);
        assertEquals(king.isValidMove(board,startP1,endP4),true);
        assertEquals(king.isValidMove(board,startP1,endP5),true);
        assertEquals(king.isValidMove(board,startP1,endP6),false);
        assertEquals(king.isValidMove(board,startP1,endP7),true);
        assertEquals(king.isValidMove(board,startP1,endP8),true);
        assertEquals(king.isValidMove(board,startP1,endP9),true);
        assertEquals(king.isValidMove(board,startP1,endP10),true);
        assertEquals(king.isValidMove(board,startP1,endP11),true);
        assertEquals(king.isValidMove(board,startP1,endP12),false);
        assertEquals(king.isValidMove(board,startP1,endP13),false);
        assertEquals(king.isValidMove(board,startP1,endP14),false);
        assertEquals(king.isValidMove(board,startP1,endP15),false);
        assertEquals(king.isValidMove(board,startP1,endP16),false);
        assertEquals(king.isValidMove(board,startP1,endP17),false);
        assertEquals(king.isValidMove(board,startP1,endP18),false);
        assertEquals(king.getName(),"King");
    }
}

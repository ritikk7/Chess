package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    Board board;
    EmptySpace emptySpace;
    Bishop bishop;
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
        bishop = new Bishop(true);
        pawn1 = new Pawn(false);
        pawn2 = new Pawn(true);
        startP1 = new Block(0, 2, bishop);
        endP1 = new Block(2, 4, emptySpace);
        endP2 = new Block(2, 5, emptySpace);
        endP3 = new Block(2, 4, pawn1);
        endP4 = new Block(2, 4, pawn2);
        endP5 = new Block(2, 5, pawn1);
    }

    @Test
    public void testValidity() {
        assertEquals(bishop.isValidMove(board,startP1,endP1),true);
        assertEquals(bishop.isValidMove(board,startP1,endP2),false);
        assertEquals(bishop.isValidMove(board,startP1,endP3),true);
        assertEquals(bishop.isValidMove(board,startP1,endP4),false);
        assertEquals(bishop.isValidMove(board,startP1,endP5),false);
        assertEquals(bishop.getName(),"Bishop");
    }
}
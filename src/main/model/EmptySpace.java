package model;

//Represents and Empty Space with no Chess Piece
public class EmptySpace extends ChessPiece {

    public String name = "EmptySpace";

    public EmptySpace(boolean colour) {
        super(colour);
    }

    public boolean isValidMove(Board board, Block startP, Block endP) {
        return false;
    }

    public String getName() {
        return name;
    }
}

package model;

//Represents an abstract Chess Piece
public abstract class ChessPiece {

    //True represents white, False represents Black
    public boolean colour;

    public ChessPiece(boolean colour) {
        setColour(colour);
    }

    public abstract boolean isValidMove(Board board, Block startP, Block endP);

    public boolean getColour() {
        return this.colour;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    public abstract String getName();
}

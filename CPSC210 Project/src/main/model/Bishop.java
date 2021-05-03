package model;

//Represents the Bishop Chess Piece
public class Bishop extends ChessPiece {

    public String name = "Bishop";

    public Bishop(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our Bishop must be empty or contain the opponent's piece
    //           and Bishop should only move diagonally
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());
        if (endP.getPiece() instanceof EmptySpace) {
            if (a == b) {
                return true;
            } else {
                return false;
            }
        } else {
            if (a == b  && endP.getPiece().getColour() != this.getColour()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String getName() {
        return name;
    }
}

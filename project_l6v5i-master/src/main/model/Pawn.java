package model;

//Represents the Pawn Chess Piece
public class Pawn extends ChessPiece {

    public String name = "Pawn";

    public Pawn(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our Pawn must be empty or contain the opponent's piece
    //          and the Pawn should only move 1 step in the forward direction unless there is an opponent piece
    //          on the diagonal path
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());

        if (endP.getPiece() instanceof EmptySpace) {
            if (b == 1 && a == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (a == b && b == 1 && endP.getPiece().getColour() != this.getColour()) {
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

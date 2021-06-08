package model;

//Represents the Knight Chess Piece
public class Knight extends ChessPiece {

    public String name = "Knight";

    public Knight(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our Knight must be empty or contain the opponent's piece
    //          and Knight should only move in an L shape
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());
        if (endP.getPiece() instanceof EmptySpace) {
            if (a * b == 2) {
                return true;
            } else {
                return false;
            }
        } else {
            if (a * b == 2 && endP.getPiece().getColour() != this.getColour()) {
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

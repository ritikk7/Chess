package model;

//Represents the King Chess Piece
public class King extends ChessPiece {

    public String name = "King";

    public King(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our King must be empty or contain the opponent's piece
    //          and King should only move 1 step in any direction (diagonal/vertical/horizontal)
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());
        boolean c = ((a == 0 && b > 0) || (b == 0 && a > 0) || a == b) && (b == 1 || a == 1);

        if (endP.getPiece() instanceof EmptySpace) {
            if (c) {
                return true;
            } else {
                return false;
            }
        } else {
            if (c && endP.getPiece().getColour() != this.getColour()) {
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

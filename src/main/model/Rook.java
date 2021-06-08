package model;

//Represents the Rook Chess Piece
public class Rook extends ChessPiece {

    public String name = "Rook";

    public Rook(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our Rook must be empty or contain the opponent's piece
    //          and the Rook should move only horizontally or vertically.
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());
        if (endP.getPiece() instanceof EmptySpace) {
            if ((a == 0 && b > 0) || (b == 0 && a > 0)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (((a == 0 && b > 0) || (b == 0 && a > 0)) && endP.getPiece().getColour() != this.getColour()) {
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

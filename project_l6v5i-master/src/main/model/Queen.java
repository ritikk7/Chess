package model;

//Represents the Queen Chess Piece
public class Queen extends ChessPiece {

    public String name = "Queen";

    public Queen(boolean colour) {
        super(colour);
    }

    //Requires: The block to which we will move our Queen must be empty or contain the opponent's piece
    //          and the Queen should move in any direction (diagonal/vertical/horizontal)
    //Modifies:
    //Effects: Checks the validity of the move from the start block to the end block
    public boolean isValidMove(Board board, Block startP, Block endP) {

        int a = Math.abs(startP.getXp() - endP.getXp());
        int b = Math.abs(startP.getYp() - endP.getYp());
        boolean c = (a == 0 && b > 0) || (b == 0 && a > 0) || a == b;

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
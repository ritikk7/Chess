package model;

import java.util.ArrayList;

//Represents a list with killed chess pieces
public class KilledPieces {

    ArrayList<ChessPiece> whiteKilled = new ArrayList<>();
    ArrayList<ChessPiece> blackKilled = new ArrayList<>();

    public void addKilledPieces(ChessPiece piece) {
        if (!(piece instanceof EmptySpace)) {
            if (piece.getColour() == true) {
                whiteKilled.add(piece);
            } else {
                blackKilled.add(piece);
            }
        }
    }

    @Override
    public String toString() {
        String white = "";
        String black = "";
        for (int i = 0; i < whiteKilled.size(); i++) {
            white += whiteKilled.get(i).getName() + ", ";
        }
        for (int i = 0; i < blackKilled.size(); i++) {
            black += blackKilled.get(i).getName() + ", ";
        }
        return "KilledPieces \nWhite: " + white + "\nBlack: " + black;
    }
}

package model;

import org.json.JSONObject;

//Represents a block on a chess board
public class Block {

    public ChessPiece piece;
    public int xp;
    public int yp;

    public Block(int yp, int xp, ChessPiece piece) {
        this.setPiece(piece);
        this.setXp(xp);
        this.setYp(yp);
    }

    public ChessPiece getPiece() {
        return this.piece;
    }

    public void setPiece(ChessPiece p) {
        this.piece = p;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getYp() {
        return this.yp;
    }

    public void setYp(int yp) {
        this.yp = yp;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("YPos", yp);
        json.put("XPos", xp);
        json.put("ChessPiece", piece.getName());
        json.put("PieceColour", piece.getColour());
        return json;
    }
}

package model;

import org.json.JSONArray;
import persistence.Writable;

//Represents a Chess Board
public class Board implements Writable {

    public Block [][] blocks;

    public Board() {
        setNewBoard();
    }

    public void setNewBoard() {
        blocks = new Block[8][8];
        blocks[0][0] = new Block(0,0, new Rook(true));
        blocks[0][1] = new Block(0,1, new Knight(true));
        blocks[0][2] = new Block(0,2, new Bishop(true));
        blocks[0][3] = new Block(0,3, new King(true));
        blocks[0][4] = new Block(0,4, new Queen(true));
        blocks[0][5] = new Block(0,5, new Bishop(true));
        blocks[0][6] = new Block(0,6, new Knight(true));
        blocks[0][7] = new Block(0,7, new Rook(true));
        blocks[7][0] = new Block(7,0, new Rook(false));
        blocks[7][1] = new Block(7,1, new Knight(false));
        blocks[7][2] = new Block(7,2, new Bishop(false));
        blocks[7][3] = new Block(7,3, new King(false));
        blocks[7][4] = new Block(7,4, new Queen(false));
        blocks[7][5] = new Block(7,5, new Bishop(false));
        blocks[7][6] = new Block(7,6, new Knight(false));
        blocks[7][7] = new Block(7,7, new Rook(false));
        addPawns();
        addEmptySpaces();
    }

    public void addPawns() {
        for (int i = 0; i < 8; i++) {
            blocks[1][i] = new Block(1, i, new Pawn(true));
            blocks[6][i] = new Block(6, i, new Pawn(false));
        }
    }

    public void addEmptySpaces() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                blocks[i][j] = new Block(i, j, new EmptySpace(true));
            }
        }
    }

    public Block[][] getBlocks() {
        return this.blocks;
    }

    public void changeBoard(int y, int x, ChessPiece piece) {
        blocks[y][x] = new Block(y,x,piece);
    }

    @Override
    public JSONArray toJson() {
        JSONArray json = new JSONArray();

        for (Block[] x : blocks) {
            for (Block y : x) {
                json.put(y.toJson());
            }
        }
        return json;
    }
}

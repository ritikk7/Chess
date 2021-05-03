package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ChessBoardPanel;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player player;
    ChessPiece queen;
    ChessPiece pawn;
    ChessPiece emptySpace;
    Block startP;
    Block endP1;
    Block endP2;
    ChessBoardPanel chessBoardPanel;

    @BeforeEach
    public void runBefore() {
        player = new Player(true, "PLayer");
        queen = new Queen(true);
        pawn = new Pawn(false);
        emptySpace = new EmptySpace(true);
        startP = new Block(1,2,queen);
        endP1 = new Block(2,2,emptySpace);
        endP2 = new Block(2,2,pawn);
        chessBoardPanel = new ChessBoardPanel();
    }

    @Test
    public void testChessPieceMove() {
        assertEquals(player.move(startP,endP1,chessBoardPanel.getChessBoardSquares()).getName(),emptySpace.getName());
        assertEquals(player.move(startP,endP2,chessBoardPanel.getChessBoardSquares()),pawn);
    }

}

package model;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

//Represents a player
public class Player {

    private boolean colour;
    private String name;

    public Player(boolean colour, String name) {
        setColour(colour);
        setName(name);
    }

    //Requires:
    //Modifies: endP
    //Effects: Moves the Chess Piece from Start to End and returns any Chess Piece that gets killed in the process.
    public ChessPiece move(Block startP, Block endP, JButton[][] chessBoardSquares) {
        ChessPiece killed = new EmptySpace(true);
        ImageIcon imageIcon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        if (!(endP.getPiece() instanceof EmptySpace)) {
            killed = endP.getPiece();
            System.out.println(startP.getPiece().getName() + " takes " + killed.getName() + "!");
        }
        endP.setPiece(startP.getPiece());
        chessBoardSquares[7 - endP.getYp()][endP.getXp()]
                .setIcon(chessBoardSquares[7 - startP.getYp()][startP.getXp()].getIcon());
        startP.setPiece(new EmptySpace(true));
        chessBoardSquares[7 - startP.getYp()][startP.getXp()].setIcon(imageIcon);
        playSound("./data/MoveSound.wav");
        return killed;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    public boolean getColour() {
        return this.colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
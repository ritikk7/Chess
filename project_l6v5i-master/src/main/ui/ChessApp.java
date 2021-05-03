//package ui;
//
//import model.*;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class ChessApp {
//
//    private static final String JSON_STORE = "./data/Chess.json";
//    Player p1;
//    Player p2;
//    Board board;
//    KilledPieces list;
//    JsonWriter jsonWriter;
//    JsonReader jsonReader;
//
//
//    //sets the Chess Board and Players
//    public ChessApp() {
//        p1 = new Player(true,"Player 1");
//        p2 = new Player(false, "Player 2");
//        board = new Board();
//        list = new KilledPieces();
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\nSelect from:");
//        System.out.println("\tp -> Play Chess");
//        System.out.println("\tl -> Load previous game progress from file");
//        System.out.println("\tq -> Quit");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    public void runChessGame() {
//        Scanner input = new Scanner(System.in);
//        displayMenu();
//        String command = input.next().toLowerCase();
//        processCommand(command);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        switch (command) {
//            case "p": play();
//                break;
//            case "l": loadChessGame();
//                play();
//                break;
//            case "q": exit();
//                break;
//            default: System.out.println("Selection not valid... Try Again!");
//        }
//    }
//
//    //Starts the game and switches turns between Players until one of them wins
//    public void play() {
//        Scanner input = new Scanner(System.in);
//        boolean gameEnd = false;
//
//        System.out.println("Welcome. Let's Play Chess!");
//        System.out.println("Press q at the end of round to quit the game.");
//        while (!gameEnd) {
//            boolean moveSuccess = false;
//            while (!moveSuccess) {
//                moveSuccess = playerMove(p1);
//            }
//            moveSuccess = false;
//            while (!moveSuccess) {
//                moveSuccess =  playerMove(p2);
//            }
//            System.out.println(list.toString());
//            saveChessGame();
//            System.out.println("Press q to quit or any other key to continue.");
//            String quit = input.next();
//            checkForQuit(quit);
//        }
//    }
//
//    //sets up a players turn by taking in the input for the move
//    public boolean playerMove(Player player) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("What is your move " + player.getName() + "?");
//        String start = input.nextLine();
//        System.out.println("to");
//        String end = input.nextLine();
//        return turn(start, end, player);
//    }
//
//    //plays the current player's turn while checking if the move is valid
//    public boolean turn(String start, String end, Player p) {
//        int x1 = start.toUpperCase().charAt(0) - 65;
//        int y1 = start.charAt(1) - 49;
//        int x2 = end.toUpperCase().charAt(0) - 65;
//        int y2 = end.charAt(1) - 49;
//        Block startP = board.blocks[y1][x1];
//        Block endP = board.blocks[y2][x2];
//
//        if (startP.getPiece().isValidMove(board, startP, endP)  && startP.getPiece().getColour() == p.getColour()) {
//            ChessPiece killed = p.move(startP,endP);
//            list.addKilledPieces(killed);
//            System.out.println(endP.getPiece().getName() + " moves from " + start + " to " + end);
//            checkMate(killed,p);
//            return true;
//        } else {
//            System.out.println("Invalid Move. Try Again");
//            return false;
//        }
//    }
//
//    //checks for checkmate
//    public void checkMate(ChessPiece killed,Player p) {
//        if (killed instanceof King && p.getColour() != killed.getColour()) {
//            System.out.println("CheckMate!");
//            exit();
//        }
//    }
//
//    //check if the player has chosen to quit the game
//    public void checkForQuit(String quit) {
//        if (quit.toLowerCase().equals("q")) {
//            exit();
//        }
//    }
//
//    //exits the application
//    public void exit() {
//        System.out.println("\nGoodbye!");
//        System.exit(0);
//    }
//
//    /**
//     * This method was adapted from a template for JSON Serialization as part of the course CPSC 210
//     * at the University of British Columbia written by Dr. Paul Carter
//     * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
//     */
//
//    // EFFECTS: saves the workroom to file
//    private void saveChessGame() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(board);
//            jsonWriter.close();
//            System.out.println("Saved Game Progress to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    /**
//     * This method was adapted from a template for JSON Serialization as part of the course CPSC 210
//     * at the University of British Columbia written by Dr. Paul Carter
//     * source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
//     */
//
//    // MODIFIES: this
//    // EFFECTS: loads chess board from file
//    private void loadChessGame() {
//        try {
//            board = jsonReader.read();
//            System.out.println("Loaded Game Progress from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//}

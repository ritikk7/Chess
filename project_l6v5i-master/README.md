# Chess

## The Classic Strategy Game

Features:
- This application can be used to play a game of **Chess** 
against a friend or keep track of your real-time **Chess** board 
moves by adding the moves to the application as you play in 
real life.
- Anyone interested in battling their wits against an opponent
 in **Chess** can use this application.
- **Chess** is my favorite board game and is challenging to program
because of the multitude of rules involved in the game. This makes
programming **Chess** the perfect opportunity to test my capabilities.

## User Stories

- As a user, I want to be able to setup a chess board by adding Chess Pieces to a Chess Board and make a list of the killed pieces on each side.
- As a user, I want to be able take turns with my opponent to make moves in Chess.
- As a user, I want to be able to make valid moves according to the rules of the game. 
- As a user, I want to be able to checkmate my opponent by killing their King.
- As a user, I want to be able to save my progress in a Chess game.
- As a user, I want to be able to reload my progress from a loaded game.

## Phase 4: Task 2

Option 2: Type Hierarchy
- ChessPiece is an Abstract Class with 7 subclasses:
Bishop, Knight, Rook, King, Queen, Pawn and EmptySpace.
- The subclasses override the abstract method, isValidMove(Board board, Block startP, Block endP)

## Phase 4: Task 3

- I would refactor the getName() function in the subclasses of the ChessPiece Class since there is a repetition of code.
- I would refactor the printMove() function in the MoveHistoryPanel to have all the print functions in one place and improve the Cohesion.
- I would create a different class called Move which would handle the functioning related to every chess move instead putting the code directly in the UI classes.
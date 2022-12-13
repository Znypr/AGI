package main;

public class Logic implements FourWinsLogic, TicTacToeLogic {

    private final int MAX_TicTacToe = 9;
    private final int MAX_FourWins = 42;
    private int MAX_WinLength;

    private final int ROWS;
    private final int COLS;
    private Player[][] board = null;
    private int counter = 0;

    public Logic (int column, int row ){
        COLS = column;
        ROWS = row;
        board = new Player[column][row];
        MAX_WinLength = 3;
    }
    public Logic (){
        COLS = 7;
        ROWS = 6;
        board = new Player[COLS][ROWS];
        MAX_WinLength = 4;
    }

    @Override
    public Result setChip(Player chip, int column, int row) {

        if(checkOutOfBoundsHorizontal(column) || checkOutOfBoundsVertical(row))
            return Result.ERROR;

        if(!insert(chip, column, row))
            return Result.ERROR;

        if(checkWinHorizontal(chip, row)) return handleWinner(chip);

        if (checkWinVertical(chip,column)) return handleWinner(chip);

        if (checkWinDiagonal(chip, row, column)) return handleWinner(chip);

        if (counter==MAX_TicTacToe)
            return Result.TIE;

        return Result.NOTHING;
    }

    @Override
    public Result throwChip(Player chip, int column) {

        if(checkOutOfBoundsHorizontal(column))
            return Result.ERROR;

        int row = insert(chip,column);
        if(row < 0) return Result.ERROR;

        if (checkWinHorizontal(chip, row)) return handleWinner(chip);

        if (checkWinVertical(chip,column)) return handleWinner(chip);

        if (checkWinDiagonal(chip, row, column)) return handleWinner(chip);

        if (counter==MAX_FourWins)
            return Result.TIE;

        return Result.NOTHING;
    }

    private Result handleWinner(Player chip) {
        if(chip == Player.BLUE)
            return Result.WIN_BLUE;
        return Result.WIN_RED;
    }

    private int insert(Player chip, int column) {
        for(int i=0; i<ROWS; i++) {
            if(board[column][i] == null) {
                board[column][i] = chip;
                counter++;
                return i;
            }
        }
        return -1;
    }

    private boolean insert(Player chip, int column, int row) {

        if(board[column][row]!=null)
            return false;
        board[column][row] = chip;
        counter++;
        return true;
    }

    private boolean checkOutOfBoundsHorizontal(int column){
        return column < 0 || column >= COLS;
    }

    private boolean checkOutOfBoundsVertical(int row) {
        return row < 0 || row >= ROWS;
    }

    private boolean checkWinHorizontal(Player chip, int row) {

        // für den Fall dass sich um TicTacToe handelt
        int borderCase = 1; // für ticTacToe gibt es nur einen Fall

        // für den Fall dass es sich um FourWins handelt
        if(COLS > 3){
            borderCase = 4; // bei Horizontal gibt es vier Fälle
        }

        int counter = 0;
        for (int i=0; i < borderCase; i++) { // vier Fälle oder einen Fall // vorher stand hier cols - 2, das war bei fourWins ein Fall zuviel
            counter=0; // hier muss der Counter wieder genullt werden, ansonsten wird der Counter für eine bestimmte Stelle doppelt gezählt
            for (int j=0; j<MAX_WinLength; j++) { // hier muss auch zwischen den 2 Spielen durch MAX_WinLength unterschieden werden
                if(board[i+j][row] == null) {
                    break;
                }
                if(board[i+j][row]==chip) counter++;
                else counter=0;
                if (counter== MAX_WinLength) return true;
            }
        }
        return false;
    }

    private boolean checkWinVertical(Player chip, int column) {

        // für den Fall dass sich um TicTacToe handelt
        int borderCase = 1; // für ticTacToe nur gibt es nur einen Fall

        // für den Fall dass sich um FourWins handelt
        if(COLS > 3){
            borderCase = 3; // bei Vertikal gibt es 3 Fälle
        }

        int counter =0;
        for(int i=0; i < borderCase; i++) { // drei Fälle oder ein Fall // vorher stand hier rows - 2, das war bei fourWins ein Fall zuviel
           counter=0; // hier muss der Counter wieder genullt werden, ansonsten wird der Counter für eine bestimmte Stelle doppelt gezählt
            for(int j=0; j<MAX_WinLength; j++) { // hier muss auch zwischen den 2 Spielen durch MAX_WinLength unterschieden werden
                if(board[column][i+j]==null) {
                    break;
                }
                if(board[column][i+j]==chip) counter++;
                else counter=0;
                if(counter == MAX_WinLength) return true;
            }
        }
        return false;
    }

    private boolean checkWinDiagonal(Player chip, int row, int column){

        // nach links unten
        int counter = 1;
        for(int i = 1; i < MAX_WinLength; i++){
            if (column-i >= 0 && row-i >= 0) {
              if(board[column-i][row-i] == chip){
                  counter += 1;
              }
            }
        }

        if(counter== MAX_WinLength) {
            return true;
        }

        // nach rechts oben
        counter = 1;
        for(int i = 1; i < MAX_WinLength; i++){
            if (column+i < COLS && row+i < ROWS) {
                if(board[column+i][row+i] == chip){
                    counter += 1;
                }
            }
        }

        if(counter== MAX_WinLength) {
            return true;
        }

        // nach rechts unten
        counter = 1;
        for(int i = 1; i < MAX_WinLength; i++){
            if (column - i >= 0 && row+i < ROWS) {
                if(board[column-i][row+i] == chip){
                    counter += 1;
                }
            }
        }

        if(counter== MAX_WinLength) {
            return true;
        }

        // nach links oben
        counter = 1;
        for(int i = 1; i < MAX_WinLength; i++){
            if (column + i < COLS && row-i >= 0) {
                if(board[column+i][row-i] == chip){
                    counter += 1;
                }
            }
        }

        return counter == MAX_WinLength;
    }

}
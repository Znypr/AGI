package main;

public class Logic implements FourWinsLogic, TicTacToeLogic {

    private final int MaxChips_TicTacToe = 9;
    private final int MaxChips_FourWins = 42;
    private int MAX_WinLength;

    private final int ROWS;
    private final int COLS;
    private Player[][] board = null;
    private int counter = 0;

    public Logic (int col, int row ){
        COLS = col;
        ROWS = row;
        board = new Player[col][row];
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

        if(checkWinHorizontal(chip, row)) return announceWinner(chip);

        if (checkWinVertical(chip,column)) return announceWinner(chip);

        if (checkWinDiagonal(chip, row, column)) return announceWinner(chip);

        return checkTie(MaxChips_TicTacToe);
    }

    @Override
    public Result throwChip(Player chip, int column) {

        if(checkOutOfBoundsHorizontal(column))
            return Result.ERROR;

        int row = insert(chip,column);
        if(row < 0) return Result.ERROR;

        if (checkWinHorizontal(chip, row)) return announceWinner(chip);

        if (checkWinVertical(chip,column)) return announceWinner(chip);

        if (checkWinDiagonal(chip, row, column)) return announceWinner(chip);

        return checkTie(MaxChips_FourWins);
    }

    private Result checkTie(int maxChips) {
        if (counter==maxChips)
            return Result.TIE;
        else
            return Result.NOTHING;
    }

    private Result announceWinner(Player chip) {
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
        int counter = 0;
        for (int i = 0; i<COLS- MAX_WinLength +1; i++) {
            counter=0;
            for (int j = 0; j< MAX_WinLength; j++) {
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
        int counter =0;
        for(int i = 0; i<ROWS- MAX_WinLength +1; i++) {
            counter = 0;
            for(int j = 0; j< MAX_WinLength; j++) {
                if(board[column][i+j]==null) {
                    break;
                }
                if(board[column][i+j]==chip) counter++;
                else counter=0;
                if(counter== MAX_WinLength) return true;
            }
        }
        return false;
    }

    private boolean checkWinDiagonal(Player chip, int row, int column){

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
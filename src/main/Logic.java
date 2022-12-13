package main;

public class Logic implements FourWinsLogic, TicTacToeLogic {

    private final int MAX_TicTacToe = 9;
    private final int MAX_FourWins = 42;

    private final int ROWS;
    private final int COLS;
    private Player[][] board = null;
    private int counter = 0;

    public Logic (int col, int row ){
        COLS = col;
        ROWS = row;
        board = new Player[col][row];
    }
    public Logic (){
        COLS = 7;
        ROWS = 6;
        board = new Player[COLS][ROWS];
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

        return true;
    }

    private boolean checkOutOfBoundsHorizontal(int column){
        return column < 0 || column >= COLS;
    }

    private boolean checkOutOfBoundsVertical(int row) {
        return row < 0 || row >= ROWS;
    }

    private boolean checkWinHorizontal(Player chip, int row) {
        boolean wins = true;
        for (int i=0; i<COLS-2; i++) {

            for (int j=0; j<3; j++) { // 4 magic number
                if(board[i+j][row] == null)
                    break;
                wins &= board[i+j][row]==chip;
            }
        }
        return wins;
    }

    private boolean checkWinVertical(Player chip, int column) {

        return board[column][0] == Player.BLUE &&
                board[column][1] == Player.BLUE &&
                board[column][2] == Player.BLUE &&
                board[column][3] == Player.BLUE
                || board[column][2] == Player.BLUE &&
                board[column][3] == Player.BLUE &&
                board[column][4] == Player.BLUE &&
                board[column][5] == Player.BLUE
                || board[column][1] == Player.BLUE &&
                board[column][2] == Player.BLUE &&
                board[column][3] == Player.BLUE &&
                board[column][4] == Player.BLUE;
    }

    private boolean checkWinDiagonal(Player chip, int row, int column){

        int counter = 1;
        for(int i = 1; i < 4;i++){
            if (column-i >= 0 && row-i >= 0) {
              if(board[column-i][row-i] == chip){
                  counter += 1;
              }
            }
        }

        if(counter==4) {
            return true;
        }

        counter = 1;
        for(int i = 1; i < 4;i++){
            if (column+i < 7 && row+i < 6) {
                if(board[column+i][row+i] == chip){
                    counter += 1;
                }
            }
        }

        if(counter==4) {
            return true;
        }

        counter = 1;
        for(int i = 1; i < 4;i++){
            if (column - i >= 0 && row+i < 6) {
                if(board[column-i][row+i] == chip){
                    counter += 1;
                }
            }
        }

        if(counter==4) {
            return true;
        }

        counter = 1;
        for(int i = 1; i < 4;i++){
            if (column + i < 7 && row-i >= 0) {
                if(board[column+i][row-i] == chip){
                    counter += 1;
                }
            }
        }

        return counter == 4;
    }

}
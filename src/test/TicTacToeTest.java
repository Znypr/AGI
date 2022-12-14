package test;

import main.Logic;
import main.Player;
import main.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TicTacToeTest {

    @Test
    public void checkWinDiagonalCase1() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0,0);
        o.setChip(Player.BLUE, 1,1);

        Result r = o.setChip(Player.BLUE, 2,2);
        assertEquals(Result.WIN_BLUE, r);
    }

    @Test
    public void checkWinDiagonalCase2() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0,2);
        o.setChip(Player.BLUE, 1,1);

        Result r = o.setChip(Player.BLUE, 2,0);
        assertEquals(Result.WIN_BLUE, r);
    }


    @Test
    public void checkWinHorizontalCase1() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0,0);
        o.setChip(Player.BLUE, 1,0);

        Result r = o.setChip(Player.BLUE, 2,0);
        assertEquals(Result.WIN_BLUE, r);
    }

    @Test
    public void checkWinHorizontalCase2() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0,2);
        o.setChip(Player.BLUE, 1,2);

        Result r = o.setChip(Player.BLUE, 2,2);
        assertEquals(Result.WIN_BLUE, r);
    }



    @Test
    public void checkWinVerticalCase1() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0,0);
        o.setChip(Player.BLUE, 0,1);

        Result r = o.setChip(Player.BLUE, 0,2);
        assertEquals(Result.WIN_BLUE, r);
    }

    @Test
    public void checkWinVerticalCase2() {

        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 2,0);
        o.setChip(Player.BLUE, 2,1);

        Result r = o.setChip(Player.BLUE, 2,2);
        assertEquals(Result.WIN_BLUE, r);
    }



    @Test
    public void checkOutOfBoundsCase1() {

        Logic o = new Logic(3,3);

        Result r = o.setChip(Player.BLUE, 3,1);
        assertEquals(Result.ERROR, r);
    }

    @Test
    public void checkOutOfBoundsCase2() {

        Logic o = new Logic(3,3);

        Result r = o.setChip(Player.BLUE, -1,1);
        assertEquals(Result.ERROR, r);
    }

    @Test
    public void checkOutOfBoundsCase3() {

        Logic o = new Logic(3,3);

        Result r = o.setChip(Player.BLUE, 1,3);
        assertEquals(Result.ERROR, r);
    }

    @Test
    public void checkOutOfBoundsCase4() {

        Logic o = new Logic(3,3);

        Result r = o.setChip(Player.BLUE, 1,-1);
        assertEquals(Result.ERROR, r);
    }



    @Test
    public void checkIfAllocated() {

        Logic o = new Logic(3,3);
        o.setChip(Player.BLUE, 1, 1);

        Result r = o.setChip(Player.BLUE, 1,1);
        assertEquals(Result.ERROR, r);
    }



    @Test
    public void checkTie() {
        Logic o = new Logic(3,3);

        o.setChip(Player.BLUE, 0, 0);
        o.setChip(Player.RED, 1, 0);
        o.setChip(Player.BLUE, 2, 0);

        o.setChip(Player.RED, 0, 1);
        o.setChip(Player.BLUE, 1, 1);
        o.setChip(Player.RED, 2, 1);

        o.setChip(Player.RED, 0, 2);
        o.setChip(Player.BLUE, 1, 2);

        Result r = o.setChip(Player.RED, 2,2);
        assertEquals(Result.TIE, r);
    }
}

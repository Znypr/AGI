package test;

import main.Logic;
import main.Player;
import main.Result;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FourWinsTest {

    @Test
    public void checkIfOutOfBounds1() {

        Logic o = new Logic();
        assertEquals(Result.ERROR,o.throwChip(Player.BLUE, -1));
    }

    @Test
    public void checkIfOutOfBounds2() {

        Logic o = new Logic();
        assertEquals(Result.ERROR,o.throwChip(Player.BLUE, 7));
    }


    @Test
    public void checkWinVerticalCase1() {

        Logic o = new Logic();

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 0);

        Result r = o.throwChip(Player.BLUE, 0);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinVerticalCase2() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.RED, 0);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 0);

        Result r = o.throwChip(Player.BLUE, 0);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinVerticalCase3() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.BLUE, 6);

        Result r = o.throwChip(Player.BLUE, 6);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinVerticalCase4() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 6);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.BLUE, 6);

        Result r = o.throwChip(Player.BLUE, 6);
        assertEquals(Result.WIN_BLUE, r);

    }


    @Test
    public void checkWinHorizontalCase1() {

        Logic o = new Logic();

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.BLUE, 2);

        Result r = o.throwChip(Player.BLUE, 3);
        assertEquals(Result.WIN_BLUE, r);
    }

    @Test
    public void checkWinHorizontalCase2() {

        Logic o = new Logic();

        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.BLUE, 5);

        Result r = o.throwChip(Player.BLUE, 6);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinHorizontalCase3() {

        Logic o = new Logic();

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.BLUE, 2);

        Result r = o.throwChip(Player.BLUE, 3);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinHorizontalCase4() {

        Logic o = new Logic();

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.BLUE, 5);

        Result r = o.throwChip(Player.BLUE, 6);
        assertEquals(Result.WIN_BLUE, r);

    }


    @Test
    public void checkWinDiagonalCase1() {

        Logic o = new Logic();

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);

        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 2);

        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.BLUE, 3);

        Result r = o.throwChip(Player.RED, 3);
        assertEquals(Result.WIN_RED, r);

    }

    @Test
    public void checkWinDiagonalCase2() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        Result r = o.throwChip(Player.BLUE, 6);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinDiagonalCase3() {

        Logic o = new Logic();


        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.BLUE, 5);

        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.BLUE, 4);

        Result r = o.throwChip(Player.BLUE, 3);
        assertEquals(Result.WIN_BLUE, r);

    }

    @Test
    public void checkWinDiagonalCase4() {

        Logic o = new Logic();


        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        //o.throwChip(Player.BLUE, 3);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.BLUE, 1);

        o.throwChip(Player.BLUE, 0);

        Result r = o.throwChip(Player.BLUE, 3);
        assertEquals(Result.WIN_BLUE, r);

    }


    @Test
    public void checkOverflow1() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 0);

        Result r = o.throwChip(Player.RED, 0);
        assertEquals(Result.ERROR, r);
    }

    @Test
    public void checkOverflow2() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 6);
        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.RED, 6);
        o.throwChip(Player.BLUE, 6);
        o.throwChip(Player.RED, 6);
        o.throwChip(Player.BLUE, 6);

        Result r = o.throwChip(Player.RED, 6);
        assertEquals(Result.ERROR, r);
    }


    @Test
    public void checkTie() {
        Logic o = new Logic();

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.RED, 0);
        o.throwChip(Player.BLUE, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.RED, 4);
        o.throwChip(Player.BLUE, 5);
        o.throwChip(Player.RED, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);
        o.throwChip(Player.BLUE, 6);

        o.throwChip(Player.BLUE, 0);
        o.throwChip(Player.RED, 1);
        o.throwChip(Player.BLUE, 2);
        o.throwChip(Player.RED, 3);
        o.throwChip(Player.BLUE, 4);
        o.throwChip(Player.RED, 5);

        assertEquals(Result.TIE, o.throwChip(Player.BLUE, 6));
    }

    @Test
    public void test() {
        Logic o = new Logic();

        o.throwChip(Player.RED, 1);
        o.throwChip(Player.RED, 2);
        o.throwChip(Player.BLUE, 3);
        o.throwChip(Player.BLUE, 4);
        Result r = o.throwChip(Player.BLUE, 5);
        assertEquals(Result.NOTHING, r);
    }
}

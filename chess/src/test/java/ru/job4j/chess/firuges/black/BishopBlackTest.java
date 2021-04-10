package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bb = new BishopBlack(Cell.B3);
        assertThat(bb.position(), is(Cell.B3));
    }

    public void testWay() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] rez = {Cell.D2, Cell.E3,Cell.F4,Cell.G5};
        assertThat(bb.way(Cell.C1, Cell.G5), is(rez));
    }

    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.B3);
        assertThat(bb.copy(Cell.C4).position(), is(Cell.C4));
    }
}
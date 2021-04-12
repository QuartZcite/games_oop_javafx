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
        Cell source = Cell.C1;
        Cell dest = Cell.G5;
        Cell[] rez = {Cell.D2, Cell.E3,Cell.F4,Cell.G5};
        BishopBlack bb = new BishopBlack(source);
        assertThat(bb.way(dest), is(rez));
    }

    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.B3);
        assertThat(bb.copy(Cell.C4).position(), is(Cell.C4));
    }
}
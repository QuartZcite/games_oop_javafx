package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

 //   @Ignore
    @Test
    public void move() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void wayFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Cell source = Cell.C4;
        Cell dest = Cell.E6;
        BishopBlack bishopBlack = new BishopBlack(source);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        assertThat(logic.move(source, dest), is(true));
    }

    @Test(expected =  OccupiedCellException.class)
    public void wayIsNotFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Cell source = Cell.C4;
        Cell middle = Cell.D5;
        Cell dest = Cell.E6;
        BishopBlack bishopBlack = new BishopBlack(source);
        BishopBlack bishopBlack2 = new BishopBlack(middle);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(bishopBlack2);
        logic.move(source, dest);
    }

    @Test(expected =  FigureNotFoundException.class)
    public void FigureIsNotExist() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Cell source = Cell.C4;
        Cell dest = Cell.E6;
        Logic logic = new Logic();
        logic.move(source, dest);
    }
}
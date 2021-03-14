package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        assertThat(bishop.position(), is(Cell.F8));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.D6);
        assertThat(bishop.copy(Cell.F8).position(), is(Cell.F8));
    }

    @Test
    public void whenWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.way(Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
        }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayException() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.C2);
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.isDiagonal(bishop.position(), Cell.G5), is(true));
    }
}

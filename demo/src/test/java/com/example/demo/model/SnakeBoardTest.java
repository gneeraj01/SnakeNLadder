package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SnakeBoardTest {
	private SnakeBoard board;

	@BeforeEach
	public void setup() {
		List<BoardCell> cells = fillCells(100);
		board = new SnakeBoard(cells);
	}

	@Test
	public void getNextPosTest() throws Exception {
		int nextPosition = board.moveToNextPos(2, 5);
		assertEquals(nextPosition, 7);
	}
	
	@Test
	@DisplayName("Test for next when curr pos is at END")
    public void testGetNextPositionWhenCurrentPositionIsAtEnd() throws Exception {
        int nextPosition = board.moveToNextPos(100, 5);
        assertEquals(100, nextPosition);
    }

	@Test
	@DisplayName("Test Position when snake is at 14 pos")
	public void testGetPositionWhenSnakeIsAt14Pos() throws Exception {
		board.getCells().set(10, new BoardCell(14, new Snake(7)));
		int nextPosition = board.moveToNextPos(13, 1);
		assertEquals(7, nextPosition);
	}

	/**
	 * filling board cell till 100
	 * 
	 * @param numberOfCells
	 * @return
	 */
	public List<BoardCell> fillCells(int numCells) {
		List<BoardCell> cells = new ArrayList<>();
		for (int i = 1; i <= numCells; i++) {
			cells.add(new BoardCell(i, new DefaultMove()));
		}
		return cells;
	}
}

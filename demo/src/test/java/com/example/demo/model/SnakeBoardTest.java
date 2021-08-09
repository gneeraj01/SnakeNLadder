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
		
		
		board.getCells().set(5, new BoardCell(25, new Snake(5)));
		nextPosition = board.moveToNextPos(23, 2);
		assertEquals(5, nextPosition);
		
		board.getCells().set(15, new BoardCell(30, new Snake(0), true));
		nextPosition = board.moveToNextPos(25, 5);
		assertEquals(0, nextPosition);
		
	}

	@Test
	@DisplayName("Test Position when green snake bite onces")
	public void testGetPositionWhenGreenSnake() throws Exception {

		// Green Snake bites first time(only once) then move to snake next pos
		GreenSnake greenSnake = new GreenSnake(7);
		board.getCells().set(11, new BoardCell(15, greenSnake));
		int nextPosition = board.moveToNextPos(13, 2);
		assertEquals(7, nextPosition);

		// Green Snake bites second time then be on same position
		BoardCell boardCell = new BoardCell(15, greenSnake);
		boardCell.setMove(greenSnake);
		board.getCells().set(15, boardCell);
		nextPosition = board.moveToNextPos(13, 2);
		assertEquals(15, nextPosition);

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

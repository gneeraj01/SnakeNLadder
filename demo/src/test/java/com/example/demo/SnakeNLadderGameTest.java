package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.game.SnakeNLadderGame;
import com.example.demo.model.BoardCell;
import com.example.demo.model.DefaultMove;
import com.example.demo.model.Player;
import com.example.demo.model.SnakeBoard;
import com.example.demo.strategy.MockDice;
import com.example.demo.strategy.RollingDice;

@SpringBootTest
public class SnakeNLadderGameTest {

	private SnakeNLadderGame game;
	List<Player> playerList;
	SnakeBoard board;
	RollingDice dice;

	@BeforeEach
	public void before() {

		playerList = new ArrayList<>();
		playerList.add(new Player(0, "testPlayer1"));
		playerList.add(new Player(0, "testPlayer2"));
		List<BoardCell> cells = fillCells(100);
		board = new SnakeBoard(cells);
		dice = new MockDice();
		game = new SnakeNLadderGame(board, dice, playerList);
	}

	@Test
	@DisplayName("Test for Player")
	public void playTest() throws Exception {
		System.out.println("x");
		Player p = new Player(1, "Test");
		game.setDice(new MockDice());
		game.play(p);
		assertEquals(p.getPosition(),26,"Positon should match 26");
		
	}
	
	@Test
	@DisplayName("Test for game")
    public void endGameTest() throws Exception {
        Player p1 = playerList.get(0);
        Player p2 = playerList.get(1);
        game.play(game.getNextPlayerToPlay());
        assertEquals(25, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        assertEquals(25, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        assertEquals(50, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        assertEquals(50, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        assertEquals(75, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        assertEquals(75, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        //reach the last
        assertEquals(100, p1.getPosition());        
        assertEquals(p1, game.getRes().get(1));
        p1.setPosition(0);
        p2.setPosition(0);
        game.getPlayerQueue().add(p1);
    }

	@Test()
	@DisplayName("Test for invalid Player")
	public void testInvalidPlayerPlay() throws Exception {
        Player player = new Player(1, "Test");
        player.setPosition(100);
        
        assertThrows(Exception.class, () -> {
        	game.play(player);
        });
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

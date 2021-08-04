package com.example.demo.game;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.example.demo.model.Player;
import com.example.demo.model.SnakeBoard;
import com.example.demo.strategy.RollingDice;

public class SnakeNLadderGame {
	
	 private SnakeBoard board;
	 private RollingDice dice;
     private Map<Integer, Player> res;
     private Queue<Player> playerQueue;
     private int winnerCount;
     
     public SnakeNLadderGame(SnakeBoard board, RollingDice dice, List<Player> playerList) {
		super();
		this.board = board;
		this.dice = dice;
		this.res = new HashMap<>();
		this.playerQueue = new ArrayDeque<>(playerList);
	}

	public Map<Integer, Player> getRes() {
         return res;
     }
     
     public Queue<Player> getPlayerQueue() {
         return playerQueue;
     }
     
     public void setDice(RollingDice dice) {
         this.dice = dice;
     }
     
     /**
      * Game start with players
      * @param player
      * @throws Exception
      */
     public void play(Player player) throws Exception {
         if(!(player.getPosition() == 100)) {
             int nextPosition = board.moveToNextPos(player.getPosition(), dice.rollDice());
             player.setPosition(nextPosition);
             changeGameState(player);
         } else throw new Exception("player already reach end of game");
     }
     
    /**
     * Update Game State
     * @param player
     */
	private void changeGameState(Player player) {
		// TODO Auto-generated method stub
		if (player.getPosition() == 100) {
            res.put(++winnerCount, player);
            if (playerQueue.size() == 1) {
                res.put(++winnerCount, playerQueue.poll());
            }
        } else playerQueue.add(player);
		
	}
	
	/**
	 * Fetch Next Player Position
	 * @return
	 * @throws GameOverException
	 */
	 public Player getNextPlayerToPlay() throws Exception {
	        if (playerQueue.size() <= 1)
	            throw new Exception("Game is already over");
	        return playerQueue.poll();
	    }
	
	/**
	 * Winner Result
	 * @param res
	 */
	private void declareResult(Map<Integer, Player> res) {
        res.forEach((k, v) -> System.out.println(v + "player won by " + k));
    }
}

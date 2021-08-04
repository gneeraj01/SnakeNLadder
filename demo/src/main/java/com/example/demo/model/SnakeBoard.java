package com.example.demo.model;

import java.util.List;
import java.util.Optional;

/**
 * Basic Board for Snake and Ladder Game
 * @author gneeraj
 *
 */

public class SnakeBoard {

	
	List<BoardCell> boardCells;

    public List<BoardCell> getCells() {
        return boardCells;
    }

    public SnakeBoard(List<BoardCell> boardCells) {
        this.boardCells = boardCells;
    }
    
    
    //move the player to next posittion and generate score 
    
    public int moveToNextPos(int currentPos, int score) throws Exception {
        if (currentPos < 0) {
            throw new Exception("Position should be greater than zero");
        }
        Optional<BoardCell> opNextPos = boardCells.stream().filter(cell -> cell.getPos() == currentPos + score)
        .findFirst();
        Integer newPos = currentPos;
        if(opNextPos.isPresent()) {
        	newPos = opNextPos.get().nextPos();
        }
        return newPos;
    }

    
}

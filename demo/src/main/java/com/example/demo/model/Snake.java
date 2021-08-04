package com.example.demo.model;

public class Snake extends Move {

	public Snake(int nextPos) {
		super(nextPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidPos(int cellPos) throws Exception {
		if(cellPos > nextPos) {
			return true;
		} else {
			throw new Exception("cell position should be always greater than end position of snake");
		}
	}

}

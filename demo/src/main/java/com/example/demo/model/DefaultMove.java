package com.example.demo.model;

//Base Move which will be initially zero
public class DefaultMove extends Move {

	public DefaultMove(int nextPos) {
		super(nextPos);
		// TODO Auto-generated constructor stub
	}
	
	public DefaultMove() {
		// TODO Auto-generated constructor stub
		super(0);
	}
	

	@Override
	public boolean isValidPos(int cellPos) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}

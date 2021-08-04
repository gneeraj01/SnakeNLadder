package com.example.demo.strategy;

import java.util.Random;

// A dice that only throws Even numbers.
public class CrookedDice implements RollingDice {

	@Override
	public int rollDice() {
		Random random = new Random();
		//generate random dice starting from 2 till 6
		int even = 2 + random.nextInt(3) * 2;
		return 0;
	}

}

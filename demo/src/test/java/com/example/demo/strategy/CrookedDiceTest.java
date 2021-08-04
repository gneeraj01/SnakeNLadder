package com.example.demo.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrookedDiceTest {
	
	@Test
	@DisplayName("Crooked Dice test")
    public void testCrookedDice() {
        int score = new CrookedDice().rollDice();
        assertEquals(0, score % 2);
    }

}

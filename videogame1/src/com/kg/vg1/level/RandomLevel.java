package com.kg.vg1.level;

import java.util.Random;

import com.kg.vg1.Game;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	protected void generateLevel() {
		for (int y = 0; y < height; y++ ) {
			for (int x = 0; x < width; x++) {
				if (x == 0 || y == 0 || x == (Game.width/16 - 1) || y == (Game.height /16 - 1)) {
					tiles[x+y*width] = 0;
				}
				else {
					tiles[x+y*width] = 1;
				}
			}
		}
	}
	
}

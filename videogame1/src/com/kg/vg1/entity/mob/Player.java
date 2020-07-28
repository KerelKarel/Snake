package com.kg.vg1.entity.mob;

import com.kg.vg1.graphics.Screen;
import com.kg.vg1.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up ^ input.down ^ input.right ^ input.left) {
			if (input.up && dir != 2) ya -= 16;
			if (input.down && dir != 0) ya += 16;
			if (input.right && dir != 3) xa += 16;
			if (input.left && dir != 1) xa -= 16;
			if (xa != 0 || ya != 0) move(xa, ya);
			else move(dir);
			}
		else move(dir);
	}
	
	public void render(Screen screen) {
		screen.renderPlayer(x, y, sprite.player);
	}
	
}

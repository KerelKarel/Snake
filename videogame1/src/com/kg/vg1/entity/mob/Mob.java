package com.kg.vg1.entity.mob;

import com.kg.vg1.Game;
import com.kg.vg1.entity.Entity;
import com.kg.vg1.entity.Tail;
import com.kg.vg1.graphics.Sprite;
import com.kg.vg1.item.Berry;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 2;
	
	public void move(int xa, int ya) { //keyboard
		//input: -1, 0, 1
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		
		if (!collision(xa, ya)) {
			int prevx = x;
			int prevy = y;
			x += xa;
			y += ya;
			berrypickup(x,y,prevx,prevy);
		}
		else {
			Game.setRunning(false);
			System.out.println("Game over");
		}
		
	}
	public void move(int dir) { //keyboard
		int xa=0, ya=0;
		//input: -1, 0, 1
		if (dir == 1) xa += 16;
		if (dir == 3) xa -= 16;
		if (dir == 2) ya += 16;
		if (dir == 0) ya -= 16;
		if (!collision(xa, ya)) {
			int prevx = x;
			int prevy = y;
			x += xa;
			y += ya;
			berrypickup(x,y,prevx,prevy);
		}
		else {
			Game.setRunning(false);
			System.out.println("Game over");
		}
	}
	
	
	public void update() {
		
	}
	
	private boolean collision(int xa, int ya) {
		if (level.getTile(((x+xa) >> 4), ((y+ya) >> 4)).solid() || Tail.collision((x+xa), (y+ya))) {
			return true;
		}
		return false;
	}
	
	private void berrypickup(int x, int y, int prevx, int prevy) {
		if (Berry.getxb() == x && Berry.getyb() == y) {
			Berry.remove();
			Berry.incBerry();
			Tail.updateberry(prevx, prevy);
		}
		else Tail.updatenormal(prevx, prevy);
	}
	
	public void render() {
		
	}
	
}
